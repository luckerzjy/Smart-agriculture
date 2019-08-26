package com.zhanglao.spring.boot.blog.initializer.service;

import com.zhanglao.spring.boot.blog.initializer.domain.User;

/**
 * �û�����ӿ�
 * @author zhang
 *
 */
public interface UserService {
	/**
	 * �����༭�����û�
	 * @param user
	 * @return
	 */
	 User saveOrUpdateUser(User user);
	/**
	 * ע���û�
	 * @param user
	 * @return
	 */
	 User registerUser(User user);
	 /**
	  * ɾ���û�
	  * @param id
	  */
	 void removeUser(Long id);
	 /**
	  * ����id��ȡ�û�
	  * @param id
	  * @return
	  */
	 User getUserById(Long id);
 
}
