package com.doft.service;

import com.doft.common.ServerResponse;
import com.doft.vo.CartVo;

public interface ICartService {
    ServerResponse<CartVo> add(Long userId, Long dishId, Integer count, String userName);
    ServerResponse<CartVo> update(Long userId,Long dishId,Integer count,String userName);
    ServerResponse<CartVo> deleteDish(String dishIds,Long userId);
    ServerResponse<CartVo> cleanCart(Long userId);
    ServerResponse<CartVo> list(Long userId);
    ServerResponse<CartVo> selectOrUnSelect(Long userId,Long dishId,Integer checked);
    ServerResponse<Integer> getCartDishCount(Long userId);
}
