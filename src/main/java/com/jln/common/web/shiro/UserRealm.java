/*
package com.jln.common.web.shiro;

import com.jln.common.systemModule.enity.User;
import com.jln.common.systemModule.mapper.UserMapper;
import com.jln.common.web.JWT.JWTToken;
import com.jln.common.web.JWT.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

*/
/**
 * @ClassName:
 * @Description:
 * @Author:三刀 Date:2019/12/22 15:23
 * Version:1.0
 **//*

@Slf4j
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    */
/**
     * 执行授权逻辑
     * @param principalCollection
     * @return
     *//*

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.error("执行授权逻辑");

        //获取当前的用户
        Subject subject = SecurityUtils.getSubject();
         User principal =(User) subject.getPrincipal();
        //给资源进行授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        List<String> info1 = shrioUtils.handleSimpleAuthorizationInfo(principal.getUserId());
//        //info.addStringPermission("user:add");
//        info.addStringPermissions(info1);
//        HashSet<String> hashSet = new HashSet<>();
//        hashSet.add("user");
        List<String> roleById = userMapper.getUserRoleById(principal.getUserId());
        Set<String> hashSet = new HashSet<>(roleById);
        log.error("当前用户角色是:"+hashSet.toString());
        info.setRoles(hashSet);

        return info;
    }

    */
/**
     * 执行认证逻辑
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     *//*

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.error("------JWT执行认证逻辑------");
        String token = (String)authenticationToken.getCredentials();
        //解密获得username,用于数据库进行对比
        String username = JWTUtil.getUsername(token);
        if(null!=username||!JWTUtil.verify(token,username)){
           throw new AuthenticationException("认证失败!");
        }
        User userName = userMapper.getUserByUserName(username);
        if(!userName.equals(userName.getUserName())){
            return null;    //会自动抛出UnknownAccountException
        }
        //参数一:返回给login方法的一些参数
        //参数二:数据库中的密码
        //参数三:shrio的名字
        return new SimpleAuthenticationInfo(token,token,"MyRealm");

//        log.error("执行认证逻辑");
//        //编写Shrio判断逻辑
//        UsernamePasswordToken token= (UsernamePasswordToken) authenticationToken;
//        User userName = userMapper.getUserByUserName(token.getUsername());
//        if(!token.getUsername().equals(userName.getUserName())){
//            return null;    //会自动抛出UnknownAccountException
//        }
//        //参数一:返回给login方法的一些参数
//        //参数二:数据库中的密码
//        //参数三:shrio的名字
//        return new SimpleAuthenticationInfo(userName,userName.getPassword(),"");
    }
}
*/
