package com.jln.common.systemModule.enity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 
 * @since 2019-12-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Role extends Model<Role> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色表主键
     */
    private String roleId;

    /**
     * 角色英文名
     */
    private String roleName;

    /**
     * 角色描述(中文描述)
     */
    private String roleDescribe;

    /**
     * 角色中文名(给用户看的)
     */
    @TableField("role_nameChina")
    private String roleNamechina;


    @Override
    protected Serializable pkVal() {
        return this.roleId;
    }

}
