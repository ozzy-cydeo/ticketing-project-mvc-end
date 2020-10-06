package com.cybertek.dto;

import com.cybertek.util.Gender;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.cybertek.dto.*;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class UserDTO {

	private String firstName;
	private String lastName;
	private String userName;
	private String passWord;
	private boolean enabled;
	private String phone;
	private RoleDTO role;
	private Gender gender;


}
