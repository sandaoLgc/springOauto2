/*
package com.jln.common.bootShiroJwt.Shrio;

import org.apache.shiro.authc.AuthenticationToken;

*/
/**
 * @ClassName:
 * @Description:
 * @Author:三刀 Date:2019/12/25 16:50
 * Version:1.0
 **//*

//这个就类似UsernamePasswordToken
public class JwtToken implements AuthenticationToken {

    private String jwt;

    public JwtToken(String jwt) {
        this.jwt = jwt;
    }

    @Override//类似是用户名
    public Object getPrincipal() {
        return jwt;
    }

    @Override//类似密码
    public Object getCredentials() {
        return jwt;
    }
    //返回的都是jwt
}*/
