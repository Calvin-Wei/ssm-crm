package com.wxc.crm.controller;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BaseController {
    /**
     * 输出json
     * @param response
     * @param json
     */
    public void write(HttpServletResponse response,String json){
        try {
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/json");
            response.getWriter().write(json);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 返回结果信息
     * @param response
     * @param bool
     */
    public void write(HttpServletResponse response,boolean bool){
        String json = "{\"success\":\"" + bool + "\"}";
        try {
            response.getWriter().write(json);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
