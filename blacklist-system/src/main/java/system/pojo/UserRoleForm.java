package system.pojo;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * <p>
 * UserRoleForm对象
 * </p>
 *
 * @author xzd
 * @email 958098959@qq.com
 * @since 2019-08-06
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value="UserRole对象", description="")
public class UserRoleForm extends Page {

    private static final long serialVersionUID = 1L;



    private String id;

        @ApiModelProperty(value = "用户id")
        private String userId;

        @ApiModelProperty(value = "角色id")
        private String roleId;

        @ApiModelProperty(value = "更新时间")
        private LocalDateTime updateTime;

        @ApiModelProperty(value = "创建时间")
        private LocalDateTime createTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



        public String getUserId() {
        return userId;
    }

            public void setUserId(String userId) {
        this.userId = userId;
    }

        public String getRoleId() {
        return roleId;
    }

            public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

        public LocalDateTime getUpdateTime() {
        return updateTime;
    }

            public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

        public LocalDateTime getCreateTime() {
        return createTime;
    }

            public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }



    @Override
    public String toString() {
    return "UserRole{" +
            "id="+id+

                    ", userId=" + userId +


                    ", roleId=" + roleId +


                    ", updateTime=" + updateTime +


                    ", createTime=" + createTime +

            "}";
}

}