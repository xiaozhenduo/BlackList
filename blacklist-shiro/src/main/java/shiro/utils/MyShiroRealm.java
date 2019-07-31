package shiro.utils;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import system.domain.UserDO;
import system.service.SysUserService;
import system.utils.ShiroUtils;


import javax.annotation.Resource;

/**
 * @program BlackList
 * @description:
 * @author: 肖振铎
 * @create: 2019/07/25 15:49
 */


public class MyShiroRealm extends AuthorizingRealm {
    @Resource
    private SysUserService sysUserService;




    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        String userId = ShiroUtils.getUserId();

        /*for (SysRole role : userInfo.getRoleList()) {
            authorizationInfo.addRole(role.getRole());
            for (SysPermission p : role.getPermissions()) {
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }*/
        return authorizationInfo;
    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());

        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        UserDO userInfo = sysUserService.findByUsername(username);

        if (userInfo == null) {
             throw new UnknownAccountException("账号或密码不正确");
        }
        // 密码错误
        if (!password.equals(userInfo.getPassword())) {
            throw new IncorrectCredentialsException("账号或密码不正确");
        }
        if (userInfo.getStatus() == 1) { //账户冻结
            throw new LockedAccountException("账号已被锁定,请联系管理员");
        }
        //校验
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userInfo, userInfo.getPassword(), userInfo.getUsername());
        return authenticationInfo;
    }



}
