package com.cybertek.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class BaseEntity {
	
	private long id;
	private LocalDateTime insertDateTime;
	private long insertUserId;
	private LocalDateTime lastUpdateDateTime;
	private long lastUpdateUserId;


}




