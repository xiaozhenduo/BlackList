package system.service.impl;


import system.dao.UserRoleMapper;
import system.domain.UserRole;
import system.pojo.UserRoleForm;
import system.pojo.UserRoleVO;
import system.service.IUserRoleService;
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
 * UserRole服务实现类
 * </p>
 *
 * @author xzd
 * @email 958098959@qq.com
 * @since 2019-08-06
 */
@Service
        public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

        @Override
        public Integer save(UserRoleForm record) {
    UserRole data = new UserRole(record);
        data.setCreateTime(LocalDateTime.now());
        return baseMapper.insert(data);
        }

        @Override
        public Integer updateById(UserRoleForm record) {
    UserRole data = new UserRole(record);
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
        public UserRoleVO selectById(String id) {
        if(StringUtils.isBlank(id)){
        throw new BlackException("id不能为空");
        }
    UserRole data = baseMapper.selectById(id);
    UserRoleVO vo = new UserRoleVO();
        BeanUtils.copyProperties(data,vo);
        return vo;
        }

        @Override
        public List<UserRoleVO> selectAll(UserRoleForm record) {
    UserRole data = new UserRole(record);
        QueryWrapper<UserRole> queryWrapper =  new QueryWrapper<>();
        queryWrapper.setEntity(data);
        List<UserRole> list = baseMapper.selectList(queryWrapper);
        return this.convert(list);
        }

        @Override
        public IPage<UserRoleVO> selectPage(UserRoleForm record) {
        // form -> do 转换
    UserRole data = new UserRole(record);
        // 分页数据设置
        Page<UserRole> page = new Page<>(record.getCurrent(),record.getSize());
        // 查询条件
        QueryWrapper<UserRole> queryWrapper =  new QueryWrapper<>();
        queryWrapper.setEntity(data);
        IPage<UserRole> list = baseMapper.selectPage(page, queryWrapper);
        IPage<UserRoleVO> iPage = new Page<>();
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
        private List<UserRoleVO> convert(List<UserRole> list){
        List<UserRoleVO> userRoleList = new ArrayList<>();
        if (CollectionUtils.isEmpty(list)) {
        return userRoleList;
        }
        for (UserRole source : list) {
    UserRoleVO target = new UserRoleVO();
        BeanUtils.copyProperties(source, target);
    userRoleList.add(target);
        }
        return userRoleList;
        }

        }
