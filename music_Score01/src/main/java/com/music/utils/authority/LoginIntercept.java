package com.music.utils.authority;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.music.model.User;
import com.music.utils.Constant;

public class LoginIntercept extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		User user = (User) request.getSession().getAttribute(Constant.SESSION_USER_KEY);
		if(null!=user){
			return true;
		}
		System.out.println( request.getRequestURL()+"?"+request.getQueryString());
		String url = request.getServletPath();
		String param = request.getQueryString();
		if(null!=param && !param.equals("")){
			url = url+" ? "+param;
		}
		request.getSession().setAttribute(Constant.SESSION_USER_GOURL,url);
		request.getRequestDispatcher(RedirectUrl.loginUrl).forward(request, response);
		return false;
	}
}
