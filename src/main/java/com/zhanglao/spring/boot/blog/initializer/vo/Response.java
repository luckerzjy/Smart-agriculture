package com.zhanglao.spring.boot.blog.initializer.vo;
/**
 * 统一处理返回对象
 * @author zhang
 *
 */
public class Response {
	private boolean success;//处理是否成功
	private String message;//处理后返回的数据
	private Object body;//处理后返回的数据
	
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
