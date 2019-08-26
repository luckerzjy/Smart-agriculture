package com.zhanglao.spring.boot.blog.initializer.util;

import java.math.BigInteger;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.zhanglao.spring.boot.blog.initializer.domain.RetMeg;
import com.zhanglao.spring.boot.blog.initializer.service.RetMegService;

import cn.usr.UsrCloudMqttCallbackAdapter;

public class ReceiveDataThread extends UsrCloudMqttCallbackAdapter implements Runnable{

/*	public ReceiveDataThread() {
        //new的时候注入需要的bean
        this.retMegService = ApplicationContextProvider.getBean(RetMegService.class);
    }
	*/
	@Autowired
	RetMegService retMegService=ApplicationContextProvider.getBean(RetMegService.class);	
	RetMeg meg = new RetMeg(); 
	
	
	public ReceiveDataThread(RetMeg j){
		meg=j;
	}
	
	
	@Override
	public void run() {
	
		
		/*
		 * RetMeg meg1 = new RetMeg(); meg1.setDevId("356566078331147"); meg1.
		 * setData("81 80 01 00 01 28 20 23 02 80 81 80 01 01 04 65 35 23 02 80 81 80 01 02 02 2f 01 23 02 80 81 80 01 03 05 48 00 23 02 80 81 80 01 04 06 e 00 23 03 80"
		 * ); meg1.setAddTime(new Date()); retMegService.save(meg1);
		 */
		 
		System.out.println(Thread.currentThread().getName()+":"+meg.getDevId()+meg.getData()+meg.getAddTime());
	//	System.out.println(meg.getDevId());
		retMegService.save(meg); 
	}

}
