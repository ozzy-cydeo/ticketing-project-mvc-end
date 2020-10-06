package com.cybertek.dto;

import java.time.LocalDateTime;

import com.cybertek.util.Status;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class TaskDTO {
	
	private long id;
	private String title;
	private String content;
	private UserDTO user;
	private ProjectDTO project;
	private UserDTO manager;
	private LocalDateTime startDateTime;
	private LocalDateTime endDateTime;
	private Status status;

/*
	public TaskDTO(long id, String title, String content, UserDTO user, ProjectDTO project, UserDTO manager) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.user = user;
		this.project = project;
		this.manager = manager;
		this.startDateTime = LocalDateTime.now();
		this.endDateTime = null;
		this.status = Status.OPEN;
	}
*/
	
}
