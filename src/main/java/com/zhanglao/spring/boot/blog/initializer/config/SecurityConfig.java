/**
 * 
 */
package com.zhanglao.spring.boot.blog.initializer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author zhang
 *��ȫ������
 */

  @EnableWebSecurity 
  public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	  @Autowired
	  private UserDetailsService userDetailsService;
  
		@Bean  
		public AuthenticationProvider authenticationProvider() {  
			DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
			authenticationProvider.setUserDetailsService(userDetailsService);
			// �ݲ�����������ܷ�ʽ
		    return authenticationProvider;  
		} 
		
	
	  @Override 
	  protected void configure(HttpSecurity http) throws Exception{
		  http.authorizeRequests()
		  .antMatchers("/css/**","/js/**","/fonts/**","/index").permitAll()
		  .antMatchers("/h2-console/**").permitAll() //���ɷ���
		  .antMatchers("/users/**").hasRole("ADMIN") .and() .formLogin() //����form������֤
		  .loginPage("/login").failureUrl("/login-error"); 
		  //�Ի�ȡ���ݱ�ı���
		  http.authorizeRequests()
		  .antMatchers("/greenhouse/**").hasAnyRole("ADMIN","USER") .and() .formLogin() //����form������֤
		  .loginPage("/login").failureUrl("/login-error"); 
		  
	    	http.csrf().ignoringAntMatchers("/h2-console/**"); // ���� H2 ����̨�� CSRF ����
	    	http.headers().frameOptions().sameOrigin(); // ��������ͬһ��Դ��H2 ����̨������
	  }
	 
  
  
  /**
   * ��¼��֤��Ϣ����
   * @param auth
   * @throws Exception
   */
  @Autowired 
  public void configureGlobal(AuthenticationManagerBuilder auth)throws Exception { 
		/*
		 * auth .inMemoryAuthentication() .withUser("lucker") .password("123")
		 * .roles("ADMIN");
		 */
	  
	  	auth.userDetailsService(userDetailsService);
	  	auth.authenticationProvider(authenticationProvider());
  }
  

  
  
  
  }
  
 
