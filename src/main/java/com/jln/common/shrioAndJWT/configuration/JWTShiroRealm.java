package com.jln.common.shrioAndJWT.configuration;

import com.jln.common.systemModule.enity.User;
import com.jln.common.systemModule.mapper.UserMapper;
import com.jln.common.systemModule.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 自定义身份认证
 * 基于HMAC（ 散列消息认证码）的控制域
 */

public class JWTShiroRealm extends AuthorizingRealm {
	private final Logger log = LoggerFactory.getLogger(JWTShiroRealm.class);

    protected UserService userService;

    public JWTShiroRealm(UserService userService){
        this.userService = userService;
        this.setCredentialsMatcher(new JWTCredentialsMatcher());
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 认证信息.(身份验证) : Authentication 是用来验证用户身份
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {

        log.info("JWTShiroRealm==>执行认证");
        JWTToken jwtToken = (JWTToken) authcToken;
        String token = jwtToken.getToken();
        
        User user = userService.getJwtTokenInfo(JwtUtils.getUsername(token));
        if(user == null)
            throw new AuthenticationException("token过期，请重新登录");

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getSaltValue(), "jwtRealm");

        return authenticationInfo;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.info("JWTShiroRealm==>执行授权");
        return new SimpleAuthorizationInfo();
    }
}
