package com.wxc.crm.controller;

import javax.servlet.http.HttpServletResponse;

public class BaseController {
	
	/**
	 * 输出json
	 * @param response
	 * @param json
	 */
	public void write(HttpServletResponse response,String json) {
	    try {
	      response.setCharacterEncoding("UTF-8");
	      response.setContentType("text/json");
	      response.getWriter().write(json);
	      response.getWriter().flush();
	      response.getWriter().close();
	    } catch (Exception ex) {
	      ex.printStackTrace();
	    }
	  }
	
	  /**
	   * 返回结果消息
	   * @param response
	   * @param bool
	   */
	  public void write(HttpServletResponse response,boolean bool) {
	    try {
	      String json = "{\"success\":\"" + bool + "\"}";
	      response.getWriter().write(json);
	      response.getWriter().flush();
	      response.getWriter().close();
	    } catch (Exception ex) {
	      ex.printStackTrace();
	    }
	  }
}
