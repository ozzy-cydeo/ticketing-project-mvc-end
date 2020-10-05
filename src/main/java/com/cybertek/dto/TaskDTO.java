package com.cybertek.dto;

import java.time.LocalDateTime;

import com.cybertek.util.Status;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

	public TaskDTO() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTaskSubject() {
		return taskSubject;
	}

	public void setTaskSubject(String taskSubject) {
		this.taskSubject = taskSubject;
	}

	public String getTaskDetail() {
		return taskDetail;
	}

	public void setTaskDetail(String taskDetail) {
		this.taskDetail = taskDetail;
	}

	public UserDTO getAssignedEmployee() {
		return assignedEmployee;
	}

	public void setAssignedEmployee(UserDTO assignedEmployee) {
		this.assignedEmployee = assignedEmployee;
	}

	public ProjectDTO getAssignedProject() {
		return assignedProject;
	}

	public void setAssignedProject(ProjectDTO assignedProject) {
		this.assignedProject = assignedProject;
	}

	public UserDTO getAssignedManager() {
		return assignedManager;
	}

	public void setAssignedManager(UserDTO assignedManager) {
		this.assignedManager = assignedManager;
	}

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}

	public LocalDateTime getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(LocalDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}

	public Status getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(Status taskStatus) {
		this.taskStatus = taskStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assignedEmployee == null) ? 0 : assignedEmployee.hashCode());
		result = prime * result + ((assignedManager == null) ? 0 : assignedManager.hashCode());
		result = prime * result + ((assignedProject == null) ? 0 : assignedProject.hashCode());
		result = prime * result + ((endDateTime == null) ? 0 : endDateTime.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((startDateTime == null) ? 0 : startDateTime.hashCode());
		result = prime * result + ((taskDetail == null) ? 0 : taskDetail.hashCode());
		result = prime * result + ((taskStatus == null) ? 0 : taskStatus.hashCode());
		result = prime * result + ((taskSubject == null) ? 0 : taskSubject.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaskDTO other = (TaskDTO) obj;
		if (assignedEmployee == null) {
			if (other.assignedEmployee != null)
				return false;
		} else if (!assignedEmployee.equals(other.assignedEmployee))
			return false;
		if (assignedManager == null) {
			if (other.assignedManager != null)
				return false;
		} else if (!assignedManager.equals(other.assignedManager))
			return false;
		if (assignedProject == null) {
			if (other.assignedProject != null)
				return false;
		} else if (!assignedProject.equals(other.assignedProject))
			return false;
		if (endDateTime == null) {
			if (other.endDateTime != null)
				return false;
		} else if (!endDateTime.equals(other.endDateTime))
			return false;
		if (id != other.id)
			return false;
		if (startDateTime == null) {
			if (other.startDateTime != null)
				return false;
		} else if (!startDateTime.equals(other.startDateTime))
			return false;
		if (taskDetail == null) {
			if (other.taskDetail != null)
				return false;
		} else if (!taskDetail.equals(other.taskDetail))
			return false;
		if (taskStatus != other.taskStatus)
			return false;
		if (taskSubject == null) {
			if (other.taskSubject != null)
				return false;
		} else if (!taskSubject.equals(other.taskSubject))
			return false;
		return true;
	}
	
	
	

}
