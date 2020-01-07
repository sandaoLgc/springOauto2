package com.jln.common.systemModule.mapper;

import com.jln.common.systemModule.enity.ResourceTable;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jln.common.systemModule.pojo.vo.ResourceTableVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2019-12-25
 */
public interface ResourceTableMapper extends BaseMapper<ResourceTable> {
    /**
     * 获取项目中一个资源能被哪些角色访问
     * @return
     */
    List<ResourceTableVo> getRosourceIsRole();
}
