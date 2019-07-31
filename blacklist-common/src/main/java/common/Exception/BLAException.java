package common.Exception;

import common.utils.R;
import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @program BlackList
 * @description: 统一异常处理
 * @author: 肖振铎
 * @create: 2019/07/25 14:34
 */


public class BLAException {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /*自定义异常*/

    @ExceptionHandler(BlackException.class)
    public R handleBlackException(BlackException e){
        logger.error(e.getMessage(), e);
        R r =new R();
        r.put("code", e.getCode());
        r.put("msg", e.getMessage());
        return r;
    }


    @ExceptionHandler(AuthorizationException.class)
    public R handleAuthorizationException(AuthorizationException e){
        logger.error(e.getMessage(), e);
        return R.error(403,"没有权限，请联系管理员授权");
    }


    /*异常拦截*/
    @ExceptionHandler(Exception.class)
    public R handleException(Exception e){
        logger.error(e.getMessage(), e);
        return R.error(e.getLocalizedMessage());
    }




}
