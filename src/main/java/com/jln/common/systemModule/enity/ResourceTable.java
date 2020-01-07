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
public class ResourceTable extends Model<ResourceTable> {

    private static final long serialVersionUID = 1L;

    /**
     * 资源表主键
     */
    private String rosourceId;

    /**
     * 资源地址
     */
    private String rosourceUrl;

    /**
     * 资源父id
     */
    private String rosourcePid;

    /**
     * 类型   0：目录   1：菜单   2：按钮
     */
    private String rosourceType;

    /**
     * 是否有效:1有效,2删除
     */
    private String rosourceStatus;


    @Override
    protected Serializable pkVal() {
        return this.rosourceId;
    }

}
