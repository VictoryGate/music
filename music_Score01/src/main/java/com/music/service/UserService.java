package com.music.service;

import java.util.List;

import com.music.model.User;


public interface UserService {
	 User load(String id);  
     
     User get(String id);  
   
     List<User> findAll();  
   
     void persist(User entity);  
   
     String save(User entity);  
   
     void saveOrUpdate(User entity);  
   
     void delete(String id);  
   
     void flush();
     
     User selectUserByUserName(String userName);
}
