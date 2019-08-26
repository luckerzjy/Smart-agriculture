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
	 * 手动获取bean
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
     * 通过name获取 Bean.
     *
     * @param name
     * @return
     */
    public static Object getBean(String name) {
        return applicationContext.getBean(name);
    }
    
    /**
     * 通过class获取Bean.
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    /**
     * 通过name,以及Clazz返回指定的Bean
     *
     * @param name
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name, Class<T> clazz) {
    	System.out.println("拿到了吗");
        return applicationContext.getBean(name, clazz);
    }

}
