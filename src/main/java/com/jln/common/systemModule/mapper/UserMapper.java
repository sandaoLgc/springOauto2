package com.jln.common.systemModule.mapper;

import com.jln.common.systemModule.enity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2019-12-25
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据用户id获取当前用户有哪些角色
     * @param userId    当前用户ID
     * @return  权限集合,一个用户可以有多个权限
     */
    @Select("SELECT role.role_name from `user`\n" +
            "LEFT JOIN user_role ON `user`.user_id=user_role.user_id\n" +
            "LEFT JOIN role ON user_role.role_id=role.role_id \n" +
            "where `user`.user_id=#{userId}")
    List<String> getUserRoleById(@Param("userId") String userId);

    @Select("select * from user where user_name=#{userName}")
    User getUserByUserName(@Param("userName") String userName);
}
