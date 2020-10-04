package com.cybertek.dto;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import com.cybertek.util.Status;
import lombok.*;


public class ProjectDTO {
	
	private String projectCode;
	private String projectName;
	private UserDTO assignedManager;
	private int completedTasksCount;
	private int unFinishedTasksCount;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate startDate;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate endDate;

	private Status projectStatus;
	private String projectDetail;
	
	public ProjectDTO() {
		
	}
	
	public ProjectDTO(String projectCode, String projectName, UserDTO assignedManager, LocalDate startDate,
			LocalDate endDate, Status projectStatus, String projectDetail) {
		super();
		this.projectCode = projectCode;
		this.projectName = projectName;
		this.assignedManager = assignedManager;
		this.startDate = startDate;
		this.endDate = endDate;
		this.projectStatus = projectStatus;
		this.projectDetail = projectDetail;
	}



	public ProjectDTO(String projectCode, String projectName, UserDTO assignedManager, int completedTasksCount,
			int unFinishedTasksCount, LocalDate startDate, LocalDate endDate, Status projectStatus,
			String projectDetail) {
		super();
		this.projectCode = projectCode;
		this.projectName = projectName;
		this.assignedManager = assignedManager;
		this.completedTasksCount = completedTasksCount;
		this.unFinishedTasksCount = unFinishedTasksCount;
		this.startDate = startDate;
		this.endDate = endDate;
		this.projectStatus = projectStatus;
		this.projectDetail = projectDetail;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public UserDTO getAssignedManager() {
		return assignedManager;
	}

	public void setAssignedManager(UserDTO assignedManager) {
		this.assignedManager = assignedManager;
	}

	public int getCompletedTasksCount() {
		return completedTasksCount;
	}

	public void setCompletedTasksCount(int completedTasksCount) {
		this.completedTasksCount = completedTasksCount;
	}

	public int getUnFinishedTasksCount() {
		return unFinishedTasksCount;
	}

	public void setUnFinishedTasksCount(int unFinishedTasksCount) {
		this.unFinishedTasksCount = unFinishedTasksCount;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Status getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(Status projectStatus) {
		this.projectStatus = projectStatus;
	}

	public String getProjectDetail() {
		return projectDetail;
	}

	public void setProjectDetail(String projectDetail) {
		this.projectDetail = projectDetail;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assignedManager == null) ? 0 : assignedManager.hashCode());
		result = prime * result + completedTasksCount;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((projectCode == null) ? 0 : projectCode.hashCode());
		result = prime * result + ((projectDetail == null) ? 0 : projectDetail.hashCode());
		result = prime * result + ((projectName == null) ? 0 : projectName.hashCode());
		result = prime * result + ((projectStatus == null) ? 0 : projectStatus.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + unFinishedTasksCount;
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
		ProjectDTO other = (ProjectDTO) obj;
		if (assignedManager == null) {
			if (other.assignedManager != null)
				return false;
		} else if (!assignedManager.equals(other.assignedManager))
			return false;
		if (completedTasksCount != other.completedTasksCount)
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (projectCode == null) {
			if (other.projectCode != null)
				return false;
		} else if (!projectCode.equals(other.projectCode))
			return false;
		if (projectDetail == null) {
			if (other.projectDetail != null)
				return false;
		} else if (!projectDetail.equals(other.projectDetail))
			return false;
		if (projectName == null) {
			if (other.projectName != null)
				return false;
		} else if (!projectName.equals(other.projectName))
			return false;
		if (projectStatus != other.projectStatus)
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (unFinishedTasksCount != other.unFinishedTasksCount)
			return false;
		return true;
	}

	



	
	


}


