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
import org.springframework.web.bind.annotation.*;
import system.domain.UserDO;
import system.pojo.ChangePassForm;
import system.service.SysUserService;
import system.utils.ShiroUtils;
import system.pojo.LoginForm;


import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import static system.utils.ShiroUtils.getUser;

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
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public R login(LoginForm loginForm) {
        //用户信息
        UserDO user = sysUserService.findByUsername(loginForm.getUsername());
        //账号锁定
        if (user.getStatus() == 1) {
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
            session.setAttribute("loginUser", loginForm.getUsername());


            return R.ok().put("token", subject.getSession().getId());

        } catch (AuthenticationException e) {
            return R.error(403, "用户或密码错误");
        }
    }


    //登出
    @PostMapping("/logout")
    R logout() {
        ShiroUtils.logout();
        return R.ok("退出成功！！！");
    }


    /**
     * 获取登录的用户信息
     */
    @GetMapping("/info")
    public R info() {
        return R.ok().put("data", getUser());
    }


    //登录拦截跳转
    @GetMapping("/logfirst")
    R logfirst() {
        return R.error("请先进行登录！！！");
    }



    @RequestMapping(value = "/changepass", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public R changepass(ChangePassForm changePassForm) {

        UserDO userDO = getUser();

        if (userDO.getPassword().equals(MD5Utils.encrypt(changePassForm.getOldPass()))) {


            if (changePassForm.getNewPass().equals(changePassForm.getCheckPass())) {

                userDO.setPassword(MD5Utils.encrypt(changePassForm.getNewPass()));

                sysUserService.saveOrUpdate(userDO);

                ShiroUtils.logout();

                return R.ok("修改密码成功，请重新登录");

            } else {
                return R.error("两次输入密码不相同！！！");
            }

        } else {
            return R.error("密码错误,请重新输入");
        }


    }


}
