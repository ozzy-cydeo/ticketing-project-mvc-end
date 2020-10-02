package com.cybertek.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cybertek.dto.RoleDTO;
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
	public String createUser(Model model) {
		
		UserDTO user = new UserDTO();
		
		List<UserDTO> users = userService.listOfUserDTO();
		List<RoleDTO> roles = roleService.getRoleDTOs();
		
		model.addAttribute("user", user);
		
		model.addAttribute("users",users );
		
		model.addAttribute("roles", roles);
		
	
		

		return "user/create";
	}
	
	@PostMapping("/create")
	public String insertUser(@ModelAttribute("user") UserDTO user,Model model) {
		
		List<UserDTO> users = userService.listOfUserDTO();
		users.add(user);
		
		model.addAttribute("users", users);
		model.addAttribute("user", new UserDTO());
		model.addAttribute("roles", roleService.getRoleDTOs());

		return "user/create";
	}
	
	
	
	@GetMapping("/update/{username}")
	public String editUser(@PathVariable("username") String username, Model model) {

		List<UserDTO> users = userService.listOfUserDTO();

		model.addAttribute("user", userService.userByUserName(username));

		model.addAttribute("users", users);

		model.addAttribute("roles", roleService.getRoleDTOs());

		return "user/update";
	}
	
	@PostMapping("/update/{username}")
	public String updateUser(@PathVariable("username") String username, @ModelAttribute("user") UserDTO user, Model model) {

		List<UserDTO> users = userService.updateUsers(user);

		model.addAttribute("users", users);
		model.addAttribute("user", user);
		model.addAttribute("roles", roleService.getRoleDTOs());
		
		return "user/update";
	}
	
	@GetMapping(value = "/delete/{username}")
	public String deleteUser(@PathVariable("username") String username, Model model) {

		List<UserDTO> users = userService.deleteUser(username);

		model.addAttribute("users", users);
		model.addAttribute("user", new UserDTO());
		model.addAttribute("roles", roleService.getRoleDTOs());
		
		return "user/create";
	}
	
	
}
