package com.zhanglao.spring.boot.blog.initializer.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.zhanglao.spring.boot.blog.initializer.domain.RetMeg;


public interface RetMegRepository extends JpaRepository<RetMeg, Long>{

	RetMeg getById(Long id);
}
