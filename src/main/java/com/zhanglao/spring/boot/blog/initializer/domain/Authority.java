/**
 * 
 */
package com.zhanglao.spring.boot.blog.initializer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author zhang
 *权限管理 
 */
@Entity
public class Authority implements GrantedAuthority {

	private static final long serialVersionUID = 1L;
	@Id //主键
	@GeneratedValue(strategy=GenerationType.IDENTITY)//自增长策略
	private Long id;//用户唯一标识
	@Column(nullable = false)//映射为字段，非空
	private String name;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	/*
	 * 要用getAuthority返回，弃用
	 * public String getName() { return name; }
	 */
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String getAuthority() {
		return name;
	}

}
