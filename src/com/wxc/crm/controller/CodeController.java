package com.wxc.crm.controller;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wxc.crm.util.common.RandomCodeUtil;

/**
 * 
 * @author zh
 *
 */
@Controller
public class CodeController {
	
	@RequestMapping("/code") 
    public void getCode(HttpServletRequest req, HttpServletResponse resp) throws IOException { 
		RandomCodeUtil rdnu = RandomCodeUtil.Instance();
		HttpSession session = req.getSession(); 
		// 取得随机字符串放入Session中
		session.setAttribute("RANDOMCODE", rdnu.getString());
		
		// 禁止图像缓存。  
        resp.setHeader("Pragma", "no-cache"); 
        resp.setHeader("Cache-Control", "no-cache"); 
        resp.setDateHeader("Expires", 0); 
 
        resp.setContentType("image/jpeg"); 
 
        // 将图像输出到Servlet输出流中。  
        ServletOutputStream sos = resp.getOutputStream(); 
        ImageIO.write(rdnu.getBuffImg(), "jpeg", sos); 
        sos.close(); 
    }
}
