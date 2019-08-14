package system.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * @program BlackList
 * @description:
 * @author: 肖振铎
 * @create: 2019/08/06 18:42
 */

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MenuTreeVO {
    private String name;
    private String path;
    private String redirect;
    private String component;
    private Boolean alwaysShow;
    private MenuMetaVo meta;
    private List<MenuTreeVO> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public Boolean getAlwaysShow() {
        return alwaysShow;
    }

    public void setAlwaysShow(Boolean alwaysShow) {
        this.alwaysShow = alwaysShow;
    }

    public MenuMetaVo getMeta() {
        return meta;
    }

    public void setMeta(MenuMetaVo meta) {
        this.meta = meta;
    }

    public List<MenuTreeVO> getChildren() {
        return children;
    }

    public void setChildren(List<MenuTreeVO> children) {
        this.children = children;
    }
}
