package com.zhanglao.spring.boot.blog.initializer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.zhanglao.spring.boot.blog.initializer.domain.Authority;
import com.zhanglao.spring.boot.blog.initializer.domain.User;
import com.zhanglao.spring.boot.blog.initializer.repository.UserRepository;
import com.zhanglao.spring.boot.blog.initializer.service.AuthorityService;
import com.zhanglao.spring.boot.blog.initializer.service.UserService;

/**
 * 用户管理控制器
 * @author zhang
 *
 */

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthorityService authorityService;
	//查询所有用户
	@GetMapping
	
	public ModelAndView list(Model model) {
		model.addAttribute("userList",userRepository.findAll());
		model.addAttribute("title", "用户管理");
		return new ModelAndView("users/list","userModel",model);
	}
	//根据ID查询用户
	@GetMapping("{id}")
	public ModelAndView view (@PathVariable("id")  Long id,Model model) {
		User user = userRepository.findOne(id);
		model.addAttribute("user",user);
		model.addAttribute("title", "查看用户");
		return new ModelAndView("users/edit","userModel",model);
	}
	
	//获取创建表单页面
	@GetMapping("/add")
	public ModelAndView createForm (Model model) {
		model.addAttribute("user",new User(null,null,null,null));
		model.addAttribute("title", "创建用户");
		return new ModelAndView("users/add","userModel",model);
	}
	
	@PostMapping
	public ModelAndView saveOrUpdateUser(User user, Long authorityId) {
		
		List<Authority> authorities = new ArrayList<>();
		authorities.add(authorityService.getAuthorityById(authorityId));
		user.setAuthorities(authorities);
		
		 userService.registerUser(user);
		return new ModelAndView("redirect:/users");
	}
	//删除用户
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
			userRepository.delete(id);
			return new ModelAndView("redirect:/users");
	}
	//修改用户
	@GetMapping("/modify/{id}")
	public ModelAndView modify(@PathVariable("id") Long id, Model model) {
		User user = userRepository.findOne(id);
		model.addAttribute("user",user);
		model.addAttribute("title","修改用户");
		return new ModelAndView("users/add","userModel",model);
	}
	
	
}
