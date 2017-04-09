package com.music.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.dao.RoleDao;
import com.music.model.Role;
import com.music.service.RoleService;
@Service(value="RoleService")
public class RoleServiceImpl implements RoleService {

	@Autowired  
    private RoleDao roleDao; 
	
	public Role load(String id) {
		return (Role) this.roleDao.load(id);
	}

	public void persist(Role entity) {
		this.persist(entity);

	}

	public String save(Role entity) {
		return this.save(entity);
	}

	public void saveOrUpdate(Role entity) {
		this.saveOrUpdate(entity);
	}

	public void delete(String id) {
		this.delete(id);
	}

	public void flush() {
		this.flush();
	}

}
