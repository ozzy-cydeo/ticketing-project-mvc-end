package com.cybertek.dto;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import com.cybertek.util.Status;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class ProjectDTO {
	
	private String projectCode;
	private String projectName;
	private UserDTO manager;
	private int completedTasksCount;
	private int unFinishedTasksCount;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate startDate;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate endDate;

	private Status projectStatus;
	private String projectDetail;

	
	public ProjectDTO(String projectCode, String projectName, UserDTO manager, LocalDate startDate,
			LocalDate endDate, Status projectStatus, String projectDetail) {
		super();
		this.projectCode = projectCode;
		this.projectName = projectName;
		this.manager = manager;
		this.startDate = startDate;
		this.endDate = endDate;
		this.projectStatus = projectStatus;
		this.projectDetail = projectDetail;
	}



}


