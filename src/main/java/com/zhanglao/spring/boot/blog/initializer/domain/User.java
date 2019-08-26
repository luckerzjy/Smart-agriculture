package com.zhanglao.spring.boot.blog.initializer.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



/**
 * @author zhang
 *user实体
 */
@Entity
public class User implements UserDetails{
		/**
	 * spring security 要求要实现UserDetails
	 */
	private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column
		private Long id;
		@Column
		private String name;
		@Column
		private String email;
		@Column
		private String username;
		@Column
		private String password;
		/**
		 * 建立用户和权限的关系
		 */
		@ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
		@JoinTable(name = "user_authority", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), 
			inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
		private List<Authority> authorities;//一个用户可能有多个权限，所以list
		
		
		protected User() {
			
		}
		public User(Long id,String name,String email,String username) {
			this.id = id;
			this.name=name;
			this.email=email;
			this.username=username;
		}
		
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		@Override
		public String toString() {
			return String.format("User[id=%d,username='%s',name='%s',email='%s']", id,username,name,email);
		}
		/**
		 * 获取权限信息方法
		 */
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			//需要将List<Authority>转成List<SimpleGrantedAuthority>，否则前端拿不到角色列表名称
			List<SimpleGrantedAuthority> simpleAuthorities = new ArrayList<>();
			for(GrantedAuthority authority : this.authorities){
				simpleAuthorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
			}
			return simpleAuthorities;
		}
		
		public void setAuthorities(List<Authority> authorities) {
			this.authorities = authorities;
			
		}
		
		
		@Override
		public boolean isAccountNonExpired() {
			return true;
		}
		@Override
		public boolean isAccountNonLocked() {
			return true;
		}
		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}
		@Override
		public boolean isEnabled() {
			return true;
		}

}
