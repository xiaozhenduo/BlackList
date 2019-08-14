package system.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import system.domain.Menu;

import java.util.List;

/**
 * <p>
 * MenuMapper 接口
 * </p>
 *
 * @author xzd
 * @email 958098959@qq.com
 * @since 2019-08-06
 */
public interface MenuMapper extends BaseMapper<Menu> {

        List<Menu> getMenuTreeByUserId(String ids);

        }
