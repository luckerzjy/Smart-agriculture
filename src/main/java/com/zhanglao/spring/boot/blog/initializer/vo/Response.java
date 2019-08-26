package com.zhanglao.spring.boot.blog.initializer.vo;
/**
 * ͳһ�����ض���
 * @author zhang
 *
 */
public class Response {
	private boolean success;//�����Ƿ�ɹ�
	private String message;//����󷵻ص�����
	private Object body;//����󷵻ص�����
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}
	
	public Response(boolean success,String message) {
		this.success=success;
		this.message=message;
	}
	public Response(boolean success,String message,Object body) {
		this.success=success;
		this.message=message;
		this.body=body;
	}
}
