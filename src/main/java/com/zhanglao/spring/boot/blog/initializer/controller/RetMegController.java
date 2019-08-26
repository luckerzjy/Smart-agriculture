package com.zhanglao.spring.boot.blog.initializer.controller;

import java.util.Date;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.zhanglao.spring.boot.blog.initializer.domain.RetMeg;
import com.zhanglao.spring.boot.blog.initializer.repository.RetMegRepository;
import com.zhanglao.spring.boot.blog.initializer.service.RetMegService;
import com.zhanglao.spring.boot.blog.initializer.util.ClientAdapter;
import com.zhanglao.spring.boot.blog.initializer.util.ClinetCallbackAdapter;
import com.zhanglao.spring.boot.blog.initializer.util.ReceiveDataThread;

@RestController
public class RetMegController {

	@Autowired
	RetMegService service;

	@Autowired
	RetMegRepository regMegRepository;
	
	@RequestMapping("/save")
	//@ResponseBody
	public void save() throws MqttException, InterruptedException {
		/* 1.��ʼ���ͻ������� */
		ClientAdapter clientAdapter = new ClientAdapter();
		/* 2.��ʼ���ͻ��˻ص����� */
		ClinetCallbackAdapter clinetCallbackAdapter = new ClinetCallbackAdapter();
		/* 3.�ͻ������ûص� */
		clientAdapter.setUsrCloudMqttCallback(clinetCallbackAdapter);
		System.out.println("over!");
		/* 4.�������� */
		clientAdapter.Connect("wd666", "11111111");
		Thread.sleep(3000);
		/* 5.������Ϣ(�����豸) */

		clientAdapter.SubscribeForDevId("356566078331147");

		Long nowid=1L;
		  RetMeg meg1 = new RetMeg(); meg1.setId(nowid);meg1.setDevId("356566078331147"); meg1.
		  setData("81 80 01 00 01 28 20 23 02 80 81 80 01 01 04 65 35 23 02 80 81 80 01 02 02 2f 01 23 02 80 81 80 01 03 05 48 00 23 02 80 81 80 01 04 06 e 00 23 03 80"
		  ); meg1.setAddTime(new Date()); service.save(meg1);
		  System.out.println("�����ϵ�:"+meg1.getDevId()); ReceiveDataThread Rec = new
		  ReceiveDataThread(meg1); Thread t = new Thread(Rec); t.start();
		 
		System.out.println("hhh" + clinetCallbackAdapter.returnData().getDevId());
	}
	
	//�ĵ�������

	@GetMapping("/dataset")
	public ModelAndView list(Model model) {
		model.addAttribute("dataList",regMegRepository.findAll());
		model.addAttribute("title", "����չʾ");
		return new ModelAndView("/dataset","dataModel",model);
	}

}
