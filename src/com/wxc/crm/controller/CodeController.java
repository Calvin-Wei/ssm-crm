package com.wxc.crm.controller;

import com.wxc.crm.util.common.RandomCodeUtil;
import org.springframework.stereotype.Controller;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class CodeController {
    public void getCode(HttpServletRequest request, HttpServletResponse response){
        RandomCodeUtil rdnu=RandomCodeUtil.Instance();
        HttpSession session=request.getSession();
        //取得随机字符串放入Session中
        session.setAttribute("RANDOMCODE",rdnu.getString());
        //禁止图像缓存
        response.setHeader("Pragma","no-cache");
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("Expires",0);
        response.setContentType("image/jpeg");
        try {
            //将图像输出到Servlet输出流中
            ServletOutputStream sos=response.getOutputStream();
            ImageIO.write(rdnu.getBuffImg(),"jpeg",sos);
            sos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
