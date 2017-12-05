package com.wxc.crm.util;

import com.wxc.crm.model.User;
import com.wxc.crm.util.common.Const;
import com.wxc.crm.util.common.MD5;
import org.apache.commons.codec.binary.Base64;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 记录用户信息到Cookie，下次自动登录
 */
public class UserCookieUtil {
    //设置cookie有效期是一个星期，根据需要自定义
    private final static long cookieMaxAge=60*60*24*7;

    /**
     * 保存Cookie到客户端
     * 传递进来的user对象中封装了在登录时填写的用户名与密码
     * @param user
     * @param response
     * @throws Exception
     */
    public static void saveCookie(User user, HttpServletResponse response)throws Exception{
        //cookie的有效期至(到哪一天)
        long validTime=System.currentTimeMillis();
        // MD5加密用户详细信息（其实就是把当前用户加密一下，后面判断是否是同一个用户）
        String cookieValueWithMd5 = MD5.md5crypt(user.getUsername()+ ":"+ user.getPassword() + ":" + validTime + ":" + Const.WEBKEY);
        // 将要被保存的完整的Cookie值
        String cookieValue = user.getUsername() + ":" + validTime +":"+cookieValueWithMd5;
        // 再一次对Cookie的值进行BASE64编码
        String cookieValueBase64 = new String(Base64.encodeBase64(cookieValue.getBytes("UTF-8")));
        // 开始保存Cookie（cookie是网站名和值）
        Cookie cookie = new Cookie(Const.COOKIEDOMAINNAME, cookieValueBase64);
        // 存一年(这个值应该大于或等于validTime)
        cookie.setMaxAge(60 * 60 * 24 * 365 * 1);
        // cookie有效路径是网站根目录
        cookie.setPath("/");
        // 向客户端写入
        response.addCookie(cookie);
    }

    /**
     * 用户注销时，清除cookie
     * @param response
     */
    public static void clearCookie(HttpServletResponse response){
        //创建一个空cookie添加，覆盖原来的达到清除目的
        Cookie cookie=new Cookie(Const.COOKIEDOMAINNAME,null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

}
