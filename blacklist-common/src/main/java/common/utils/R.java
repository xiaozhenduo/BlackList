package common.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.HashMap;
import java.util.Map;

/**
 * @program springboot_xzd
 * @description: 返回格式
 * @author: 肖振铎
 * @create: 2019/07/25 10:58
 */


public class R extends HashMap<String,Object> {



    public R(){
        put("code", 200);
        put("msg", "操作成功");
    }


    public static R error(){
        return error(500,"操作失败");
    }

    public static R error(String msg){
         return error(500,msg);

    }


    public static R error(int code, String msg){
     R r = new R();
     r.put("code", code);
     r.put("msg", msg);
     return r;
    }





    public static  R ok(){
        return new R();
    }

    public static  R ok(String msg){
        R r = new R();
        r.put("code", 200);
        r.put("msg", msg);
        return r;
    }


    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R ok(Object o){
        R r =new R();
        r.put("code", 200);
        r.put("data",o);
        return r;
    }


    public static R ok(IPage o){
        R r =new R();
        r.put("code", 200);
        r.put("data",o);
        return r;
    }


    public static R ok(Integer integer){
        R r =new R();
        r.put("code", 200);
        if (integer>0){
            r.put("msg","成功保存或更新删除一条数据");
        }else {
            r.put("msg","保存或更新删除数据失败");
        }
        return r;
    }


    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }

}
