package com.zhanglao.spring.boot.blog.initializer.service;

import com.zhanglao.spring.boot.blog.initializer.domain.RetMeg;

public interface RetMegService {
	RetMeg save(RetMeg meg);
	void remove(Long id);
	RetMeg getById(Long id);
}
