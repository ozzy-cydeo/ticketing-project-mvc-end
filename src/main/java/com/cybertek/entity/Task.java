package com.cybertek.entity;

import java.time.LocalDateTime;

import com.cybertek.util.Status;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Task extends BaseEntity {
	
	private String taskSubject;
	private String taskDetail;
	private User assignedEmployee;
	private Project assignedProject;
	private User assignedManager;
	private LocalDateTime startDateTime;
	private LocalDateTime endDateTime;
	private Status taskStatus;
/*
	public Task(long id, LocalDateTime insertDateTime, long insertUserId, LocalDateTime lastUpdateDateTime,
			long lastUpdateUserId, String taskSubject, String taskDetail, User assignedEmployee, Project assignedProject, User assignedManager) {
		super(id, insertDateTime, insertUserId, lastUpdateDateTime, lastUpdateUserId);
		this.taskSubject = taskSubject;
		this.taskDetail = taskDetail;
		this.assignedEmployee = assignedEmployee;
		this.assignedProject = assignedProject;
		this.assignedManager = assignedManager;
		this.startDateTime = LocalDateTime.now();
		this.endDateTime = null;
		this.taskStatus = Status.OPEN;
	}
*/

	
	public Task(long id, LocalDateTime insertDateTime, long insertUserId, LocalDateTime lastUpdateDateTime,
			long lastUpdateUserId, String taskSubject, String taskDetail, User assignedEmployee, Project assignedProject, User assignedManager,LocalDateTime startDateTime,LocalDateTime endDateTime,Status taskStatus) {
		super(id, insertDateTime, insertUserId, lastUpdateDateTime, lastUpdateUserId);
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
