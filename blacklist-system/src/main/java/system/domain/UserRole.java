package system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;


import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import system.pojo.UserRoleForm;

/**
 * <p>
 * UserRole对象
 * </p>
 *
 * @author xzd
 * @email 958098959@qq.com
 * @since 2019-08-06
 */
@TableName("sys_user_role")
@ApiModel(value = "UserRole对象", description = "")
public class UserRole implements Serializable{

private static final long serialVersionUID=1L;

@TableId(value = "id", type = IdType.UUID)
private String id;


        @ApiModelProperty(value = "用户id")
private String userId;

        @ApiModelProperty(value = "角色id")
private String roleId;

        @ApiModelProperty(value = "更新时间")
private LocalDateTime updateTime;

        @ApiModelProperty(value = "创建时间")
private LocalDateTime createTime;


public String getId(){
        return id;
        }

public void setId(String id){
        this.id=id;
        }



public String getUserId(){
        return userId;
        }

    public void setUserId(String userId) {
        this.userId = userId;
        }

public String getRoleId(){
        return roleId;
        }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
        }

public LocalDateTime getUpdateTime(){
        return updateTime;
        }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        }

public LocalDateTime getCreateTime(){
        return createTime;
        }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        }



@Override
public String toString(){
        return"UserRole{" +
        "id=" +id+
                ", userId=" + userId +

                ", roleId=" + roleId +

                ", updateTime=" + updateTime +

                ", createTime=" + createTime +

        "}";
        }

public UserRole(){}

/**
* Form -> Do
* @param form 对象
* @return Do对象
*/
public UserRole(UserRoleForm form){
        this.setId(form.getId());
                this.setUserId(form.getUserId());
                this.setRoleId(form.getRoleId());
                this.setUpdateTime(form.getUpdateTime());
                this.setCreateTime(form.getCreateTime());

        }

        }