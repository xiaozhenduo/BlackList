package system.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * RoleMenuVO对象
 * </p>
 *
 * @author xzd
 * @email 958098959@qq.com
 * @since 2019-08-06
 */

@ApiModel(value="RoleMenu对象", description="")
public class RoleMenuVO implements Serializable {

    private static final long serialVersionUID = 1L;


    private String id;

        @ApiModelProperty(value = "角色id")
private String roleId;

        @ApiModelProperty(value = "菜单id")
private String menuId;

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



        public String getRoleId() {
        return roleId;
    }

            public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

        public String getMenuId() {
        return menuId;
    }

            public void setMenuId(String menuId) {
        this.menuId = menuId;
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
    return "RoleMenu{" +
            "id="+id+
                    ", roleId=" + roleId +
                    ", menuId=" + menuId +
                    ", updateTime=" + updateTime +
                    ", createTime=" + createTime +
            "}";
}

}
