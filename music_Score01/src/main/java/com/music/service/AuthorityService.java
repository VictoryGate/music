package com.music.service;

import com.music.model.Authority;

public interface AuthorityService {

	
	Authority load(String id);
	void persist(Authority entity);
	String save(Authority entity);
	void saveOrUpdate(Authority entity);
	void delete(String id);
	void flush();
}
