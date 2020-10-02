
package com.cybertek.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybertek.data.DataGenerator;
import com.cybertek.dto.UserDTO;
import com.cybertek.entity.User;
import com.cybertek.implementation.UserServiceImpl;
import com.cybertek.implementation.RoleServiceImpl;

@Service
public class UserService implements UserServiceImpl {

	private RoleServiceImpl roleService;

	@Autowired
	public UserService(RoleServiceImpl roleService) {
		this.roleService = roleService;
	}

	@Override
	public User userByUserName(String userName) {
		return DataGenerator.getUsers().stream().filter(x -> x.getUserName().equals(userName)).findFirst().get();
	}

	@Override
	public List<User> listOfUsers() {
		return DataGenerator.getUsers();
	}


	@Override
	public String userByUserId(Long id) {
		User user = DataGenerator.getUsers().stream().filter(x -> x.getId() == id).findFirst().get();
		return user.getFirstName() + " " + user.getLastName();
	}

	@Override
	public List<UserDTO> listOfUserDTO() {
		return listOfUsers().stream().map(x -> {
			return new UserDTO(x.getFirstName(), x.getLastName(), x.getUserName(), x.getPassWord(), x.isEnabled(),
					x.getPhone(), roleService.getRoleDTOById(x.getRole().getId()), x.getGender());
		}).collect(Collectors.toList());
	}

	@Override
	public UserDTO getUserDTOByUsername(String username) {
		User user= userByUserName(username);
		return DataGenerator.getUserDTOByUser(user);
	}
	
	@Override
	public List<UserDTO> updateUsers(UserDTO user) {

		List<UserDTO> list = listOfUserDTO().stream().filter(x -> x.getUserName().equals(user.getUserName()) == false)
				.collect(Collectors.toList());
		
		list.add(user);

		return list;
	}

	@Override
	public List<UserDTO> deleteUser(String username) {

		return listOfUserDTO().stream().filter(x -> x.getUserName().equals(username) == false)
				.collect(Collectors.toList());
	}

	@Override
	public List<User> listOfUsersByRole(String Role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public User insertUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDTO> getManagers() {
		// TODO Auto-generated method stub
		return null;
	}

}
