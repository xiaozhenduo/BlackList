package system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;


import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import system.pojo.RoleForm;

/**
 * <p>
 * Role对象
 * </p>
 *
 * @author xzd
 * @email 958098959@qq.com
 * @since 2019-07-30
 */
@TableName("sys_role")
@ApiModel(value = "Role对象", description = "")
public class Role implements Serializable{

private static final long serialVersionUID=1L;

@TableId(value = "id", type = IdType.UUID)
private String id;


        @ApiModelProperty(value = "角色名称")
private String roleName;

        @ApiModelProperty(value = "角色标示")
private String roleSign;

        @ApiModelProperty(value = "备注")
private String note;

        @ApiModelProperty(value = "创建人")
private String userIdCreate;

        @ApiModelProperty(value = "创建时间")
private LocalDateTime createTime;

        @ApiModelProperty(value = "更新时间")
private LocalDateTime updateTime;


public String getId(){
        return id;
        }

public void setId(String id){
        this.id=id;
        }



public String getRoleName(){
        return roleName;
        }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
        }

public String getRoleSign(){
        return roleSign;
        }

    public void setRoleSign(String roleSign) {
        this.roleSign = roleSign;
        }

public String getNote(){
        return note;
        }

    public void setNote(String note) {
        this.note = note;
        }

public String getUserIdCreate(){
        return userIdCreate;
        }

    public void setUserIdCreate(String userIdCreate) {
        this.userIdCreate = userIdCreate;
        }

public LocalDateTime getCreateTime(){
        return createTime;
        }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        }

public LocalDateTime getUpdateTime(){
        return updateTime;
        }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        }



@Override
public String toString(){
        return"Role{" +
        "id=" +id+
                ", roleName=" + roleName +

                ", roleSign=" + roleSign +

                ", note=" + note +

                ", userIdCreate=" + userIdCreate +

                ", createTime=" + createTime +

                ", updateTime=" + updateTime +

        "}";
        }

public Role(){}

/**
* Form -> Do
* @param form 对象
* @return Do对象
*/
public Role(RoleForm form){
        this.setId(form.getId());
                this.setRoleName(form.getRoleName());
                this.setRoleSign(form.getRoleSign());
                this.setNote(form.getNote());
                this.setUserIdCreate(form.getUserIdCreate());
                this.setCreateTime(form.getCreateTime());
                this.setUpdateTime(form.getUpdateTime());

        }

        }