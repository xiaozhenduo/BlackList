package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.baomidou.mybatisplus.core.metadata.IPage;
    import org.springframework.web.bind.annotation.RequestMethod;
    import org.springframework.web.bind.annotation.RestController;
    import common.controller.BaseController;
import system.pojo.UserRoleForm;
import system.pojo.UserRoleVO;
import system.service.IUserRoleService;

import java.util.List;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import common.utils.R;
/**
 * <p>
 * UserRole前端控制器
 * </p>
 *
 * @author xzd
 * @email 958098959@qq.com
 * @since 2019-08-06
 */
@RestController
@Api(tags = "UserRole")
@RequestMapping("/sys/user-role")
    public class UserRoleController extends BaseController {
@Autowired
public IUserRoleService userRoleService;

/**
* 保存单条
* @param param 保存参数
* @return 是否添加成功
*/
@ApiOperation(value = "保存", notes = "保存数据到UserRole")
@RequestMapping(value = "/add.json", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
public R addUserRole(@RequestBody UserRoleForm param) {
        Integer result = userRoleService.save(param);
        return R.ok(result);
        }

/**
* 更新(根据主键id更新)
* @param id 修改参数
* @return 是否更改成功
*/
@ApiOperation(value = "更新数据", notes = "根据主键id更新UserRole数据")
@RequestMapping(value = "/updateById.json", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
public R updateUserRoleById(@RequestBody UserRoleForm param) {
        Integer result = userRoleService.updateById(param);
        return R.ok(result);
        }

/**
* 删除(根据主键id伪删除)
* @param id 主键id
* @return 是否删除成功
*/
@ApiOperation(value = "删除数据", notes = "根据主键id伪删除UserRole数据")
@RequestMapping(value = "/deleteById.json", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
public R deleteUserRoleById(String id) {
        Integer result = userRoleService.deleteById(id);
        return R.ok(result);
        }

/**
* 根据主键id查询单条
* @param param 主键id
* @return 查询结果
*/
@ApiOperation(value = "获取单条数据", notes = "根据主键id获取UserRole数据")
@RequestMapping(value = "/getById.json", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
public R getUserRoleById(String id) {
    UserRoleVO result = userRoleService.selectById(id);
        return R.ok(result);
        }

/**
* 查询全部
* @param param 查询条件
* @return 查询结果
*/
@ApiOperation(value = "全部查询", notes = "查询UserRole全部数据")
@RequestMapping(value = "/queryAll.json", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
public R getUserRoleAll(@RequestBody UserRoleForm param) {
        List<UserRoleVO> result = userRoleService.selectAll(param);
        return R.ok(result);
        }

/**
* 分页查询
* @param param 查询条件
* @return 查询结果
*/
@ApiOperation(value = "分页查询", notes = "分页查询UserRole全部数据")
@RequestMapping(value = "/queryPage.json", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
public R getUserRolePage(@RequestBody UserRoleForm param) {
        IPage<UserRoleVO> result = userRoleService.selectPage(param);
        return R.ok(result);
        }

        }

