package com.jln.common.web.shiro;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @ClassName:
 * @Description:
 * @Author:三刀 Date:2019/12/23 17:14
 * Version:1.0
 **/
public class AnyRolesAuthorizationFilter extends RolesAuthorizationFilter {

    @Override
    public boolean isAccessAllowed(ServletRequest request,
                                   ServletResponse response, Object mappedValue) throws IOException {

        final Subject subject = getSubject(request, response);
        final String[] rolesArray = (String[]) mappedValue;

        if (rolesArray == null || rolesArray.length == 0) {
            // no roles specified, so nothing to check - allow access.
            return true;
        }

        for (String roleName : rolesArray) {
            if (subject.hasRole(roleName)) {
                return true;
            }
        }

        return false;
    }
}