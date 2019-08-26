/**
 * 
 */
package com.zhanglao.spring.boot.blog.initializer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhanglao.spring.boot.blog.initializer.domain.Authority;
import com.zhanglao.spring.boot.blog.initializer.repository.AuthorityRepository;

/**
 * @author zhang
 *Authority服务实现
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {
	
	
	@Autowired
	private AuthorityRepository authorityRepository;

	@Override
	public Authority getAuthorityById(Long id) {
		return authorityRepository.findOne(id);
	}

}
