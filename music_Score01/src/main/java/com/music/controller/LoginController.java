package com.music.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.music.model.User;
import com.music.service.UserService;
import com.music.utils.Constant;

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
				if(null!=user){
					if(user.getPassword().equals(password)){
						req.getSession().setAttribute(Constant.SESSION_USER, user);
						mav.setViewName("/user/home");
					}else{
						erroeMessage="密码错误";
					}
				}else{
					erroeMessage="用户不存在";
				}
				mav.setViewName("/user/home");
				
			}else{
				erroeMessage = "密码不能为空";
			}
		}else{
			erroeMessage = "用户名不能为空";
		}
		if(null!=erroeMessage){
			mav.setViewName("/user/login");
		}
		mav.addObject("erroeMessage",erroeMessage);
		return mav;
	}  
}
