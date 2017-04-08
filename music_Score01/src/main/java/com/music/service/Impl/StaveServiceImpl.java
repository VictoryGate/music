package com.music.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.dao.StaveDao;
import com.music.model.Stave;
import com.music.service.StaveService;

@Service("staveService")  
public class StaveServiceImpl implements StaveService {
	
	@Autowired  
	private StaveDao staveDao;

	@Override
	public List<Stave> findAll() {
		
		return staveDao.findAll();
	}

}
