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
import system.dao.RoleMapper;
import system.domain.Role;
import system.pojo.RoleForm;
import system.pojo.RoleVO;
import system.service.IRoleService;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;


/**
 * <p>
 * Role服务实现类
 * </p>
 *
 * @author xzd
 * @email 958098959@qq.com
 * @since 2019-07-30
 */
@Service
        public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

        @Override
        public Integer save(RoleForm record) {
    Role data = new Role(record);
        data.setCreateTime(LocalDateTime.now());
        return baseMapper.insert(data);
        }

        @Override
        public Integer updateById(RoleForm record) {
    Role data = new Role(record);
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
        public RoleVO selectById(String id) {
        if(StringUtils.isBlank(id)){
        throw new BlackException("id不能为空");
        }
    Role data = baseMapper.selectById(id);
    RoleVO vo = new RoleVO();
        BeanUtils.copyProperties(data,vo);
        return vo;
        }

        @Override
        public List<RoleVO> selectAll(RoleForm record) {
    Role data = new Role(record);
        QueryWrapper<Role> queryWrapper =  new QueryWrapper<>();
        queryWrapper.setEntity(data);
        List<Role> list = baseMapper.selectList(queryWrapper);
        return this.convert(list);
        }

        @Override
        public IPage<RoleVO> selectPage(RoleForm record) {
        // form -> do 转换
    Role data = new Role(record);
        // 分页数据设置
        Page<Role> page = new Page<>(record.getCurrent(),record.getSize());
        // 查询条件
        QueryWrapper<Role> queryWrapper =  new QueryWrapper<>();
        queryWrapper.setEntity(data);
        IPage<Role> list = baseMapper.selectPage(page, queryWrapper);
        IPage<RoleVO> iPage = new Page<>();
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
        private List<RoleVO> convert(List<Role> list){
        List<RoleVO> roleList = new ArrayList<>();
        if (CollectionUtils.isEmpty(list)) {
        return roleList;
        }
        for (Role source : list) {
    RoleVO target = new RoleVO();
        BeanUtils.copyProperties(source, target);
    roleList.add(target);
        }
        return roleList;
        }

        }
