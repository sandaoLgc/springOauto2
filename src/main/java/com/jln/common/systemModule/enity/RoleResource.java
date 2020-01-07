package com.jln.common.systemModule.enity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
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
public class RoleResource extends Model<RoleResource> {

    private static final long serialVersionUID = 1L;

    /**
     * 资源角色表唯一标识
     */
    private String roleResourceId;

    /**
     * 资源表主键
     */
    private String rosourceId;

    /**
     * 角色表主键
     */
    private String roleId;


    @Override
    protected Serializable pkVal() {
        return this.roleResourceId;
    }

}
