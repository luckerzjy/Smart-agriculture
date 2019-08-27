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
 *安全配置类
 */

  @EnableWebSecurity 
  public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	  @Autowired
	  private UserDetailsService userDetailsService;
  
		@Bean  
		public AuthenticationProvider authenticationProvider() {  
			DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
			authenticationProvider.setUserDetailsService(userDetailsService);
			// 暂不设置密码加密方式
		    return authenticationProvider;  
		} 
		
	
	  @Override 
	  protected void configure(HttpSecurity http) throws Exception{
		  http.authorizeRequests()
		  .antMatchers("/css/**","/js/**","/fonts/**","/index").permitAll()
		  .antMatchers("/h2-console/**").permitAll() //均可访问
		  .antMatchers("/users/**").hasRole("ADMIN") .and() .formLogin() //基于form表单的验证
		  .loginPage("/login").failureUrl("/login-error"); 
		  //对获取数据表的保护
		  http.authorizeRequests()
		  .antMatchers("/greenhouse/**").hasAnyRole("ADMIN","USER") .and() .formLogin() //基于form表单的验证
		  .loginPage("/login").failureUrl("/login-error"); 
		  
	    	http.csrf().ignoringAntMatchers("/h2-console/**"); // 禁用 H2 控制台的 CSRF 防护
	    	http.headers().frameOptions().sameOrigin(); // 允许来自同一来源的H2 控制台的请求
	  }
	 
  
  
  /**
   * 登录认证信息管理
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
  
 
