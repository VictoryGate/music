package com.music.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.dao.AuthorityDao;
import com.music.model.Authority;
import com.music.service.AuthorityService;
@Service(value="AuthorityService")
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired  
    private AuthorityDao authorityDao; 
	
	public Authority load(String id) {
		return (Authority) this.authorityDao.load(id);
	}

	public void persist(Authority entity) {
		this.persist(entity);
	}

	public String save(Authority entity) {
		return this.authorityDao.save((AuthorityDao) entity);
	}

	public void saveOrUpdate(Authority entity) {
		this.authorityDao.saveOrUpdate((AuthorityDao) entity);
	}

	public void delete(String id) {
		this.authorityDao.delete(id);
	}

	public void flush() {
		this.flush();
	}

}
