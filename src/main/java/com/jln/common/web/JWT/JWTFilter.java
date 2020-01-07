/*
package com.jln.common.web.JWT;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

*/
/**
 * @ClassName: jwt拦截器
 * @Description:    自定义过滤器,对token进行处理,未处理ajax请求,后期需要优化
 * @Author:三刀 Date:2019/12/25 14:32
 * Version:1.0
 **//*

@Slf4j
public class JWTFilter extends BasicHttpAuthenticationFilter {

    */
/**
     * 如果带有token,则对token进行处理
     * @param request
     * @param response
     * @param mappedValue
     * @return
     *//*

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        //判断请求头上是否带上token
        if(isLoginAttempt(request,response)){
            //如果存在,则进入executeLogin方法执行登录,检查token是否正确
            try {
                executeLogin(request,response);
            }catch (Exception e){
                responseError(response,e.getMessage());
            }

        }
        return true;
    }

    */
/**
     * 判断用户是否想要登录,检测header里面是否包含token字段
     * @param request
     * @param response
     * @return
     *//*

    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        HttpServletRequest req= (HttpServletRequest) request;
        String token = req.getHeader("token");
        return token!=null;
    }

    */
/**
     * 执行登录操作
     * @param request
     * @param response
     * @return
     * @throws Exception
     *//*

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest req= (HttpServletRequest) request;
        String token = req.getHeader("token");
        JWTToken jwtToken = new JWTToken(token);
        //提供给realm进行登入,如果错误它会抛出异常并捕获
        getSubject(request,response).login(jwtToken);
        //如果没有抛出异常则代码登入
        return true;
    }

    */
/**
     * 对跨域提供支持
     * @param request
     * @param response
     * @return
     * @throws Exception
     *//*

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest req=(HttpServletRequest)request;
        HttpServletResponse reps=(HttpServletResponse)response;
        reps.setHeader("Access-control-Allow-Origin", req.getHeader("Origin"));
        reps.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        reps.setHeader("Access-Control-Allow-Headers", req.getHeader("Access-Control-Request-Headers"));
        // 跨域时会首先发送一个option请求，这里我们给option请求直接返回正常状态
        if (req.getMethod().equals(RequestMethod.OPTIONS.name())) {
            reps.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }

    */
/**
     * 将非法请求跳转到 /unauthorized/**
     *//*

    private void responseError(ServletResponse response, String message) {
        try {
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            //设置编码，否则中文字符在重定向时会变为空字符串
            message = URLEncoder.encode(message, "UTF-8");

            //重定向到未授权页面
            httpServletResponse.sendRedirect("/unauthorized/" + message);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
*/
