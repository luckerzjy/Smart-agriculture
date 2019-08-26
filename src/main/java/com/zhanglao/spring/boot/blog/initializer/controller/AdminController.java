package com.zhanglao.spring.boot.blog.initializer.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zhanglao.spring.boot.blog.initializer.vo.Menu;

/**
 * ��̨���������.
 * 
 * @since 1.0.0 2017��5��28��
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
@Controller
@RequestMapping("/admins")
public class AdminController {
 
	/**
	 * ��ȡ��̨������ҳ��
	 * @return
	 */
	@GetMapping
	public ModelAndView listUsers(Model model) {
		List<Menu> list = new ArrayList<>();
		list.add(new Menu("�û�����", "/users"));
		model.addAttribute("list", list);
		return new ModelAndView("/admins/index", "model", model);
	}

}