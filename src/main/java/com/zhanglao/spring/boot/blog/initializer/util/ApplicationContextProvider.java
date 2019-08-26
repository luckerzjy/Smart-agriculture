/**
 * 
 */
package com.zhanglao.spring.boot.blog.initializer.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhang
 *
 */
@Configuration
public class ApplicationContextProvider implements ApplicationContextAware {

	/* (non-Javadoc)
	 * �ֶ���ȡbean
	 */
	
	private static ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		
		ApplicationContextProvider.applicationContext = applicationContext;

	}
	
	public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
	
    /**
     * ͨ��name��ȡ Bean.
     *
     * @param name
     * @return
     */
    public static Object getBean(String name) {
        return applicationContext.getBean(name);
    }
    
    /**
     * ͨ��class��ȡBean.
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    /**
     * ͨ��name,�Լ�Clazz����ָ����Bean
     *
     * @param name
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name, Class<T> clazz) {
    	System.out.println("�õ�����");
        return applicationContext.getBean(name, clazz);
    }

}
