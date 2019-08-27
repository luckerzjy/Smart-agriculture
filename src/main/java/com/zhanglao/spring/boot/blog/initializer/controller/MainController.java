/**
 * 
 */
package com.zhanglao.spring.boot.blog.initializer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.zhanglao.spring.boot.blog.initializer.domain.User;
import com.zhanglao.spring.boot.blog.initializer.service.UserService;

/**
 * @author zhang Ö÷Ò³¿ØÖÆÆ÷
 */
@Controller
public class MainController {
	@Autowired
	private UserService userService;
	@GetMapping("/")
	public String root() {
		return "redirect:/index2";
	}
	
	
	@GetMapping("/index2")
	public String index() {
		return "index2";
	}

	
	  @GetMapping("/greenhouse")
	  public String greenhouse() { 
		  return "greenhouse"; 
	}
	 
	
	
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		model.addAttribute("errorMsg", "fail to login");
		return "login";
	}



}
