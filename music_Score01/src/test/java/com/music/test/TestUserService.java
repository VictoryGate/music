    package com.music.test;  
      
    import java.util.Date;  
    import java.util.UUID;  
      
    import org.apache.log4j.Logger;  
    import org.junit.Test;  
    import org.junit.runner.RunWith;  
    import org.springframework.beans.factory.annotation.Autowired;  
    import org.springframework.test.context.ContextConfiguration;  
    import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  
      
    import com.alibaba.fastjson.JSON;
	import com.music.model.User;
	import com.music.service.UserService;
import com.music.utils.MD5;  
   
    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(locations = {"classpath:conf/spring.xml",  
            "classpath:conf/spring-hibernate.xml"})  
    public class TestUserService {  
      
        private static final Logger LOGGER = Logger  
                .getLogger(TestUserService.class);  
      
        @Autowired  
        private UserService userService;  
      
        @Test  
        public void save() {  
            User User = new User();  
            User.setId(UUID.randomUUID().toString());  
            User.setNickName("account");  
            User.setRegisterTime(new Date());  
            User.setTelephone("18659675624");
            User.setPassword("123456");
            String id = userService.save(User);  
            LOGGER.info(JSON.toJSONString(id));  
        }  
      
    }  