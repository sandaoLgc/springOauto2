/*
package com.jln.common.web.shiro;

import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

*/
/**
 * @ClassName: shiro配置类
 * @Description:
 * @Author:三刀 Date:2019/12/22 15:07
 * Version:1.0
 **//*

@Configuration
public class ShrioConfig {
    @Resource
    private ShrioUtils shrioUtils;

    @Autowired
    private AnyRolesAuthorizationFilter anyRoles;

    */
/**
     * 1.创建ShiroFilterFactoryBen
     *//*

    @Bean
    public ShiroFilterFactoryBean getShrioFileterFactoryBen(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //配置自定义的角色访问拦截器
        Map<String,Filter> shrioFiles=new HashMap<>();
        shrioFiles.put("hasAnyRoles",anyRoles);
        shiroFilterFactoryBean.setFilters(shrioFiles);
        //配置内置过滤器
        //增加Shrio内置过滤器
        */
/**
         * shrio内置过滤器:可以实现权限相关的拦截器
         *      常用过滤器:
         *          anon:无需认证即可访问
         *          authc:必须认证才可以访问
         *          user:如果使用rememberMe的功能可以直接访问
         *          perms:该资源必须资源权限才可访问
         *          role:该资源必须得到角色权限才能访问
         *//*

        Map<String,String> fileMap=new LinkedHashMap<>();
        //不拦截页面
        fileMap.put("/user/toLogin","anon");
        fileMap.put("/user/login","anon");
        fileMap = shrioUtils.handleFilterChainDefinitionMapDB(fileMap);
//        fileMap.put("/user/getAddUser","hasAnyRoles[admin,user]");
//        fileMap.put("/user/getupdate","hasAnyRoles[admin]");
        //都需要拦截的页面
        fileMap.put("/**","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(fileMap);
        //跳转登录页面
        shiroFilterFactoryBean.setLoginUrl("/user/toLogin");
        //未授权页面跳转
        shiroFilterFactoryBean.setUnauthorizedUrl("/user/toShrioError");
        return shiroFilterFactoryBean;
    }

    */
/**
     * 2.创建DefaultWebSecurityManager
     *
     *//*

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getdefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        //关闭ShiroDAO功能
        DefaultSubjectDAO subjectDAO=new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        //不需要将 Shiro Session 中的东西存到任何地方(包括 Htpp Session中)
        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
        subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);

        securityManager.setSubjectDAO(subjectDAO);
        return securityManager;
    }

    */
/**
     * 3.创建Realm
     *//*

    @Bean(name = "userRealm")
    public UserRealm getRealm(){
        return new UserRealm();
    }

    */
/**
     * 首先继承RolesAuthorizationFilter，覆写isAccessAllowed方法
     * 重写角色验证方法
     * @return
     *//*

    @Bean(name = "/anyRoles")
    public AnyRolesAuthorizationFilter getAnyRolesAuthorizationFilter(){
        return new AnyRolesAuthorizationFilter();
    }
}
*/
