package com.music.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.music.dao.StaveDao;
import com.music.model.Stave;

@Repository("staveDao")  
public class StaveDaoImpl implements StaveDao{
	
	 @Autowired  
     private SessionFactory sessionFactory;  
   
     private Session getCurrentSession() {  
         return this.sessionFactory.getCurrentSession(); 
     }


	public Stave load(String id) {
		// TODO Auto-generated method stub
		return null;
	}


	public Stave get(String id) {
		// TODO Auto-generated method stub
		return null;
	}


	@SuppressWarnings("unchecked")  
	public List<Stave> findAll() {
		List<Stave> staves = this.getCurrentSession().createQuery("from Stave").setCacheable(true).list();
		return staves;
	}


	public void persist(Stave entity) {
		// TODO Auto-generated method stub
		
	}


	public String save(Stave entity) {
		// TODO Auto-generated method stub
		return null;
	}


	public void saveOrUpdate(Stave entity) {
		// TODO Auto-generated method stub
		
	}


	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	public void flush() {
		// TODO Auto-generated method stub
		
	}

}
