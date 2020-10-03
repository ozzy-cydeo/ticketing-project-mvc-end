package com.cybertek.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybertek.data.DataGenerator;
import com.cybertek.dto.ProjectDTO;
import com.cybertek.dto.UserDTO;
import com.cybertek.entity.Project;
import com.cybertek.entity.User;
import com.cybertek.implementation.ProjectServiceImpl;
import com.cybertek.implementation.UserServiceImpl;
import com.cybertek.util.Status;

@Service
public class ProjectService implements ProjectServiceImpl {
	
	@Autowired
	UserServiceImpl userService;
	
	@Override
	public List<Project> getListOfProject() {
		return DataGenerator.getProjects();
	}

	@Override
	public List<Project> getListOfProject(String status) {
		// TODO Auto-generated method stub
		return DataGenerator.getProjects().stream().filter(x -> x.getProjectStatus().equals(status))
				.collect(Collectors.toList());
	}

	@Override
	public List<Project> getListOfProject(User manager) {
		// TODO Auto-generated method stub
		return DataGenerator.getProjects().stream().filter(x -> x.getAssignedManager() == manager).collect(Collectors.toList());
	}



	public ProjectDTO update(ProjectDTO project) {
		
		ProjectDTO obj = getListOfProjectDTO().stream().filter(x -> x.getProjectCode().equals(project.getProjectCode())).findFirst()
				.get();

		obj.setProjectDetail(project.getProjectDetail());
		obj.setStartDate(project.getStartDate());
		obj.setEndDate(project.getEndDate());
		obj.setAssignedManager(project.getAssignedManager());
		obj.setProjectName(project.getProjectName());

		obj.setProjectStatus(project.getProjectStatus() != null ? project.getProjectStatus() : obj.getProjectStatus());

		return obj;

	}

	@Override
	public Project getProjectByProjectCode(String projectcode) {
		return DataGenerator.getProjects().stream().filter(x -> x.getProjectCode().equals(projectcode)).findFirst().get();

	}

	@Override
	public List<ProjectDTO> getListOfProjectDTO() {
		List<ProjectDTO> list = getListOfProject().stream().map(x -> {

			return new ProjectDTO(x.getProjectCode(), x.getProjectName(),
					userService.getUserDTOByUsername(x.getAssignedManager().getUserName()), x.getStartDate(), x.getEndDate(),
					x.getProjectStatus(), x.getProjectDetail());

		}).collect(Collectors.toList());

		return list;
	}

	@Override
	public ProjectDTO getProjectDTOByProjectCode(String projectcode) {

		return getListOfProject().stream().filter(x -> x.getProjectCode().equals(projectcode)).map(x -> {

			return new ProjectDTO(x.getProjectCode(), x.getProjectName(),
					userService.getUserDTOByUsername(x.getAssignedManager().getUserName()), x.getStartDate(), x.getEndDate(),
					x.getProjectStatus(), x.getProjectDetail());

		}).findFirst().get();
	}


	@Override
	public List<ProjectDTO> updateProjects(ProjectDTO project) {

		List<ProjectDTO> projects = getListOfProjectDTO().stream()
				.filter(x -> x.getProjectCode().equals(project.getProjectCode()) == false).collect(Collectors.toList());

		ProjectDTO temp = getProjectDTOByProjectCode(project.getProjectCode());

		project.setProjectStatus(temp.getProjectStatus());
		projects.add(project);
		return projects;
	}

	@Override
	public List<ProjectDTO> deleteProjectDTO(String projectcode) {
		return getListOfProjectDTO().stream().filter(x -> x.getProjectCode().equals(projectcode) == false)
				.collect(Collectors.toList());
	}

	@Override
	public List<ProjectDTO> completeProject(String projectcode) {
		List<ProjectDTO> projects = getListOfProjectDTO().stream().filter(x -> x.getProjectCode().equals(projectcode) == false)
				.collect(Collectors.toList());

		ProjectDTO project = getProjectDTOByProjectCode(projectcode);
		project.setProjectStatus(Status.COMPLETED);

		projects.add(project);
		return projects;
	}

	/*
	@Override
	public List<ProjectDTO> completeProjectByManager(UserDTO manager, String projectcode) {

		List<ProjectDTO> list = getCountedListOfProjectDTO(manager).stream()
				.filter(x -> x.getProjectCode().equals(projectcode) == false).collect(Collectors.toList());

		ProjectDTO updateDTO = getCountedListOfProjectDTO(manager).stream()
				.filter(x -> x.getProjectCode().equals(projectcode) == true).findFirst().get();

		updateDTO.setProjectStatus(Status.COMPLETED);

		list.add(updateDTO);

		return list;
	}
	
	
	@Override
	public List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manager) {

		List<ProjectDTO> list = getListOfProject().stream()
				.filter(x -> x.getAssignedManager().getUserName().equals(manager.getUserName())).map(x -> {

					List<Task> taskList = taskService.getListOfTask(x);

					int completedCount = (int) taskList.stream().filter(t -> t.getStatus() == Status.COMPLETED).count();

					return new ProjectDTO(x.getProjectCode(), x.getProjectName(),
							userService.getUserDTOByUsername(x.getAssignedManager().getUserName()), completedCount,
							(taskList.size() - completedCount), x.getStartDate(), x.getEndDate(), x.getProjectStatus(),
							x.getProjectDetail());

				}).collect(Collectors.toList());

		return list;

	}
	*/
	
	
	
	@Override
	public List<Project> getListOfProject(User manager, String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Project insert(Project project) {
		// TODO Auto-generated method stub
		return project;
	}

	@Override
	public Project update(Project project) {
		// TODO Auto-generated method stub
		return project;
	}
	
	@Override
	public boolean delete(Project project) {
		// TODO Auto-generated method stub

		return false;
	}
	
	@Override
	public List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProjectDTO> completeProjectByManager(UserDTO manager, String projectcode) {
		// TODO Auto-generated method stub
		return null;
	}


	
	

}
