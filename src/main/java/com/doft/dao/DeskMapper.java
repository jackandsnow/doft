package com.doft.dao;

import com.doft.pojo.Desk;
import com.doft.pojo.DeskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeskMapper {
    int countByExample(DeskExample example);

    int deleteByExample(DeskExample example);

    int deleteByPrimaryKey(Long deskId);

    int insert(Desk record);

    int insertSelective(Desk record);

    List<Desk> selectByExample(DeskExample example);

    Desk selectByPrimaryKey(Long deskId);

    int updateByExampleSelective(@Param("record") Desk record, @Param("example") DeskExample example);

    int updateByExample(@Param("record") Desk record, @Param("example") DeskExample example);

    int updateByPrimaryKeySelective(Desk record);

    int updateByPrimaryKey(Desk record);

    List<Desk> getDeskListByValidFlag(Boolean flag);

    List<Desk> getDeskListTrueValidFlagAndFree();

    List<Long> getFreeDeskIdList();

    Long selectByDeskStatus(Integer status);

}