package com.music.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.music.dao.RoleDao;
import com.music.model.Role;
@SuppressWarnings("unchecked")
@Repository(value="RoleDao")
public class RoleDaoImpl implements RoleDao{
	 @Autowired  
     private SessionFactory sessionFactory;
	 
	private Session getCurrentSession() {  
         return this.sessionFactory.getCurrentSession();  
     }  
	public RoleDao load(String id) {
		return (RoleDao) this.getCurrentSession().load(Role.class, id);
	}

	public RoleDao get(String id) {
		return this.get(id);
	}

	public List<RoleDao> findAll() {
		return this.getCurrentSession().createQuery("from Role").setCacheable(true).list();
	}

	public void persist(RoleDao entity) {
		this.getCurrentSession().persist(entity);
		
	}

	public String save(RoleDao entity) {
		return (String) this.getCurrentSession().save(entity);
	}

	public void saveOrUpdate(RoleDao entity) {
		this.getCurrentSession().saveOrUpdate(entity);
	}

	public void delete(String id) {
		this.getCurrentSession().delete(id);
	}

	public void flush() {
		this.getCurrentSession().flush();
	}

}
