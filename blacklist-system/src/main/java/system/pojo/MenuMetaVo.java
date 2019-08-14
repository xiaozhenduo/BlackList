package system.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @Classname MenuMetaVo
 * @Description
 * @Author 李号东 lihaodongmail@163.com
 * @Date 2019-05-05 16:39
 * @Version 1.0
 */
@Data
public class MenuMetaVo implements Serializable {

    private String title;
    private String icon;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public MenuMetaVo(String title, String icon) {
        this.title = title;
        this.icon = icon;
    }
}
