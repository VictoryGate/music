package com.music.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.music.model.Stave;
import com.music.service.StaveService;

@Controller  
 
public class StaveController {
	
	private static final Logger LOGGER = Logger.getLogger(StaveController.class);
	
	@Autowired
	private StaveService staveService;
	
	@ResponseBody
	@RequestMapping( value ="/getStaveList.do",method = RequestMethod.POST)
	public List<Stave> getStaveList(ModelMap modelMap){
		List<Stave> listStave = staveService.findAll();
		//modelMap.addAttribute("listStave", listStave);
		return listStave;
	}

}
