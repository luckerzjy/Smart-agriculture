package com.zhanglao.spring.boot.blog.initializer.service;

import com.zhanglao.spring.boot.blog.initializer.domain.User;

/**
 * 用户服务接口
 * @author zhang
 *
 */
public interface UserService {
	/**
	 * 新增编辑保存用户
	 * @param user
	 * @return
	 */
	 User saveOrUpdateUser(User user);
	/**
	 * 注册用户
	 * @param user
	 * @return
	 */
	 User registerUser(User user);
	 /**
	  * 删除用户
	  * @param id
	  */
	 void removeUser(Long id);
	 /**
	  * 根据id获取用户
	  * @param id
	  * @return
	  */
	 User getUserById(Long id);
 
}
