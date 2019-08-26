package com.zhanglao.spring.boot.blog.initializer.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import com.zhanglao.spring.boot.blog.initializer.domain.User;



//user repository �ӿ�

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
}
