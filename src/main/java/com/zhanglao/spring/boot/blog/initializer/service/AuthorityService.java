/**
 * 
 */
package com.zhanglao.spring.boot.blog.initializer.service;

import com.zhanglao.spring.boot.blog.initializer.domain.Authority;

/**
 * @author zhang
 *Authority ����ӿ�
 */
public interface AuthorityService {
/**
 * ����ID��ѯAuthority
 */
	Authority getAuthorityById(Long id);
}
