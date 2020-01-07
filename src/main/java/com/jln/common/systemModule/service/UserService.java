package com.jln.common.systemModule.service;

import com.jln.common.systemModule.enity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jln.common.web.util.Base;
import org.apache.shiro.crypto.hash.Sha256Hash;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2019-12-25
 */
public interface UserService extends IService<User> {
    String generateJwtToken(String username);
    User getJwtTokenInfo(String username);
    void deleteLoginInfo(String username);
    User getUserInfo(String userName);
    List<String> getUserRoles(String userId);
}
