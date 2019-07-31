package system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import system.domain.UserDO;

/**
 * @program springboot_xzd
 * @description:
 * @author: 肖振铎
 * @create: 2019/07/25 13:29
 */
public interface SysUserService extends IService<UserDO> {


    /**
     * @description: 根据用户名获取用户
     * @param: [username]
     * @return: com.xzd.blacklist.system.domain.UserDO
     * @author: 肖振铎
     * @date: 2019/7/25
     */
    UserDO findByUsername(String username);

    /*旧分页*/
   /* public IPage<UserDO> selectUserPage(Page<UserDO> page);*/




}
