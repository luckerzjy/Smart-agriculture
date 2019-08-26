/**
 * 
 */
package com.zhanglao.spring.boot.blog.initializer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zhanglao.spring.boot.blog.initializer.domain.Authority;

/**
 * @author zhang
 *Authority ²Ö¿â
 */
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

}
