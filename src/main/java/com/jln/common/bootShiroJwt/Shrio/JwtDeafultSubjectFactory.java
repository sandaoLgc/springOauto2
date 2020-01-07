/*
package com.jln.common.bootShiroJwt.Shrio;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSubjectFactory;

*/
/**
 * @ClassName: 让项目中不创建Session
 * @Description:
 * @Author:三刀 Date:2019/12/25 16:46
 * Version:1.0
 **//*

public class JwtDeafultSubjectFactory extends DefaultWebSubjectFactory {
    @Override
    public Subject createSubject(SubjectContext context) {
        //不创建 session
        context.setSessionCreationEnabled(false);
        return super.createSubject(context);
    }
}
*/
