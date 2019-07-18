package com.doft.dao;

import com.doft.pojo.MessageEvent;
import com.doft.pojo.MessageEventExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageEventMapper {
    int countByExample(MessageEventExample example);

    int deleteByExample(MessageEventExample example);

    int deleteByPrimaryKey(Long messageId);

    int insert(MessageEvent record);

    int insertSelective(MessageEvent record);

    List<MessageEvent> selectByExample(MessageEventExample example);

    MessageEvent selectByPrimaryKey(Long messageId);

    int updateByExampleSelective(@Param("record") MessageEvent record, @Param("example") MessageEventExample example);

    int updateByExample(@Param("record") MessageEvent record, @Param("example") MessageEventExample example);

    int updateByPrimaryKeySelective(MessageEvent record);

    int updateByPrimaryKey(MessageEvent record);

    List<MessageEvent> selectByUserId(String userId);
}