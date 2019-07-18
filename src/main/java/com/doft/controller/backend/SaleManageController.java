package com.doft.controller.backend;

import com.doft.common.ServerResponse;
import com.doft.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.doft.common.ctrl.CtrlHelper.dealAjaxRequest;

/**
 * Created by Jack at 20:09 2018/3/20
 * version 1.0
 */
@Controller
@CrossOrigin
@RequestMapping(value = "/doft/manage/sale")
public class SaleManageController {

    @Autowired
    private SaleService saleService;

    private static final int WEEK = 7;

    private static final int MONTH = 30;

    /**
     * 分页获取菜品的销量记录
     */
    @ResponseBody
    @RequestMapping(value = "/getDishSalePages.aj")
    public ServerResponse getDishSalePages(String dishTypeName, @RequestParam(value = "currentPage", defaultValue = "1")
            Integer currentPage, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {

        return dealAjaxRequest(() -> saleService.getDishSalePages(dishTypeName, currentPage, pageSize));
    }

    /**
     * 获取一周的销量
     */
    @ResponseBody
    @RequestMapping(value = "/getWeekSaleAmount.aj")
    public ServerResponse getWeekSaleAmount() {
        return dealAjaxRequest(() -> saleService.getSaleAmount(WEEK));
    }

    /**
     * 获取一个月的销量
     */
    @ResponseBody
    @RequestMapping(value = "/getMonthSaleAmount.aj")
    public ServerResponse getMonthSaleAmount() {
        return dealAjaxRequest(() -> saleService.getSaleAmount(MONTH));
    }

}
