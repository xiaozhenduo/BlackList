package shiro.controller;




import common.controller.BaseController;
import common.utils.MD5Utils;
import common.utils.R;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import system.domain.UserDO;
import system.service.SysUserService;
import system.utils.ShiroUtils;
import system.pojo.LoginForm;


import java.io.IOException;
import java.util.Collection;
import java.util.Map;

/**
 * @program BlackList
 * @description:
 * @author: 肖振铎
 * @create: 2019/07/25 17:36
 */

@RestController
public class LoginController extends BaseController {


    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SessionDAO sessionDAO;

    /**
     * 登录
     */
    @PostMapping("/login")
    public Map<String, Object> login(LoginForm loginForm)throws IOException {
        //用户信息
        UserDO user = sysUserService.findByUsername(loginForm.getUsername());
        //账号锁定
        if(user.getStatus() == 1){
            return R.error("账号已被锁定,请联系管理员");
        }
        UsernamePasswordToken token = new UsernamePasswordToken(loginForm.getUsername(), MD5Utils.encrypt(loginForm.getPassword()));
        Subject subject = SecurityUtils.getSubject();
        try {

            subject.login(token);


            Collection<Session> sessions = sessionDAO.getActiveSessions();
            if (subject.isAuthenticated()) {
                for (Session session : sessions) {
                    if (loginForm.getUsername().equals(session.getAttribute("loginUser"))) {
                        session.setTimeout(0);
                        System.out.println(session);
                    }

                }
            }

            Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute("loginUser",loginForm.getUsername());

            return R.ok("登录成功，请稍后！");

        } catch (AuthenticationException e) {
            return R.error(403,"用户或密码错误");
        }
    }



    //登出
    @PostMapping("/logout")
    R logout() {
        ShiroUtils.logout();
        return R.ok("退出成功！！！");
    }


    //登录拦截跳转
    @GetMapping("/logfirst")
    R logfirst() {
        return R.ok("请先进行登录！！！");
    }






}
