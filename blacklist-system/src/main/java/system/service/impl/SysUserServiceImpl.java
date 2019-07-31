package system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import system.dao.SysUserMapper;
import system.domain.UserDO;
import system.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * @program springboot_xzd
 * @description:
 * @author: 肖振铎
 * @create: 2019/07/25 13:31
 */

@Service("SysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, UserDO> implements SysUserService {


    @Override
    public UserDO findByUsername(String username) {
        return baseMapper.findByUsername(username);
    }

    /*@Override
    public IPage<UserDO> selectUserPage(Page<UserDO> page) {
        return baseMapper.selectPageVo(page);
    }*/


}
