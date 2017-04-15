package com.music.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.music.model.Authority;
import com.music.model.Role;
import com.music.model.User;
import com.music.service.UserService;
import com.music.utils.Constant;
import com.music.utils.MD5;

@Controller  
@RequestMapping("/user")
public class LoginController {
	 private static final Logger LOGGER = Logger.getLogger(UserController.class);  
     
     @Autowired  
     private UserService userService;  
     
    @RequestMapping(value="/login.do",method=RequestMethod.POST)  
	public ModelAndView  login(HttpServletRequest req,String userName,String password){
		LOGGER.info("login"); 
		ModelAndView mav = new ModelAndView();
		String erroeMessage = null;
		if(null!=userName && !userName.equals("")){
			if(null!=password && !password.equals("")){
				User user = this.userService.selectUserByUserName(userName);
				String goUrl ="";
				if(null!=user){
					if(user.getPassword().equals(MD5.getMD5(MD5.getMD5(password)+userName))){
						userAuthor(req,user);
						LOGGER.info(user.getNickName()+" 登陆成功  ");
						req.getSession().setAttribute(Constant.SESSION_USER_KEY, user);
						goUrl = (String) req.getSession().getAttribute(Constant.SESSION_USER_GOURL);
						req.getSession().setAttribute(Constant.SESSION_USER_GOURL,"");
					}else{
						erroeMessage="密码错误";
					}
				}else{
					erroeMessage="用户不存在";
				}
				if(null!=goUrl&&!goUrl.equals("")){
					mav.setViewName("redirect:"+goUrl);
				}else{
					mav.setViewName("/admin/admin");
				}
			}else{
				erroeMessage = "密码不能为空";
			}
		}else{
			erroeMessage = "用户名不能为空";
		}
		if(null!=erroeMessage){
			mav.setViewName("/user/login1");
		}
		mav.addObject("erroeMessage",erroeMessage);
		return mav;
	}
    @RequestMapping(value="/index")
    public ModelAndView index(){
    	ModelAndView mav = new ModelAndView("/user/login1");
    	return mav;
    }
    @RequestMapping(value="/logOut")
    public ModelAndView logOut(HttpServletRequest req){
    	ModelAndView mav = new ModelAndView("/user/login1");
    	User user = (User) req.getSession().getAttribute(Constant.SESSION_USER_KEY);
    	req.getSession().setAttribute(Constant.SESSION_USER_KEY,null);
    	LOGGER.info(user.getNickName()+" 注销成功！");
    	return mav;
    }
    /**
     * 权限保存到session
     * @param request
     * @param user
     */
	public void userAuthor(HttpServletRequest request,User user){
		Set<String> set = new HashSet<String>();
		Set<Role> role = user.getRoles();
		for (Role role2 : role) {
			Set<Authority> authority = role2.getAuthorities();
			for (Authority authority2 : authority) {
				set.add(authority2.getName());
			}
		}
		request.getSession().setAttribute(Constant.SESSION_USER_Authoritys,set);
	}
}
