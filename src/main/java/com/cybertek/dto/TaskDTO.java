package com.cybertek.dto;

import java.time.LocalDateTime;

import com.cybertek.util.Status;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
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

}


