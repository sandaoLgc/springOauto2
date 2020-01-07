/*
package com.jln.common.web.shiro;

import com.jln.common.systemModule.enity.Role;
import com.jln.common.systemModule.mapper.ResourceTableMapper;
import com.jln.common.systemModule.mapper.RoleMapper;
import com.jln.common.systemModule.mapper.UserMapper;
import com.jln.common.systemModule.pojo.vo.ResourceTableVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

*/
/**
 * @ClassName: 处理shrio工具类
 * @Description:
 * @Author:三刀 Date:2019/12/22 21:14
 * Version:1.0
 **//*

@Repository
@Slf4j
public class ShrioUtils {
    @Resource
    private ResourceTableMapper resourceTableMapper;
    @Resource
    private UserMapper userMapper;

    */
/**
     * 加载需要配置的权限
     * @param fileMap
     * @return
     *//*

    public  Map<String,String> handleFilterChainDefinitionMapDB(Map<String,String> fileMap){
        */
/**
         * 基于权限的配置
         *//*

        */
/*List<SysRolePermission> permission = roleMapper.getSysRolePermission();
        if(null==permission||permission.isEmpty()){
            return fileMap;
        }
        for (int i = 0; i < permission.size(); i++) {
            String role="perms["+permission.get(i).getRoleName()+":"+permission.get(i).getPermissionName();
            for (int j = 0; j < permission.size(); j++) {
                if(i!=j&&permission.get(i).getUrl().equals(permission.get(j).getUrl())){
                    role=role+"|"+permission.get(j).getRoleName()+":"+permission.get(j).getPermissionName();
                    permission.remove(permission.get(j));
                }
            }
            role=role+"]";
            fileMap.put(permission.get(i).getUrl(),role);
        }
//        for (SysRolePermission rolePermission : permission) {
//            fileMap.put(rolePermission.getUrl(),"perms["+rolePermission.getRoleName()+":"+rolePermission.getPermissionName()+"]");
//        }
        log.error("当前系统需要控制的权限"+fileMap.toString());
        return fileMap;*//*

        */
/**
         * 基于角色配置权限
         *//*

        List<ResourceTableVo> isRole = resourceTableMapper.getRosourceIsRole();
        for (ResourceTableVo vo : isRole) {
            //处理键
            String key=vo.getRosourceUrl();
            //处理值
            StringBuffer value = new StringBuffer();
            value.append("hasAnyRoles[");
            for (Role role : vo.getRoles()) {
               value.append(role.getRoleName()+",");
            }
            //去掉字符串最后一个,号
            value.deleteCharAt(value.length()-1);
            value.append("]");
            fileMap.put(key,value.toString());
        }
        log.error("当前系统需要控制的权限"+fileMap.toString());
        return fileMap;
    }

    */
/**
     * 处理当前用户的授权
     * @param userId
     * @return
     *//*

    public List<String> handleSimpleAuthorizationInfo(String userId){
       */
/* ArrayList<String> arrayList = new ArrayList<>();
        List<SysRolePermission> info = userMapper.getSimpleAuthorizationInfoByUserId(userId);
        if(null==info||info.isEmpty()){
            return null;
        }
        for (int i = 0; i < info.size(); i++) {
            String role=info.get(i).getRoleName()+":"+info.get(i).getPermissionName();
            for (int j = 0; j < info.size(); j++) {
                if(i!=j&&info.get(i).getRoleName().equals(info.get(j).getRoleName())){
                    role=role+","+info.get(j).getPermissionName();
                    info.remove(info.get(j));
                }
            }
            arrayList.add(role);
        }
//        for (SysRolePermission permission : info) {
//            arrayList.add(permission.getRoleName()+":"+permission.getPermissionName());
//        }
        log.error("当前用户权限"+arrayList);
        return arrayList;*//*

       return null;
    }
}
*/
