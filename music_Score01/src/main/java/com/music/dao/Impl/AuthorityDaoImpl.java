package com.music.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.music.dao.AuthorityDao;
import com.music.model.Authority;
@SuppressWarnings("unchecked")
@Repository(value="AuthorityDao")
public class AuthorityDaoImpl implements AuthorityDao{
	
	 @Autowired  
     private SessionFactory sessionFactory;
	 
	private Session getCurrentSession() {  
         return this.sessionFactory.getCurrentSession();  
     }  
	public AuthorityDao load(String id) {
		return (AuthorityDao) this.getCurrentSession().load(Authority.class, id);
	}

	public AuthorityDao get(String id) {
		return (AuthorityDao) this.getCurrentSession().load(Authority.class, id);
	}

	public List<AuthorityDao> findAll() {
		return this.getCurrentSession().createQuery("from Authority").setCacheable(true).list();
	}

	public void persist(AuthorityDao entity) {
		this.getCurrentSession().persist(entity);
		
	}

	public String save(AuthorityDao entity) {
		return (String) this.getCurrentSession().save(entity);
	}

	public void saveOrUpdate(AuthorityDao entity) {
		this.getCurrentSession().saveOrUpdate(entity);
	}

	public void delete(String id) {
		this.getCurrentSession().delete(id);
		
	}

	public void flush() {
		this.getCurrentSession().flush();
		
	}

}
