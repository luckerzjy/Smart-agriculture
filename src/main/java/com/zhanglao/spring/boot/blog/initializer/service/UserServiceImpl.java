package com.zhanglao.spring.boot.blog.initializer.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zhanglao.spring.boot.blog.initializer.domain.User;
import com.zhanglao.spring.boot.blog.initializer.repository.UserRepository;

/**
 * 用户服务接口实现
 * @author zhang
 *
 */
@Service
public class UserServiceImpl implements UserService,UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	@Override
	public User saveOrUpdateUser(User user) {
		return userRepository.save(user);
	}


	@Transactional
	@Override
	public User registerUser(User user) {
		return userRepository.save(user);
	}


	@Transactional
	@Override
	public void removeUser(Long id) {
		userRepository.delete(id);

	}


	@Override
	public User getUserById(Long id) {
		return userRepository.findOne(id);
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username);
	}


}
