/**
 * 
 */
package com.zhanglao.spring.boot.blog.initializer.service;

import com.zhanglao.spring.boot.blog.initializer.domain.Authority;

/**
 * @author zhang
 *Authority 服务接口
 */
public interface AuthorityService {
/**
 * 根据ID查询Authority
 */
	Authority getAuthorityById(Long id);
}
