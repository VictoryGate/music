package com.music.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.music.model.Stave;
import com.music.service.StaveService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:conf/spring.xml",  
        "classpath:conf/spring-hibernate.xml"})  
public class TestStaveService {
	
	 private static final Logger LOGGER = Logger  
             .getLogger(TestStaveService.class);  
	 
	 @Autowired 
	 private StaveService staveService;
	 
	 @Test
	 public void getStaveList(){
		 List<Stave> list = staveService.findAll();
		 System.out.println(list.toString());
	 }

}
