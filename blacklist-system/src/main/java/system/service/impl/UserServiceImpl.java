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
import system.dao.UserMapper;
import system.domain.User;
import system.pojo.UserForm;
import system.pojo.UserVO;
import system.service.IUserService;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;


/**
 * <p>
 * User服务实现类
 * </p>
 *
 * @author xzd
 * @email 958098959@qq.com
 * @since 2019-07-31
 */
@Service
        public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

        @Override
        public Integer save(UserForm record) {
    User data = new User(record);
        data.setCreateTime(LocalDateTime.now());
        return baseMapper.insert(data);
        }

        @Override
        public Integer updateById(UserForm record) {
    User data = new User(record);
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
        public UserVO selectById(String id) {
        if(StringUtils.isBlank(id)){
        throw new BlackException("id不能为空");
        }
    User data = baseMapper.selectById(id);
    UserVO vo = new UserVO();
        BeanUtils.copyProperties(data,vo);
        return vo;
        }

        @Override
        public List<UserVO> selectAll(UserForm record) {
    User data = new User(record);
        QueryWrapper<User> queryWrapper =  new QueryWrapper<>();
        queryWrapper.setEntity(data);
        List<User> list = baseMapper.selectList(queryWrapper);
        return this.convert(list);
        }

        @Override
        public IPage<UserVO> selectPage(UserForm record) {
        // form -> do 转换
    User data = new User(record);
        // 分页数据设置
        Page<User> page = new Page<>(record.getCurrent(),record.getSize());
        // 查询条件
        QueryWrapper<User> queryWrapper =  new QueryWrapper<>();
        queryWrapper.setEntity(data);
        IPage<User> list = baseMapper.selectPage(page, queryWrapper);
        IPage<UserVO> iPage = new Page<>();
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
        private List<UserVO> convert(List<User> list){
        List<UserVO> userList = new ArrayList<>();
        if (CollectionUtils.isEmpty(list)) {
        return userList;
        }
        for (User source : list) {
    UserVO target = new UserVO();
        BeanUtils.copyProperties(source, target);
    userList.add(target);
        }
        return userList;
        }

        }
