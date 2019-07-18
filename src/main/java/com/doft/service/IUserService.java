package com.doft.service;

import com.doft.common.ServerResponse;
import com.doft.pojo.User;
import com.doft.vo.UserManageVo;

import java.util.Date;
import java.util.List;

public interface IUserService {
    ServerResponse<User> login(String username, String password);
    ServerResponse<User> loginBackend(String username, String password);
    ServerResponse<String> register(User user);
    ServerResponse<String> checkValid(String str,String type);
    ServerResponse selectQuestion(String username);
    ServerResponse<String> checkAnswer(String username,String question,String answer);
    ServerResponse<String> forgetResetPassword(String username,String passwordNew,String forgetToken);
    ServerResponse<String> resetPassword(String passwordOld,String passwordNew,User user);
    ServerResponse<User> updateInformation(User user);
    ServerResponse<User> getInformation(Long userId);
    ServerResponse checkAdminRole(User user);
    List<UserManageVo> getAllUsersByType(Integer type);
    ServerResponse<String> updateAdminInfo(User submit, User user);
    ServerResponse<String> deleteAdminByAdminId(Long id, User user);
    Long addedUserCount(Date date);

    ServerResponse<String> recharge(Long userId,Double amount);

}
