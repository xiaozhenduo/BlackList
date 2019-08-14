package system.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * @program BlackList
 * @description:
 * @author: 肖振铎
 * @create: 2019/08/08 09:40
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value="修改密码", description="")
    public class ChangePassForm implements Serializable {

    private String oldPass;
    private String newPass;
    private String checkPass;

    public String getOldPass() {
        return oldPass;
    }

    public void setOldPass(String oldPass) {
        this.oldPass = oldPass;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }

    public String getCheckPass() {
        return checkPass;
    }

    public void setCheckPass(String checkPass) {
        this.checkPass = checkPass;
    }
}
