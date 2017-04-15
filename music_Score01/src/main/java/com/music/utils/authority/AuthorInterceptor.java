package com.music.utils.authority;

import java.lang.reflect.Method;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.weaver.tools.cache.GeneratedCachedClassHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.music.utils.Constant;

public class AuthorInterceptor extends HandlerInterceptorAdapter {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(handler instanceof  HandlerMethod){
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			Method method = handlerMethod.getMethod();
			Authority author = method.getAnnotation(Authority.class);
			if(author !=null){
				String url ="";
				String needAuthor = author.value();
				if(null!=userAuthor(request)&& userAuthor(request).size()>0){
					if(userAuthor(request).contains(needAuthor)){
						logger.info("有权限访问 {}",request.getRequestURI()+"?"+request.getQueryString());
						return true;
					}
				}
				url = author.url();
				if(null==url||"".equals(url)){
					url=RedirectUrl.url;
				}
				request.getRequestDispatcher(url).forward(request, response);
				logger.info("没有权限访问 {}",request.getRequestURI()+"?"+request.getQueryString());
				return false;
			}
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public Set<String> userAuthor(HttpServletRequest request){
		Set<String> set = (Set<String>) request.getSession().getAttribute(Constant.SESSION_USER_Authoritys);
		return set;
	}

}
