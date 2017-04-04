package com.music.model;   
    // Generated 2015-2-3 10:43:00 by Hibernate Tools 4.0.0  
      
    import java.util.Date;  
    import java.util.HashSet;  
    import java.util.Set;  
      
    import javax.persistence.Column;  
    import javax.persistence.Entity;  
    import javax.persistence.FetchType;  
    import javax.persistence.Id;  
    import javax.persistence.JoinColumn;  
    import javax.persistence.JoinTable;  
    import javax.persistence.ManyToMany;  
    import javax.persistence.Table;  
    import javax.persistence.Temporal;  
    import javax.persistence.TemporalType;  
      
    import org.hibernate.annotations.Cache;  
    import org.hibernate.annotations.CacheConcurrencyStrategy;  
      
    import com.fasterxml.jackson.annotation.JsonIgnoreProperties;  
      
    /** 
     * User generated by hbm2java 
     */  
    @Entity  
    @Table(name = "app_user")  
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)  
    public class User implements java.io.Serializable {  
      
        /** 
         *  
         */  
        private static final long serialVersionUID = 6980093847795726310L;  
        private String id;  
        private String nickName;  
        private String telephone;  
        private Date registerTime;
        private String password;
        private Set<Role> roles = new HashSet<Role>(0);  
      
        public User() {  
      
        }  
      
        public User(String id, String nickName) {  
            this.id = id;  
            this.nickName = nickName;  
        }  
      
        public User(String id, String nickName, String telephone,  
                Date registerTime, Set<Role> roles) {  
            this.id = id;  
            this.nickName = nickName;  
            this.telephone = telephone;  
            this.registerTime = registerTime;  
            this.roles = roles;  
        }  
      
        @Id  
        @Column(name = "id", unique = true, nullable = false, length = 50)  
        public String getId() {  
            return this.id;  
        }  
      
        public void setId(String id) {  
            this.id = id;  
        }  
      
        @Column(name = "nick_name", nullable = false)  
        public String getNickName() {  
            return this.nickName;  
        }  
      
        public void setNickName(String nickName) {  
            this.nickName = nickName;  
        }  
      
        @Column(name = "telephone")  
        public String getTelephone() {  
            return this.telephone;  
        }  
      
        public void setTelephone(String telephone) {  
            this.telephone = telephone;  
        }  
      
        @Temporal(TemporalType.TIMESTAMP)  
        @Column(name = "register_time", length = 19)  
        public Date getRegisterTime() {  
            return this.registerTime;  
        }  
      
        public void setRegisterTime(Date registerTime) {  
            this.registerTime = registerTime;  
        }  
      
        @JsonIgnoreProperties(value={"users", "authorities"})  
        @ManyToMany(fetch = FetchType.LAZY)  
        @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)  
        @JoinTable(name = "app_user_role",joinColumns = { @JoinColumn(name = "user_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "role_id", nullable = false, updatable = false) })  
        public Set<Role> getRoles() {  
            return this.roles;  
        }  
      
        public void setRoles(Set<Role> Roles) {  
            this.roles = Roles;  
        }
        @Column(name="password")
		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}  
      
    }  