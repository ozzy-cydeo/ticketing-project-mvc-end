package com.cybertek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cybertek.dto.ProjectDTO;
import com.cybertek.implementation.ProjectServiceImpl;
import com.cybertek.implementation.UserServiceImpl;
import com.cybertek.util.Status;

@Controller
@RequestMapping("/project")
public class ProjectController {

	private ProjectServiceImpl projectService;
	private UserServiceImpl userService;

	@Autowired
	public ProjectController(ProjectServiceImpl projectService, UserServiceImpl userService) {
		this.projectService = projectService;
		this.userService = userService;
	}
	
	@GetMapping("/create")
	public String createProject(Model model) {

		List<ProjectDTO> projects = projectService.getListOfProjectDTO();

		model.addAttribute("projects", projects);
		model.addAttribute("project", new ProjectDTO());
		model.addAttribute("managers", userService.getManagers());

		return "project/create";
	}
	
	@PostMapping("/create")
	public String insertProject(@ModelAttribute("project") ProjectDTO project, Model model) {

		List<ProjectDTO> projects = projectService.getListOfProjectDTO();

		project.setProjectStatus(Status.OPEN);

		projects.add(project);

		model.addAttribute("projects", projects);
		model.addAttribute("project", new ProjectDTO());

		return "project/create";
	}
	
	@GetMapping("/update/{projectCode}")
	public String editProject(@PathVariable("projectCode") String projectCode, Model model) {

		List<ProjectDTO> projects = projectService.getListOfProjectDTO();
		ProjectDTO project = projectService.getProjectDTOByProjectCode(projectCode);
		
	

		model.addAttribute("project", project);
		model.addAttribute("managers", userService.getManagers());
		model.addAttribute("projects", projects);

		return "project/update";
	}
	
	@PostMapping("/update/{projectcode}")
	public String updateProject(@PathVariable("projectcode") String projectcode,@ModelAttribute("project") ProjectDTO projectDTO, Model model) {

		List<ProjectDTO> projects = projectService.updateProjects(projectDTO);

		model.addAttribute("project", projectDTO);
		model.addAttribute("managers", userService.getManagers());
		model.addAttribute("projects", projects);

		return "project/update";
	}
	
	@GetMapping("/delete/{projectCode}")
	public String delete(@PathVariable("projectCode") String projectCode, Model model) {

		List<ProjectDTO> projects = projectService.deleteProjectDTO(projectCode);

		model.addAttribute("project", new ProjectDTO());

		model.addAttribute("managers", userService.getManagers());
		model.addAttribute("projects", projects);

		return "project/create";
	}
	
	@GetMapping("/complete/{projectCode}")
	public String complete(@PathVariable("projectCode") String projectCode, Model model) {

		List<ProjectDTO> projects = projectService.completeProject(projectCode);

		model.addAttribute("project", new ProjectDTO());

		model.addAttribute("managers", userService.getManagers());
		model.addAttribute("projects", projects);

		return "project/create";
	}
	
	
	
	
	
}


