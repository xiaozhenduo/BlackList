package system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;


import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import system.pojo.MenuForm;

/**
 * <p>
 * Menu对象
 * </p>
 *
 * @author xzd
 * @email 958098959@qq.com
 * @since 2019-08-06
 */
@TableName("sys_menu")
@ApiModel(value = "Menu对象", description = "菜单权限表")
public class Menu implements Serializable{

private static final long serialVersionUID=1L;

@TableId(value = "id", type = IdType.UUID)
private String id;


        @ApiModelProperty(value = "菜单名称")
private String name;

        @ApiModelProperty(value = "菜单权限标识")
private String perms;

        @ApiModelProperty(value = "前端跳转URL")
private String path;

        @ApiModelProperty(value = "菜单组件")
private String component;

        @ApiModelProperty(value = "父菜单ID")
private Integer parentId;

        @ApiModelProperty(value = "图标")
private String icon;

        @ApiModelProperty(value = "排序")
private Integer sort;

        @ApiModelProperty(value = "菜单类型 （类型   0：目录   1：菜单   2：按钮）")
private String type;

        @ApiModelProperty(value = "创建时间")
private LocalDateTime createTime;

        @ApiModelProperty(value = "更新时间")
private LocalDateTime updateTime;

        @ApiModelProperty(value = "逻辑删除标记(0--正常 1--删除)")
private String delFlag;

        @ApiModelProperty(value = "是否为外链")
private Boolean isFrame;


public String getId(){
        return id;
        }

public void setId(String id){
        this.id=id;
        }



public String getName(){
        return name;
        }

    public void setName(String name) {
        this.name = name;
        }

public String getPerms(){
        return perms;
        }

    public void setPerms(String perms) {
        this.perms = perms;
        }

public String getPath(){
        return path;
        }

    public void setPath(String path) {
        this.path = path;
        }

public String getComponent(){
        return component;
        }

    public void setComponent(String component) {
        this.component = component;
        }

public Integer getParentId(){
        return parentId;
        }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
        }

public String getIcon(){
        return icon;
        }

    public void setIcon(String icon) {
        this.icon = icon;
        }

public Integer getSort(){
        return sort;
        }

    public void setSort(Integer sort) {
        this.sort = sort;
        }

public String getType(){
        return type;
        }

    public void setType(String type) {
        this.type = type;
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

public String getDelFlag(){
        return delFlag;
        }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
        }

public Boolean getFrame(){
        return isFrame;
        }

    public void setFrame(Boolean isFrame) {
        this.isFrame = isFrame;
        }



@Override
public String toString(){
        return"Menu{" +
        "id=" +id+
                ", name=" + name +

                ", perms=" + perms +

                ", path=" + path +

                ", component=" + component +

                ", parentId=" + parentId +

                ", icon=" + icon +

                ", sort=" + sort +

                ", type=" + type +

                ", createTime=" + createTime +

                ", updateTime=" + updateTime +

                ", delFlag=" + delFlag +

                ", isFrame=" + isFrame +

        "}";
        }

public Menu(){}



    /**
     * 非数据库字段
     * 父菜单名称
     */
    @TableField(exist = false)
    private String parentName;

    /**
     * 非数据库字段
     * 菜单等级
     */
    @TableField(exist = false)
    private Integer level;

    /**
     * 非数据库字段
     * 子菜单
     */
    @TableField(exist = false)
    private List<Menu> children;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    /**
* Form -> Do
* @param form 对象
* @return Do对象
*/
public Menu(MenuForm form){
        this.setId(form.getId());
                this.setName(form.getName());
                this.setPerms(form.getPerms());
                this.setPath(form.getPath());
                this.setComponent(form.getComponent());
                this.setParentId(form.getParentId());
                this.setIcon(form.getIcon());
                this.setSort(form.getSort());
                this.setType(form.getType());
                this.setCreateTime(form.getCreateTime());
                this.setUpdateTime(form.getUpdateTime());
                this.setDelFlag(form.getDelFlag());
                this.setFrame(form.getFrame());

        }

        }