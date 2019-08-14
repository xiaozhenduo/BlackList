package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.baomidou.mybatisplus.core.metadata.IPage;
    import org.springframework.web.bind.annotation.RequestMethod;
    import org.springframework.web.bind.annotation.RestController;
    import common.controller.BaseController;
import system.pojo.RoleMenuForm;
import system.pojo.RoleMenuVO;
import system.service.IRoleMenuService;

import java.util.List;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import common.utils.R;
/**
 * <p>
 * RoleMenu前端控制器
 * </p>
 *
 * @author xzd
 * @email 958098959@qq.com
 * @since 2019-08-06
 */
@RestController
@Api(tags = "RoleMenu")
@RequestMapping("/sys/role-menu")
    public class RoleMenuController extends BaseController {
@Autowired
public IRoleMenuService roleMenuService;

/**
* 保存单条
* @param param 保存参数
* @return 是否添加成功
*/
@ApiOperation(value = "保存", notes = "保存数据到RoleMenu")
@RequestMapping(value = "/add.json", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
public R addRoleMenu(@RequestBody RoleMenuForm param) {
        Integer result = roleMenuService.save(param);
        return R.ok(result);
        }

/**
* 更新(根据主键id更新)
* @param id 修改参数
* @return 是否更改成功
*/
@ApiOperation(value = "更新数据", notes = "根据主键id更新RoleMenu数据")
@RequestMapping(value = "/updateById.json", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
public R updateRoleMenuById(@RequestBody RoleMenuForm param) {
        Integer result = roleMenuService.updateById(param);
        return R.ok(result);
        }

/**
* 删除(根据主键id伪删除)
* @param id 主键id
* @return 是否删除成功
*/
@ApiOperation(value = "删除数据", notes = "根据主键id伪删除RoleMenu数据")
@RequestMapping(value = "/deleteById.json", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
public R deleteRoleMenuById(String id) {
        Integer result = roleMenuService.deleteById(id);
        return R.ok(result);
        }

/**
* 根据主键id查询单条
* @param param 主键id
* @return 查询结果
*/
@ApiOperation(value = "获取单条数据", notes = "根据主键id获取RoleMenu数据")
@RequestMapping(value = "/getById.json", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
public R getRoleMenuById(String id) {
    RoleMenuVO result = roleMenuService.selectById(id);
        return R.ok(result);
        }

/**
* 查询全部
* @param param 查询条件
* @return 查询结果
*/
@ApiOperation(value = "全部查询", notes = "查询RoleMenu全部数据")
@RequestMapping(value = "/queryAll.json", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
public R getRoleMenuAll(@RequestBody RoleMenuForm param) {
        List<RoleMenuVO> result = roleMenuService.selectAll(param);
        return R.ok(result);
        }

/**
* 分页查询
* @param param 查询条件
* @return 查询结果
*/
@ApiOperation(value = "分页查询", notes = "分页查询RoleMenu全部数据")
@RequestMapping(value = "/queryPage.json", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
public R getRoleMenuPage(@RequestBody RoleMenuForm param) {
        IPage<RoleMenuVO> result = roleMenuService.selectPage(param);
        return R.ok(result);
        }

        }

