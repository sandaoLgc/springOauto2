package common.sandao;

import com.jln.common.systemModule.enity.ResourceTable;
import com.jln.common.systemModule.mapper.ResourceTableMapper;
import com.jln.common.systemModule.mapper.UserMapper;
import com.jln.common.systemModule.pojo.vo.ResourceTableVo;
import common.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName:
 * @Description:
 * @Author:三刀 Date:2019/12/22 21:08
 * Version:1.0
 **/
public class TestRolemMapper extends BaseTest {
    @Resource
    private ResourceTableMapper resourceTableMapper;

    @Resource
    private UserMapper userMapper;
    @Test
    public void TestGetRosourceIsRole(){
        List<ResourceTableVo> role = resourceTableMapper.getRosourceIsRole();
        System.out.println(role);
    }

    @Test
    public void TestGetUserRoleById(){
        List<String> role = userMapper.getUserRoleById("cb1dd5c410b24837a299909b9f15e9db");
        System.out.println(role);
    }
}
