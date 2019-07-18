package com.doft.controller.portal;

import com.doft.common.Const;
import com.doft.common.ServerResponse;
import com.doft.common.constant.EnumResponseCode;
import com.doft.pojo.User;
import com.doft.service.IDishService;
import com.doft.service.IDishTypeService;
import com.doft.vo.DishDetailVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@CrossOrigin
@RequestMapping("/dish/")
public class DishController {

    @Autowired
    private IDishService iDishService;

    @Autowired
    private IDishTypeService iDishTypeService;


    @RequestMapping("detail.do")
    @ResponseBody
    public ServerResponse<DishDetailVo> detail(Long dishId){
        return iDishService.getDishDetail(dishId);
    }

    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse<PageInfo> list(@RequestParam(value = "keyword",required = false)String keyword, @RequestParam(value = "dishTypeId",required = false)Long dishTypeId,@RequestParam(value = "pageNum",defaultValue = "1")int pageNum,@RequestParam(value = "pageSize",defaultValue = "10")int pageSize,@RequestParam(value = "orderBy",defaultValue = "")String orderBy,@RequestParam(value = "order",defaultValue = "")String order){
        return iDishService.getDishByKeywordDishType(keyword,dishTypeId,pageNum,pageSize,orderBy,order);
    }

    @RequestMapping("list_type.do")
    @ResponseBody
    public ServerResponse getAllDishType(){
        return iDishTypeService.selectAllDishType();
    }

    @ResponseBody
    @RequestMapping("/search.do")
    public ServerResponse dishSearch(HttpSession session, String dishName, @RequestParam(value = "dishId",required = false) Long dishId,@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,@RequestParam(value = "orderBy",defaultValue = "")String orderBy,@RequestParam(value = "order",defaultValue = "")String order) {
//        User user = (User) session.getAttribute(Const.CURRENT_USER);
//        if (user == null) {
//            return ServerResponse.createByErrorCodeMessage(
//                    EnumResponseCode.NEED_LOGIN.getCode(), "用户未登录");
//        }
        return iDishService.searchDish(dishName, dishId, pageNum, pageSize,orderBy,order);

    }

}
