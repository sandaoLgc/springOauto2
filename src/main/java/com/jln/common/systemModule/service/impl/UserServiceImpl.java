package com.jln.common.systemModule.service.impl;

import com.jln.common.shrioAndJWT.configuration.JwtUtils;
import com.jln.common.systemModule.enity.User;
import com.jln.common.systemModule.mapper.ResourceTableMapper;
import com.jln.common.systemModule.mapper.UserMapper;
import com.jln.common.systemModule.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jln.common.web.util.Base;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2019-12-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    private static final String encryptSalt = "F12839WhsnnEV$#23b";
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ResourceTableMapper resourceTableMapper;
    /**
     * 保存user登录信息，返回token
     * @param userDto
     */
    public String generateJwtToken(String username) {
        String salt = "12345";//JwtUtils.generateSalt();
        /**
         * @todo 将salt保存到数据库或者缓存中
         * redisTemplate.opsForValue().set("token:"+username, salt, 3600, TimeUnit.SECONDS);
         */
        return JwtUtils.sign(username, salt, 3600); //生成jwt token，设置过期时间为1小时
    }

    /**
     * 获取上次token生成时的salt值和登录用户信息
     * @param username
     * @return
     */
    public User getJwtTokenInfo(String username) {
        String salt = "12345";
        /**
         * @todo 从数据库或者缓存中取出jwt token生成时用的salt
         * salt = redisTemplate.opsForValue().get("token:"+username);
         */
        User user = getUserInfo(username);
        user.setSaltValue(salt);
        return user;
    }

    /**
     * 清除token信息
     * @param userName 登录用户名
     * @param terminal 登录终端
     */
    public void deleteLoginInfo(String username) {
        /**
         * @todo 删除数据库或者缓存中保存的salt
         * redisTemplate.delete("token:"+username);
         */

    }

    /**
     * 获取数据库中保存的用户信息，主要是加密后的密码
     * @param userName
     * @return
     */
    public User getUserInfo(String userName) {
        User user = new User();
        user.setUserId(Base.getuuid());
        user.setUserName("admin");
        user.setPassword(new Sha256Hash("123456", encryptSalt).toHex());
        return user;
    }

    /**
     * 获取用户角色列表，强烈建议从缓存中获取
     * @param userId
     * @return
     */
    public List<String> getUserRoles(String userId){
        return Arrays.asList("admin");
    }
}
