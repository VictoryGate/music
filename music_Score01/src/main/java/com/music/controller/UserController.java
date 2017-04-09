    package com.music.controller;  
      
    import java.util.List;  
      
    import org.apache.log4j.Logger;  
    import org.springframework.beans.factory.annotation.Autowired;  
    import org.springframework.stereotype.Controller;  
    import org.springframework.ui.ModelMap;  
    import org.springframework.web.bind.annotation.PathVariable;  
    import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.music.model.User;
import com.music.service.UserService;
import com.music.utils.authority.Authority;  
      
    @Controller  
    @RequestMapping("/user")  
    public class UserController {  
      
        private static final Logger LOGGER = Logger.getLogger(UserController.class);  
          
        @Autowired  
        private UserService userService;  
          
        public UserService getUserService() {
			return userService;
		}

		public void setUserService(UserService userService) {
			this.userService = userService;
		}
		@RequestMapping( value ="/showInfo/{userId}")  
        public String showUserInfo(ModelMap modelMap, @PathVariable String userId){  
            LOGGER.info("查询用户：" + userId);  
            User userInfo = userService.load(userId);  
            modelMap.addAttribute("userInfo", userInfo);  
            return "/user/showInfo";  
        }  
		@Authority(value="sys:edit") 
		@RequestMapping("/showInfos")  
		public @ResponseBody List<User> showUserInfos(){  
			LOGGER.info("查询用户全部用户");  
			List<User> userInfos = userService.findAll();  
			return userInfos;  
		}  
		
    }  