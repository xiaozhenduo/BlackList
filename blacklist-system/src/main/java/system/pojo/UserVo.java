package system.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @program BlackList
 * @description:
 * @author: 肖振铎
 * @create: 2019/07/30 12:46
 */


public class UserVo implements Serializable{

        private static final long serialVersionUID = 1L;

        //
        @ApiModelProperty(value = "",name = "Id")
        private String id;
        //登录账号
        @ApiModelProperty(value = "登录账号",name = "username")
        private String username;
        //用户名
        @ApiModelProperty(value = "用户名",name = "name")
        private String name;
        //密码
        @ApiModelProperty(value = "密码",name = "password")
        private String password;
        //部门id
        @ApiModelProperty(value = "部门id",name = "deptId")
        private String deptId;
        //邮箱
        @ApiModelProperty(value = "邮箱",name = "email")
        private String email;
        //手机号
        @ApiModelProperty(value = "手机号",name = "mobile")
        private String mobile;
        //状态 0：禁用，1:正常
        @ApiModelProperty(value = "状态 0：禁用，1:正常",name = "status")
        private Integer status;
        //创建用户id
        @ApiModelProperty(value = "创建用户id",name = "userIdCreate")
        private Long userIdCreate;
        //创建时间
        @ApiModelProperty(value = "创建时间",name = "createTime")
        private Date createTime;
        //修改时间
        @ApiModelProperty(value = "修改时间",name = "updateTime")
        private Date updateTime;
        //性别
        @ApiModelProperty(value = "性别",name = "sex")
        private Long sex;
        //出生日期
        @ApiModelProperty(value = "出生日期",name = "birth")
        private String birth;
        //
        @ApiModelProperty(value = "",name = "picId")
        private String picId;
        //居住地址
        @ApiModelProperty(value = "居住地址",name = "liveAddress")
        private String liveAddress;
        //省份
        @ApiModelProperty(value = "省份",name = "province")
        private String province;
        //所在城市
        @ApiModelProperty(value = "所在城市",name = "city")
        private String city;
        //所在地区
        @ApiModelProperty(value = "所在地区",name = "district")
        private String district;
        //备注
        @ApiModelProperty(value = "备注",name = "note")
        private String note;

        /**
         * 设置：
         */
        public void setUserId(String userId) {
            this.id = userId;
        }
        /**
         * 获取：
         */
        public String getUserId() {
            return id;
        }
        /**
         * 设置：登录账号
         */
        public void setUsername(String username) {
            this.username = username;
        }
        /**
         * 获取：登录账号
         */
        public String getUsername() {
            return username;
        }
        /**
         * 设置：用户名
         */
        public void setName(String name) {
            this.name = name;
        }
        /**
         * 获取：用户名
         */
        public String getName() {
            return name;
        }
        /**
         * 设置：密码
         */
        public void setPassword(String password) {
            this.password = password;
        }
        /**
         * 获取：密码
         */
        public String getPassword() {
            return password;
        }
        /**
         * 设置：部门id
         */
        public void setDeptId(String deptId) {
            this.deptId = deptId;
        }
        /**
         * 获取：部门id
         */
        public String getDeptId() {
            return deptId;
        }
        /**
         * 设置：邮箱
         */
        public void setEmail(String email) {
            this.email = email;
        }
        /**
         * 获取：邮箱
         */
        public String getEmail() {
            return email;
        }
        /**
         * 设置：手机号
         */
        public void setMobile(String mobile) {
            this.mobile = mobile;
        }
        /**
         * 获取：手机号
         */
        public String getMobile() {
            return mobile;
        }
        /**
         * 设置：状态 0：禁用，1:正常
         */
        public void setStatus(Integer status) {
            this.status = status;
        }
        /**
         * 获取：状态 0：禁用，1:正常
         */
        public Integer getStatus() {
            return status;
        }
        /**
         * 设置：创建用户id
         */
        public void setUserIdCreate(Long userIdCreate) {
            this.userIdCreate = userIdCreate;
        }
        /**
         * 获取：创建用户id
         */
        public Long getUserIdCreate() {
            return userIdCreate;
        }
        /**
         * 设置：创建时间
         */
        public void setCreateTime(Date createTime) {
            this.createTime = createTime;
        }
        /**
         * 获取：创建时间
         */
        public Date getCreateTime() {
            return createTime;
        }
        /**
         * 设置：修改时间
         */
        public void setupdateTime(Date updateTime) {
            this.updateTime = updateTime;
        }
        /**
         * 获取：修改时间
         */
        public Date getupdateTime() {
            return updateTime;
        }
        /**
         * 设置：性别
         */
        public void setSex(Long sex) {
            this.sex = sex;
        }
        /**
         * 获取：性别
         */
        public Long getSex() {
            return sex;
        }
        /**
         * 设置：出生日期
         */
        public void setBirth(String birth) {
            this.birth = birth;
        }
        /**
         * 获取：出生日期
         */
        public String getBirth() {
            return birth;
        }
        /**
         * 设置：
         */
        public void setPicId(String picId) {
            this.picId = picId;
        }
        /**
         * 获取：
         */
        public String getPicId() {
            return picId;
        }
        /**
         * 设置：居住地址
         */
        public void setLiveAddress(String liveAddress) {
            this.liveAddress = liveAddress;
        }
        /**
         * 获取：居住地址
         */
        public String getLiveAddress() {
            return liveAddress;
        }
        /**
         * 设置：省份
         */
        public void setProvince(String province) {
            this.province = province;
        }
        /**
         * 获取：省份
         */
        public String getProvince() {
            return province;
        }
        /**
         * 设置：所在城市
         */
        public void setCity(String city) {
            this.city = city;
        }
        /**
         * 获取：所在城市
         */
        public String getCity() {
            return city;
        }
        /**
         * 设置：所在地区
         */
        public void setDistrict(String district) {
            this.district = district;
        }
        /**
         * 获取：所在地区
         */
        public String getDistrict() {
            return district;
        }
        /**
         * 设置：备注
         */
        public void setNote(String note) {
            this.note = note;
        }
        /**
         * 获取：备注
         */
        public String getNote() {
            return note;
        }


}
