package com.zhanglao.spring.boot.blog.initializer.util;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Id;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhanglao.spring.boot.blog.initializer.domain.RetMeg;
import com.zhanglao.spring.boot.blog.initializer.service.RetMegService;

import cn.usr.UsrCloudMqttCallbackAdapter;

public class ClinetCallbackAdapter extends UsrCloudMqttCallbackAdapter {

	@Autowired
	RetMegService retMegservice;
	 RetMeg meg = new RetMeg(); 
	public Long nowid=(long) 0;
	/* private Long id =(long) 123; */
	/*
	 * private String devId = (String) "111"; private String data = (String) "111";
	 * private Date addTime = new Date(); RetMeg meg = new RetMeg(devId, data);
	 */

	private int flag = 0;

	/** 2.重写 onConnectAck 方法 */

	@Override
	public void onConnectAck(int returnCode, String description) {
		super.onConnectAck(returnCode, description);
		System.out.println("---------onConnectAck---------------");
		System.out.println("returnCode=" + returnCode);
		System.out.println("description=" + description);
		
		  if(returnCode==2) { 
			  	
		  }
/*		  new ReceiveDataThread(meg); Thread t= new Thread(Rec);
		  
		  t.start(); //创建计入数据库线程 }
*/		 
	}
	
	
	
	@Override
	public void onReceiveEvent(int messageId, String topic, byte[] data) {
		// System.out.println("==onReceiveEvent==");
		/* RetMeg meg = new RetMeg(); */
		ReceiveDataThread Rec = new ReceiveDataThread(meg);
		String da = null;
		da = bytes2hex01(data);// 调用转化字节方法
	
		String[] id = topic.split("/");
		meg.setDevId(id[2]);
		meg.setData(da);
		meg.setAddTime(new Date());
		meg.setId(nowid);
		nowid++;
	//	 retMegservice.save(meg);
		Thread t = new Thread(Rec);
		t.start();
		System.out.println(meg.getDevId());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// retMegservice.save(meg);
	}

	
	public RetMeg returnData() {
		return meg;
	}
	
	public static String bytes2hex01(byte[] bytes) {
		BigInteger b = new BigInteger(1, bytes);
		//System.out.println(b.toString(16));
		return b.toString(16);
	}

}
