package com.doft.service;

import com.doft.common.ServerResponse;

public interface IDishTypeService {
    ServerResponse addDishType(String typeName, String createBy);
    ServerResponse updateDishTypeName(Long dishTypeId, String typeName,String updatedBy);
    ServerResponse selectAllDishType();
    ServerResponse deleteDishType(Long dishTypeId);
}
