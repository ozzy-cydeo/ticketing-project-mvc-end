package com.cybertek.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cybertek.data.DataGenerator;
import com.cybertek.dto.TaskDTO;
import com.cybertek.dto.UserDTO;
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


		task.setTaskStatus(Status.OPEN);
		task.setStartDateTime(LocalDateTime.now());
		tasks.add(task);

		model.addAttribute("tasks", tasks);
		model.addAttribute("task", new TaskDTO());
		
		model.addAttribute("users", userService.listOfUserDTO());
		model.addAttribute("projects", projectService.getListOfProjectDTO());
		
		return "task/assign";
	}
	
	@GetMapping("/update/{id}")
	public String editTask(@PathVariable("id") Long id, Model model) {

		List<TaskDTO> tasks = taskService.getListOfTaskDTO();

		TaskDTO task = taskService.getTaskDTOById(id);
				
		model.addAttribute("tasks", tasks);
		
		model.addAttribute("task", task);
		model.addAttribute("users", userService.listOfUserDTO());
		model.addAttribute("projects", projectService.getListOfProjectDTO());

		return "task/update";
	}
	
	@PostMapping("/update/{id}")
	public String update(@PathVariable("id") Long id, @ModelAttribute("task") TaskDTO taskDTO,Model model) {

		List<TaskDTO> tasks = taskService.updateTaskDTO(taskDTO);
				
	
		model.addAttribute("tasks", tasks);
		
		model.addAttribute("task", taskDTO);
		model.addAttribute("users", userService.listOfUserDTO());
		model.addAttribute("projects", projectService.getListOfProjectDTO());

		return "task/update";
	}

	@GetMapping("/delete/{id}")
	public String deleteTask(@PathVariable("id") Long id,Model model) {

		List<TaskDTO> tasks = taskService.deleteTask(id);
				
		model.addAttribute("tasks", tasks);
		model.addAttribute("users", userService.listOfUserDTO());
		model.addAttribute("task", new TaskDTO());
		model.addAttribute("projects", projectService.getListOfProjectDTO());

		return "task/assign";
	}
	
	///////////////////////
	
	@GetMapping("/employee/taskStatus")
	public String getStatusOfTask(Model model) {

		UserDTO user = DataGenerator.activeUser;
		List<TaskDTO> tasks = taskService.getEmployeeTasks(user);

		model.addAttribute("tasks", tasks);
		model.addAttribute("task", new TaskDTO());
		
		model.addAttribute("statuses", DataGenerator.getStatusList());
		model.addAttribute("users", userService.listOfUserDTO());
		model.addAttribute("projects",projectService.getListOfProjectDTO() );

		return "task/task-status";
	}
	
	@GetMapping("/employee/update/{id}")
	public String editTaskStatus(@PathVariable("id") Long id, Model model) {

		UserDTO user = DataGenerator.activeUser;
		List<TaskDTO> tasks = taskService.getEmployeeTasks(user);

		TaskDTO task =  taskService.getTaskDTOById(id);


		model.addAttribute("tasks", tasks);

		model.addAttribute("task", task);
		model.addAttribute("users", userService.listOfUserDTO());
		model.addAttribute("projects", projectService.getListOfProjectDTO());
		model.addAttribute("statuses", DataGenerator.getStatusList());
		return "task/task-update";
	}
	
	
	@PostMapping("/employee/update/{id}")
	public String updateTaskStatus(@PathVariable("id") Long id, @ModelAttribute("task") TaskDTO taskDTO,Model model) {

		UserDTO user = DataGenerator.activeUser;
		
		List<TaskDTO> tasks =taskService.updateTaskDTOForEmployee(user,taskDTO);

		model.addAttribute("tasks", tasks);
		
		model.addAttribute("task", taskDTO);
		model.addAttribute("statuses", DataGenerator.getStatusList());
		model.addAttribute("users", userService.listOfUserDTO());
		model.addAttribute("projects", projectService.getListOfProjectDTO());

		return "task/task-update";
	}
	
	////////////////////
	
	@GetMapping("/employee/archive")
	public String getCompletedTasks(Model model) {

		UserDTO user = DataGenerator.activeUser;
		
		List<TaskDTO> tasks = taskService.archiveList(user);
				
		model.addAttribute("tasks", tasks);

		return "task/task-archive";
	}
	

}


