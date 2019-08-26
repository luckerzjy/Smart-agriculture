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
 *Ȩ�޹��� 
 */
@Entity
public class Authority implements GrantedAuthority {

	private static final long serialVersionUID = 1L;
	@Id //����
	@GeneratedValue(strategy=GenerationType.IDENTITY)//����������
	private Long id;//�û�Ψһ��ʶ
	@Column(nullable = false)//ӳ��Ϊ�ֶΣ��ǿ�
	private String name;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	/*
	 * Ҫ��getAuthority���أ�����
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
