package com.music.dao.Impl;  
    import java.util.List;   
    import org.hibernate.Session;  
    import org.hibernate.SessionFactory;  
    import org.springframework.beans.factory.annotation.Autowired;  
    import org.springframework.stereotype.Repository;

import com.music.dao.UserDao;
import com.music.model.User;  
  
    @Repository("userDao")  
    public class UserDaoImpl implements UserDao {  
      
        @Autowired  
        private SessionFactory sessionFactory;  
      
        private Session getCurrentSession() {  
            return this.sessionFactory.getCurrentSession();  
        }  
      
        public User load(String id) {  
            return (User) this.getCurrentSession().load(User.class, id);  
        }  
          
        public User get(String id) {  
            return (User) this.getCurrentSession().get(User.class, id);  
        }  
      
        @SuppressWarnings("unchecked")  
        public List<User> findAll() {  
            List<User> users = this.getCurrentSession().createQuery("from User").setCacheable(true).list();  
            return users;  
        }  
      
        public void persist(User entity) {  
            this.getCurrentSession().persist(entity);  
      
        }  
      
        public String save(User entity) {  
            return (String) this.getCurrentSession().save(entity);  
        }  
      
        public void saveOrUpdate(User entity) {  
            this.getCurrentSession().saveOrUpdate(entity);  
        }  
      
        public void delete(String id) {  
            User entity = this.load(id);  
            this.getCurrentSession().delete(entity);  
        }  
      
        public void flush() {  
            this.getCurrentSession().flush();  
      
        }

		public User selectUserByUserName(String userName) {
			String sql = "from User where nickName=?";
			User user = (User) this.getCurrentSession().createQuery(sql).setParameter(0, userName).setCacheable(true).uniqueResult();
			return user;
		}  
      
    }  