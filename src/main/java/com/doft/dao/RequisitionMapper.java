package com.doft.dao;

import com.doft.pojo.Requisition;
import com.doft.pojo.RequisitionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RequisitionMapper {
    int countByExample(RequisitionExample example);

    int deleteByExample(RequisitionExample example);

    int deleteByPrimaryKey(Long reqId);

    int insert(Requisition record);

    int insertSelective(Requisition record);

    List<Requisition> selectByExample(RequisitionExample example);

    Requisition selectByPrimaryKey(Long reqId);

    int updateByExampleSelective(@Param("record") Requisition record, @Param("example") RequisitionExample example);

    int updateByExample(@Param("record") Requisition record, @Param("example") RequisitionExample example);

    int updateByPrimaryKeySelective(Requisition record);

    int updateByPrimaryKey(Requisition record);

    List<Requisition> selectAllRequisitions();

    List<Requisition> selectByRequisitionNo(String requisitionNo);

    Long countByCreatedTime(@Param("begin") String begin, @Param("end") String end);

    Long countByCreatedTimeAndStatus(@Param("begin") String begin, @Param("end") String end, @Param("status") Integer status);

}