package system.pojo;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
/**
 * <p>
 * UserForm对象
 * </p>
 *
 * @author xzd
 * @email 958098959@qq.com
 * @since 2019-07-31
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value="User对象", description="")
public class UserForm extends Page {

    private static final long serialVersionUID = 1L;



    private String id;

        @ApiModelProperty(value = "登录账号")
        private String username;

        @ApiModelProperty(value = "用户名")
        private String name;

        @ApiModelProperty(value = "密码")
        private String password;

        @ApiModelProperty(value = "部门id")
        private String deptId;

        @ApiModelProperty(value = "邮箱")
        private String email;

        @ApiModelProperty(value = "手机号")
        private String mobile;

        @ApiModelProperty(value = "状态 0：禁用，1:正常")
        private Integer status;

        @ApiModelProperty(value = "创建用户id")
        private Long userIdCreate;

        @ApiModelProperty(value = "创建时间")
        private LocalDateTime createTime;

        @ApiModelProperty(value = "修改时间")
        private LocalDateTime updateTime;

        @ApiModelProperty(value = "性别")
        private Long sex;

        @ApiModelProperty(value = "出生日期")
        private String birth;

        private String picId;

        @ApiModelProperty(value = "居住地址")
        private String liveAddress;

        @ApiModelProperty(value = "省份")
        private String province;

        @ApiModelProperty(value = "所在城市")
        private String city;

        @ApiModelProperty(value = "所在地区")
        private String district;

        @ApiModelProperty(value = "备注")
        private String note;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



        public String getUsername() {
        return username;
    }

            public void setUsername(String username) {
        this.username = username;
    }

        public String getName() {
        return name;
    }

            public void setName(String name) {
        this.name = name;
    }

        public String getPassword() {
        return password;
    }

            public void setPassword(String password) {
        this.password = password;
    }

        public String getDeptId() {
        return deptId;
    }

            public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

        public String getEmail() {
        return email;
    }

            public void setEmail(String email) {
        this.email = email;
    }

        public String getMobile() {
        return mobile;
    }

            public void setMobile(String mobile) {
        this.mobile = mobile;
    }

        public Integer getStatus() {
        return status;
    }

            public void setStatus(Integer status) {
        this.status = status;
    }

        public Long getUserIdCreate() {
        return userIdCreate;
    }

            public void setUserIdCreate(Long userIdCreate) {
        this.userIdCreate = userIdCreate;
    }

        public LocalDateTime getCreateTime() {
        return createTime;
    }

            public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

        public LocalDateTime getUpdateTime() {
        return updateTime;
    }

            public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

        public Long getSex() {
        return sex;
    }

            public void setSex(Long sex) {
        this.sex = sex;
    }

        public String getBirth() {
        return birth;
    }

            public void setBirth(String birth) {
        this.birth = birth;
    }

        public String getPicId() {
        return picId;
    }

            public void setPicId(String picId) {
        this.picId = picId;
    }

        public String getLiveAddress() {
        return liveAddress;
    }

            public void setLiveAddress(String liveAddress) {
        this.liveAddress = liveAddress;
    }

        public String getProvince() {
        return province;
    }

            public void setProvince(String province) {
        this.province = province;
    }

        public String getCity() {
        return city;
    }

            public void setCity(String city) {
        this.city = city;
    }

        public String getDistrict() {
        return district;
    }

            public void setDistrict(String district) {
        this.district = district;
    }

        public String getNote() {
        return note;
    }

            public void setNote(String note) {
        this.note = note;
    }



    @Override
    public String toString() {
    return "User{" +
            "id="+id+

                    ", username=" + username +


                    ", name=" + name +


                    ", password=" + password +


                    ", deptId=" + deptId +


                    ", email=" + email +


                    ", mobile=" + mobile +


                    ", status=" + status +


                    ", userIdCreate=" + userIdCreate +


                    ", createTime=" + createTime +


                    ", updateTime=" + updateTime +


                    ", sex=" + sex +


                    ", birth=" + birth +


                    ", picId=" + picId +


                    ", liveAddress=" + liveAddress +


                    ", province=" + province +


                    ", city=" + city +


                    ", district=" + district +


                    ", note=" + note +

            "}";
}

}