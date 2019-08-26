package com.zhanglao.spring.boot.blog.initializer.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhanglao.spring.boot.blog.initializer.domain.RetMeg;
import com.zhanglao.spring.boot.blog.initializer.repository.RetMegRepository;

@Service
public class RetMegServiceImpl implements RetMegService {
	@Autowired
	private RetMegRepository retMegRepository;
	
	@Transactional
	@Override
	public RetMeg save(RetMeg meg) {
		// TODO Auto-generated method stub
		return retMegRepository.save(meg);
	}

	@Transactional
	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		retMegRepository.delete(id);
	}

	@Transactional
	@Override
	public RetMeg getById(Long id) {
		// TODO Auto-generated method stub
		return retMegRepository.findOne(id);
	}

}
