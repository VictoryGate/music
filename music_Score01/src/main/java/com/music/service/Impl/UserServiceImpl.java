package com.music.service.Impl;   
    import java.util.List;  
      
    import org.springframework.beans.factory.annotation.Autowired;  
    import org.springframework.stereotype.Service;

import com.music.dao.UserDao;
import com.music.model.User;
import com.music.service.UserService;
import com.music.utils.MD5;  

    @Service("userService")  
    public class UserServiceImpl implements UserService {  
      
        @Autowired  
        private UserDao userDao;  
      
        public User load(String id) {  
            return userDao.load(id);  
        }  
      
        public User get(String id) {  
            return userDao.get(id);  
        }  
      
        public List<User> findAll() {  
            return userDao.findAll();  
        }  
      
        public void persist(User entity) {  
            userDao.persist(entity);  
        }  
      
        public String save(User entity) {
        	entity.setPassword(MD5.getMD5(MD5.getMD5(entity.getPassword())+entity.getNickName()));
            return userDao.save(entity);
        }  
      
        public void saveOrUpdate(User entity) {  
            userDao.saveOrUpdate(entity);  
        }  
      
        public void delete(String id) {  
            userDao.delete(id);  
        }  
      
        public void flush() {  
            userDao.flush();  
        }

		public User selectUserByUserName(String userName) {
			
			return userDao.selectUserByUserName(userName);
		}  
      
    }  