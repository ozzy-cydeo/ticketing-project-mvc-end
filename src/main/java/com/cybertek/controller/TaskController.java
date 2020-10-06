package com.cybertek.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cybertek.dto.TaskDTO;
import com.cybertek.implementation.ProjectServiceImpl;
import com.cybertek.implementation.TaskServiceImpl;
import com.cybertek.implementation.UserServiceImpl;
import com.cybertek.util.Status;


@Controller
@RequestMapping("/task")
public class TaskController {
	
	private TaskServiceImpl taskService;
	private ProjectServiceImpl projectService;
	private UserServiceImpl userService;
	
	@Autowired
	public TaskController(TaskServiceImpl taskService,ProjectServiceImpl projectService,UserServiceImpl userService) {

		this.taskService = taskService;
		this.projectService = projectService;
		this.userService = userService;
	}
	
	@GetMapping("/assign")
	public String assignTask(Model model) {

		List<TaskDTO> tasks = taskService.getListOfTaskDTO();

		model.addAttribute("tasks", tasks);
		model.addAttribute("task", new TaskDTO());
		model.addAttribute("users", userService.listOfUserDTO());
		model.addAttribute("projects",projectService.getListOfProjectDTO());

		return "task/assign";
	}
	
	@PostMapping("/assign")
	public String insertTask(@ModelAttribute("task") TaskDTO task,Model model) {

		List<TaskDTO> tasks = taskService.getListOfTaskDTO();


		task.setStatus(Status.OPEN);
		task.setStartDateTime(LocalDateTime.now());
		tasks.add(task);

		model.addAttribute("tasks", tasks);
		model.addAttribute("task", new TaskDTO());
		
		model.addAttribute("users", userService.listOfUserDTO());
		model.addAttribute("projects", projectService.getListOfProjectDTO());
		
		return "task/assign";
	}
	
	

}


