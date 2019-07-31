package system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import system.domain.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program springboot_xzd
 * @description:
 * @author: 肖振铎
 * @create: 2019/07/25 13:27
 */

@Mapper
public interface SysUserMapper extends BaseMapper<UserDO> {

    UserDO findByUsername(String username);


}
