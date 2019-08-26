package com.zhanglao.spring.boot.blog.initializer.util;

import org.eclipse.paho.client.mqttv3.MqttException;

import cn.usr.UsrCloudMqttClientAdapter;
import cn.usr.client.UsrCloudMqttCallback;

/**1.继承 UsrCloudMqttClientAdapter */
public class ClientAdapter extends UsrCloudMqttClientAdapter {
	
    /**2.重写 父类的方法*/
	@Override
	public void Connect(String userName, String passWord) throws MqttException {
		super.Connect(userName, passWord);
	}
	
    @Override
    public boolean DisConnectUnCheck() throws MqttException {
        return super.DisConnectUnCheck();
    }

    @Override
    public void SubscribeForDevId(String devId) throws MqttException {
        super.SubscribeForDevId(devId);
    }

    @Override
    public void SubscribeForUsername() throws MqttException {
        super.SubscribeForUsername();
    }

    @Override
    public void DisSubscribeforDevId(String devId) throws MqttException {
        super.DisSubscribeforDevId(devId);
    }

    @Override
    public void DisSubscribeforuName() throws MqttException {
        super.DisSubscribeforuName();
    }
    
    /**3.客户端设置回调*/
    @Override
    public void setUsrCloudMqttCallback(UsrCloudMqttCallback CloudMqttCallback) {
        super.setUsrCloudMqttCallback(CloudMqttCallback);
        System.out.println("CloudMqttCallback="+CloudMqttCallback);
        
    }

    @Override
    public void publishForDevId(String devId, byte[] data) throws MqttException {
        super.publishForDevId(devId, data);
    }

    @Override
    public void publishForuName(byte[] data) throws MqttException {
        super.publishForuName(data);
    }


}
