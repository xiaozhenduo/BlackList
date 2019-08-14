package system.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang.StringUtils;
import common.Exception.BlackException;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.util.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import system.dao.MenuMapper;
import system.domain.Menu;
import system.domain.SysMenu;
import system.pojo.MenuForm;
import system.pojo.MenuVO;
import system.service.IMenuService;
import system.utils.PreUtil;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;


/**
 * <p>
 * Menu服务实现类
 * </p>
 *
 * @author xzd
 * @email 958098959@qq.com
 * @since 2019-08-06
 */
@Service
        public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

        @Override
        public Integer save(MenuForm record) {
    Menu data = new Menu(record);
        data.setCreateTime(LocalDateTime.now());
        return baseMapper.insert(data);
        }

        @Override
        public Integer updateById(MenuForm record) {
    Menu data = new Menu(record);
        data.setUpdateTime(LocalDateTime.now());
        return baseMapper.updateById(data);
        }

        @Override
        public Integer deleteById(String id) {
        if(StringUtils.isBlank(id)){
        throw new BlackException("id不能为空");
        }
        return baseMapper.deleteById(id);
        }

        @Override
        public MenuVO selectById(String id) {
        if(StringUtils.isBlank(id)){
        throw new BlackException("id不能为空");
        }
    Menu data = baseMapper.selectById(id);
    MenuVO vo = new MenuVO();
        BeanUtils.copyProperties(data,vo);
        return vo;
        }

        @Override
        public List<MenuVO> selectAll(MenuForm record) {
    Menu data = new Menu(record);
        QueryWrapper<Menu> queryWrapper =  new QueryWrapper<>();
        queryWrapper.setEntity(data);
        List<Menu> list = baseMapper.selectList(queryWrapper);
        return this.convert(list);
        }

    @Override
    public List<Menu> getMenuTreeByUserId(String ids) {
        List<Menu> lists = baseMapper.getMenuTreeByUserId(ids);


        List<Menu> sysMenus = new ArrayList<>();

        lists.forEach(menu -> {
            if (menu.getParentId() == null || menu.getParentId() == 0) {
                menu.setLevel(0);
                if (PreUtil.exists(sysMenus, menu)) {
                    sysMenus.add(menu);
                }
            }
        });

        sysMenus.sort((o1, o2) -> o1.getSort().compareTo(o2.getSort()));
        PreUtil.findChildren(sysMenus, lists, 0);
        return sysMenus;

    }

    @Override
        public IPage<MenuVO> selectPage(MenuForm record) {
        // form -> do 转换
    Menu data = new Menu(record);
        // 分页数据设置
        Page<Menu> page = new Page<>(record.getCurrent(),record.getSize());
        // 查询条件
        QueryWrapper<Menu> queryWrapper =  new QueryWrapper<>();
        queryWrapper.setEntity(data);
        IPage<Menu> list = baseMapper.selectPage(page, queryWrapper);
        IPage<MenuVO> iPage = new Page<>();
        iPage.setRecords(this.convert(list.getRecords()));
        iPage.setCurrent(list.getCurrent());
        iPage.setSize(list.getSize());
        iPage.setTotal(list.getTotal());
        iPage.setPages(list.getPages());
        return iPage;
        }





        /**
        * Do -> VO
        * @param list 对象
        * @return VO对象
        */
        private List<MenuVO> convert(List<Menu> list){
        List<MenuVO> menuList = new ArrayList<>();
        if (CollectionUtils.isEmpty(list)) {
        return menuList;
        }
        for (Menu source : list) {
    MenuVO target = new MenuVO();
        BeanUtils.copyProperties(source, target);
    menuList.add(target);
        }
        return menuList;
        }

        }
