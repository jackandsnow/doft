package com.doft.service;

import com.doft.dao.DishMapper;
import com.doft.dao.DishTypeMapper;
import com.doft.dao.SaleNumMapper;
import com.doft.pojo.Dish;
import com.doft.pojo.DishType;
import com.doft.pojo.SaleNum;
import com.doft.util.DateTimeUtil;
import com.doft.vo.SaleAmountVo;
import com.doft.vo.SaleManageVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by Jack at 20:18 2018/3/20
 * version 1.0
 */
@Service
public class SaleService {

    @Autowired
    private SaleNumMapper saleNumMapper;
    @Autowired
    private DishMapper dishMapper;
    @Autowired
    private DishTypeMapper dishTypeMapper;

    /**
     * 分页获取菜品的销量记录
     *
     * @param dishTypeName 菜系名，可为null
     * @param currentPage  当前页
     * @param pageSize     每页显示条数
     * @return
     */
    public PageInfo<SaleManageVo> getDishSalePages(String dishTypeName, Integer currentPage, Integer pageSize) {

        PageHelper.startPage(currentPage, pageSize);
        List<SaleManageVo> saleManageVoList = newArrayList();
        // 查询所有菜系的菜品销量
        if (StringUtils.isEmpty(dishTypeName)) {
            // 获取所有不同菜品的ID
            List<Long> dishIdList = saleNumMapper.selectDistinctDishId();

            if (CollectionUtils.isNotEmpty(dishIdList)) {
                // 遍历每个菜品ID，获取每个菜品的相关信息
                dishIdList.forEach(id -> {
                    SaleManageVo manageVo = new SaleManageVo();
                    Dish dish = dishMapper.selectByPrimaryKey(id);
                    DishType dishType = dishTypeMapper.selectByPrimaryKey(dish.getDishTypeId());
                    manageVo.setDishId(id);
                    manageVo.setDishName(dish.getDishName());
                    manageVo.setDishTypeName(dishType.getTypeName());
                    manageVo.setRecommendIndex(dish.getRecommendIndex());
                    manageVo.setTotalSales(Long.valueOf(0));
                    // 获取每个菜品的销量记录
                    List<Long> numbers = saleNumMapper.selectByDishId(id);
                    numbers.forEach(s -> manageVo.setTotalSales(manageVo.getTotalSales() + s));
                    saleManageVoList.add(manageVo);
                });
                PageInfo pageResult = new PageInfo(dishIdList);
                pageResult.setList(saleManageVoList);
                return pageResult;
            }
        }
        // 按菜系查询菜品销量
        else {
            // 获取所有菜系列表
            List<DishType> dishTypeList = dishTypeMapper.selectAllDishType();
            for (DishType type : dishTypeList) {
                // 匹配目标菜系
                if (dishTypeName.equals(type.getTypeName())) {
                    // 获取目标菜系的所有菜品
                    List<Dish> dishList = dishMapper.selectByDishType(type.getDishTypeId());
                    // 记录该菜系中有销售记录的菜品数量，用于初始化分页
                    List<Integer> count = newArrayList();
                    for (Dish dish : dishList) {
                        // 查找有销售记录的菜品的销量
                        List<Long> numbers = saleNumMapper.selectByDishId(dish.getDishId());
                        if (CollectionUtils.isNotEmpty(numbers)) {
                            count.add(1);
                            SaleManageVo manageVo = new SaleManageVo();
                            manageVo.setDishId(dish.getDishId());
                            manageVo.setDishName(dish.getDishName());
                            manageVo.setDishTypeName(dishTypeName);
                            manageVo.setRecommendIndex(dish.getRecommendIndex());
                            manageVo.setTotalSales(Long.valueOf(0));
                            numbers.forEach(n -> manageVo.setTotalSales(manageVo.getTotalSales() + n));
                            saleManageVoList.add(manageVo);
                        }
                    }
                    PageInfo pageResult = new PageInfo(count);
                    pageResult.setList(saleManageVoList);
                    return pageResult;
                }
            }
        }
        return new PageInfo<>(newArrayList());
    }

    /**
     * 获取当日至回退到dayCount那日的销售额情况
     * @param dayCount
     * @return
     */
    public List<SaleAmountVo> getSaleAmount(int dayCount) {
        DateTime now = new DateTime();
        List<SaleAmountVo> voList = newArrayList();
        for (int i = 0; i < dayCount; i++) {
            SaleAmountVo vo = new SaleAmountVo();
            // 设置一天的开始和结束时间
            DateTime begin = new DateTime(DateTimeUtil.getZeroTime(now.toDate()));
            DateTime end = new DateTime(DateTimeUtil.getZeroTime(now.plusDays(1).toDate()));

            vo.setDate(DateTimeUtil.DateToyyMMddString(begin.toDate()));
            // 获取这一天内的所有销售记录
            List<SaleNum> saleNumList = saleNumMapper.selectByBeginAndEndTime(begin.toString(), end.toString());
            for (SaleNum saleNum : saleNumList) {
                Dish dish = dishMapper.selectByPrimaryKey(saleNum.getDishId());
                // 计算某个菜品的销售额
                BigDecimal sum = dish.getPrice().multiply(BigDecimal.valueOf(saleNum.getDaySaleNumber()));
                vo.setAmount(vo.getAmount().add(sum));
            }
            voList.add(vo);
            now = now.minusDays(1);
        }
        return voList;
    }


}
