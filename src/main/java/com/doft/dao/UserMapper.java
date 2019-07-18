package com.doft.dao;

import com.doft.pojo.User;
import com.doft.pojo.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int checkUsername(String username);

    User selectLoginByPhoneNumber(@Param("phoneNumber") String phoneNumber,@Param("password") String password);

    User selectLoginByUsername(@Param("userName") String userName,@Param("password") String password);

    int checkPhoneNumber(String phoneNum);

    String selectQuestionByUsername(String username);

    int checkAnswer(@Param("username")String username,@Param("question")String question,@Param("anwser")String answer);

    int updatePasswordByUsername(@Param("username")String username,@Param("passwordNew")String passwordNew);

    int checkPassword(@Param("password")String password,@Param("userId")Long userId);

    int checkPhoneNumberByUserId(@Param("phoneNumber")String phoneNumber,@Param("userId")Long userId);

    List<User> selectAllCommonUsers();

    List<User> selectAllAdministrators();

    Long countByCreatedTime(@Param("begin") String begin, @Param("end") String end);
}