package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import common.controller.BaseController;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import common.utils.R;
import system.pojo.MenuForm;
import system.pojo.MenuTreeVO;
import system.pojo.MenuVO;
import system.service.IMenuService;
import system.utils.PreUtil;
import system.utils.ShiroUtils;

/**
 * <p>
 * Menu前端控制器
 * </p>
 *
 * @author xzd
 * @email 958098959@qq.com
 * @since 2019-08-063
 */
@RestController
@Api(tags = "Menu")
@RequestMapping("/sys/menu")
public class MenuController extends BaseController {
    @Autowired
    public IMenuService menuService;

    /**
     * 保存单条
     *
     * @param param 保存参数
     * @return 是否添加成功
     */
    @ApiOperation(value = "保存", notes = "保存数据到Menu")
    @RequestMapping(value = "/add.json", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public R addMenu(@RequestBody MenuForm param) {
        Integer result = menuService.save(param);
        return R.ok(result);
    }

    /**
     * 更新(根据主键id更新)
     *
     * @param id 修改参数
     * @return 是否更改成功
     */
    @ApiOperation(value = "更新数据", notes = "根据主键id更新Menu数据")
    @RequestMapping(value = "/updateById.json", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public R updateMenuById(@RequestBody MenuForm param) {
        Integer result = menuService.updateById(param);
        return R.ok(result);
    }

    /**
     * 删除(根据主键id伪删除)
     *
     * @param id 主键id
     * @return 是否删除成功
     */
    @ApiOperation(value = "删除数据", notes = "根据主键id伪删除Menu数据")
    @RequestMapping(value = "/deleteById.json", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public R deleteMenuById(String id) {
        Integer result = menuService.deleteById(id);
        return R.ok(result);
    }

    /**
     * 根据主键id查询单条
     *
     * @param param 主键id
     * @return 查询结果
     */
    @ApiOperation(value = "获取单条数据", notes = "根据主键id获取Menu数据")
    @RequestMapping(value = "/getById.json", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public R getMenuById(String id) {
        MenuVO result = menuService.selectById(id);
        return R.ok(result);
    }

    /**
     * 查询全部
     *
     * @param param 查询条件
     * @return 查询结果
     */
    @ApiOperation(value = "全部查询", notes = "查询Menu全部数据")
    @RequestMapping(value = "/queryAll.json", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public R getMenuAll(@RequestBody MenuForm param) {
        List<MenuVO> result = menuService.selectAll(param);
        return R.ok(result);
    }

    /**
     * 分页查询
     *
     * @param param 查询条件
     * @return 查询结果
     */
    @ApiOperation(value = "分页查询", notes = "分页查询Menu全部数据")
    @RequestMapping(value = "/queryPage.json", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public R getMenuPage(@RequestBody MenuForm param) {
        IPage<MenuVO> result = menuService.selectPage(param);
        return R.ok(result);
    }



    @RequestMapping(value = "/getMenuByUserId", method=RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public R getMenuTreeByUserId(){
        List<MenuTreeVO> menuVos = PreUtil.buildMenus(menuService.getMenuTreeByUserId(ShiroUtils.getUserId()));
        return R.ok(menuVos);
    }

}

