package system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;


import java.util.List;
import com.baomidou.mybatisplus.extension.service.IService;
import system.domain.Role;
import system.pojo.RoleForm;
import system.pojo.RoleVO;

/**
 * <p>
 * Role服务类
 * </p>
 *
 * @author xzd
 * @email 958098959@qq.com
 * @since 2019-07-30
 */
public interface IRoleService extends IService<Role> {
        /**
        * 保存信息对象
        * @param record 信息对象
        * @return 影响记录数
        */
        Integer save(RoleForm record);

        /**
        * 根据主键更新信息对象
        * @param record 信息对象
        * @return 影响记录数
        */
        Integer updateById(RoleForm record);

        /**
        * 根据主键删除信息对象
        * 逻辑删除,字段改为删除态
        * @param id 主键
        * @return 影响记录数
        */
        Integer deleteById(String id);

        /**
        * 根据主键查询信息对象
        * @param id 主键
        * @return 信息对象
        */
    RoleVO selectById(String id);

        /**
        * 根据主键查询信息对象
        * @param record 查询请求条件
        * @return 信息列表
        */
        List<RoleVO> selectAll(RoleForm record);

        /**
        * 分页查询信息对象
        * @param record 查询请求条件
        * @return 信息列表
        */
        IPage<RoleVO> selectPage(RoleForm record);
        }
