package com.cybertek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cybertek.dto.UserDTO;
import com.cybertek.implementation.RoleServiceImpl;
import com.cybertek.implementation.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private UserServiceImpl userService;
	
	private RoleServiceImpl roleService;

	@Autowired
	public UserController(UserServiceImpl userService,RoleServiceImpl roleService) {
		this.userService = userService;
		this.roleService=roleService;
	}
	
	@GetMapping("/create")
	public String add(Model model) {
		model.addAttribute("user", new UserDTO());
		model.addAttribute("users", userService.listOfUserDTO());
		model.addAttribute("roles", roleService.getRoleDTOs());

		return "user/create";
	}
	
	
	
	

}
