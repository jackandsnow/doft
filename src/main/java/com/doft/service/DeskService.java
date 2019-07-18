package com.doft.service;

import com.doft.common.constant.EnumDeskStatus;
import com.doft.dao.DeskMapper;
import com.doft.pojo.Desk;
import com.doft.vo.DeskVo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by Jack at 10:09 2018/3/16
 * version 1.0
 */
@Service
public class DeskService {

    @Autowired
    private DeskMapper deskMapper;

    @Transactional
    public void initDeskByCount(Long count) {
        // 获取空闲且有效的餐桌列表
        List<Desk> trueFreeDeskList = deskMapper.getDeskListTrueValidFlagAndFree();
        // 获取有效的餐桌列表
        List<Desk> trueDeskList = deskMapper.getDeskListByValidFlag(Boolean.TRUE);
        // 获取无效的餐桌列表
        List<Desk> falseDeskList = deskMapper.getDeskListByValidFlag(Boolean.FALSE);
        if (trueDeskList.size() < count) {
            long number = 0;
            // set desk valid flag from false to true
            if (CollectionUtils.isNotEmpty(falseDeskList)) {
                number = falseDeskList.size() <= count - trueDeskList.size() ?
                        falseDeskList.size() : trueDeskList.size() + falseDeskList.size() - count;
                updateDesk(falseDeskList, number, Boolean.TRUE);
            }
            // insert new desks
            insertMultiDesk(count - trueDeskList.size() - number);
        }
        // set desk valid flag from true to false
        else {
            updateDesk(trueFreeDeskList, trueDeskList.size() - count, Boolean.FALSE);
        }
    }

    @Transactional
    public void updateDesk(List<Desk> deskList, long count, Boolean valid) {
        for (long i = 0; i < count; i++) {
            Desk desk = deskList.get(Long.valueOf(i).intValue());
            desk.setIsValidFlag(valid);
            if (!valid) {
                desk.setDeskStatus(EnumDeskStatus.FREE.getCode());
            }
            deskMapper.updateByPrimaryKey(desk);
        }
    }

    @Transactional
    public void insertMultiDesk(long count) {
        for (long i = 0; i < count; i++) {
            Desk desk = new Desk();
            desk.setDeskStatus(EnumDeskStatus.FREE.getCode());
            desk.setIsValidFlag(Boolean.TRUE);
            deskMapper.insert(desk);
        }
    }

    /**
     * 生成 1 ~ freeDeskList.size() 之间的随机数，用于分配餐桌
     * 若没有空闲餐桌，则返回0
     */
    public Long getRandomFreeDeskId() {
        List<Long> deskIdList = deskMapper.getFreeDeskIdList();
        if (CollectionUtils.isNotEmpty(deskIdList)) {
            Random random = new Random(System.currentTimeMillis());
            int rand = Math.abs(random.nextInt()) % deskIdList.size();
            return deskIdList.get(rand);
        }
        return Long.valueOf(0);
    }

    /**
     * 返回餐桌总量，空闲餐桌量和已用餐桌量
     */
    public String getDeskTotal() {
        StringBuilder builder = new StringBuilder();
        Long free = deskMapper.selectByDeskStatus(EnumDeskStatus.FREE.getCode());
        Long busy = deskMapper.selectByDeskStatus(EnumDeskStatus.BUSY.getCode());
        builder.append((free + busy) + "/100%,");
        long busyPercent = busy * 100 / (free + busy);
        builder.append(busy + "/" + busyPercent + "%,");
        long freePercent = 100 - busyPercent;
        builder.append(free + "/" + freePercent + "%");
        return builder.toString();
    }

    /**
     * 返回所有可用餐桌的ID和状态
     */
    public List<DeskVo> getDeskList() {
        List<Desk> desks = deskMapper.getDeskListByValidFlag(Boolean.TRUE);
        if (CollectionUtils.isNotEmpty(desks)) {
            return desks.stream().map(d -> new DeskVo(d))
                    .collect(Collectors.toList());
        }
        return newArrayList();
    }

}
