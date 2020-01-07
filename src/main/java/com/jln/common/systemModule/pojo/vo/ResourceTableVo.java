package com.jln.common.systemModule.pojo.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.jln.common.systemModule.enity.Role;
import lombok.Data;

import java.util.List;

/**
 * @ClassName:  项目启动时加载一个当前资源能被什么角色访问的工具类
 * @Description:
 * @Author:三刀 Date:2019/12/25 10:06
 * Version:1.0
 **/
@Data
public class ResourceTableVo {
    private String rosourceUrl;
    private List<Role> roles;

}
