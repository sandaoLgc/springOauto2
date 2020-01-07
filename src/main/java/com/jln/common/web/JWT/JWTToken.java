/*
package com.jln.common.web.JWT;

import lombok.Data;
import org.apache.shiro.authc.AuthenticationToken;

*/
/**
 * @ClassName:
 * @Description:
 * @Author:三刀 Date:2019/12/25 14:09
 * Version:1.0
 **//*

public class JWTToken implements AuthenticationToken {
    private String token;

    public JWTToken(){}
    public JWTToken(String token){
        this.token=token;
    }
    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
*/
