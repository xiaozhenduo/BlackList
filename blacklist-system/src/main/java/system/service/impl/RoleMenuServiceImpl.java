package system.service.impl;


import system.dao.RoleMenuMapper;
import system.domain.RoleMenu;
import system.pojo.RoleMenuForm;
import system.pojo.RoleMenuVO;
import system.service.IRoleMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang.StringUtils;
import common.Exception.BlackException;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.util.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;


/**
 * <p>
 * RoleMenu服务实现类
 * </p>
 *
 * @author xzd
 * @email 958098959@qq.com
 * @since 2019-08-06
 */
@Service
        public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements IRoleMenuService {

        @Override
        public Integer save(RoleMenuForm record) {
    RoleMenu data = new RoleMenu(record);
        data.setCreateTime(LocalDateTime.now());
        return baseMapper.insert(data);
        }

        @Override
        public Integer updateById(RoleMenuForm record) {
    RoleMenu data = new RoleMenu(record);
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
        public RoleMenuVO selectById(String id) {
        if(StringUtils.isBlank(id)){
        throw new BlackException("id不能为空");
        }
    RoleMenu data = baseMapper.selectById(id);
    RoleMenuVO vo = new RoleMenuVO();
        BeanUtils.copyProperties(data,vo);
        return vo;
        }

        @Override
        public List<RoleMenuVO> selectAll(RoleMenuForm record) {
    RoleMenu data = new RoleMenu(record);
        QueryWrapper<RoleMenu> queryWrapper =  new QueryWrapper<>();
        queryWrapper.setEntity(data);
        List<RoleMenu> list = baseMapper.selectList(queryWrapper);
        return this.convert(list);
        }

        @Override
        public IPage<RoleMenuVO> selectPage(RoleMenuForm record) {
        // form -> do 转换
    RoleMenu data = new RoleMenu(record);
        // 分页数据设置
        Page<RoleMenu> page = new Page<>(record.getCurrent(),record.getSize());
        // 查询条件
        QueryWrapper<RoleMenu> queryWrapper =  new QueryWrapper<>();
        queryWrapper.setEntity(data);
        IPage<RoleMenu> list = baseMapper.selectPage(page, queryWrapper);
        IPage<RoleMenuVO> iPage = new Page<>();
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
        private List<RoleMenuVO> convert(List<RoleMenu> list){
        List<RoleMenuVO> roleMenuList = new ArrayList<>();
        if (CollectionUtils.isEmpty(list)) {
        return roleMenuList;
        }
        for (RoleMenu source : list) {
    RoleMenuVO target = new RoleMenuVO();
        BeanUtils.copyProperties(source, target);
    roleMenuList.add(target);
        }
        return roleMenuList;
        }

        }
