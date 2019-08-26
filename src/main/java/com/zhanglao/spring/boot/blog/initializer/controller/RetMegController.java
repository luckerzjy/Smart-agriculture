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
		/* 1.初始化客户端适配 */
		ClientAdapter clientAdapter = new ClientAdapter();
		/* 2.初始化客户端回调适配 */
		ClinetCallbackAdapter clinetCallbackAdapter = new ClinetCallbackAdapter();
		/* 3.客户端设置回调 */
		clientAdapter.setUsrCloudMqttCallback(clinetCallbackAdapter);
		System.out.println("over!");
		/* 4.进行连接 */
		clientAdapter.Connect("wd666", "11111111");
		Thread.sleep(3000);
		/* 5.订阅消息(单个设备) */

		clientAdapter.SubscribeForDevId("356566078331147");

		Long nowid=1L;
		  RetMeg meg1 = new RetMeg(); meg1.setId(nowid);meg1.setDevId("356566078331147"); meg1.
		  setData("81 80 01 00 01 28 20 23 02 80 81 80 01 01 04 65 35 23 02 80 81 80 01 02 02 2f 01 23 02 80 81 80 01 03 05 48 00 23 02 80 81 80 01 04 06 e 00 23 03 80"
		  ); meg1.setAddTime(new Date()); service.save(meg1);
		  System.out.println("来了老弟:"+meg1.getDevId()); ReceiveDataThread Rec = new
		  ReceiveDataThread(meg1); Thread t = new Thread(Rec); t.start();
		 
		System.out.println("hhh" + clinetCallbackAdapter.returnData().getDevId());
	}
	
	//改到这里了

	@GetMapping("/dataset")
	public ModelAndView list(Model model) {
		model.addAttribute("dataList",regMegRepository.findAll());
		model.addAttribute("title", "数据展示");
		return new ModelAndView("/dataset","dataModel",model);
	}

}
