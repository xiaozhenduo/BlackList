package system.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @program BlackList
 * @description:
 * @author: 肖振铎
 * @create: 2019/07/25 20:06
 */

@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class LoginForm {




    private String username;
    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
