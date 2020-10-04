package com.cybertek.dto;

import java.time.LocalDateTime;

import com.cybertek.util.Status;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class TaskDTO {
	
	private long id;
	private String taskSubject;
	private String taskDetail;
	private UserDTO assignedEmployee;
	private ProjectDTO assignedProject;
	private UserDTO assignedManager;
	private LocalDateTime startDateTime;
	private LocalDateTime endDateTime;
	private Status taskStatus;
	
	public TaskDTO(long id, String taskSubject, String taskDetail, UserDTO assignedEmployee, ProjectDTO assignedProject,
			UserDTO assignedManager, LocalDateTime startDateTime, LocalDateTime endDateTime, Status taskStatus) {
		super();
		this.id = id;
		this.taskSubject = taskSubject;
		this.taskDetail = taskDetail;
		this.assignedEmployee = assignedEmployee;
		this.assignedProject = assignedProject;
		this.assignedManager = assignedManager;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.taskStatus = taskStatus;
	}
	
	

}
