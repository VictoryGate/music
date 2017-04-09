package com.music.service;

import com.music.model.Role;

public interface RoleService {
	
	Role load(String id);
	void persist(Role entity);
	String save(Role entity);
	void saveOrUpdate(Role entity);
	void delete(String id);
	void flush();
}
