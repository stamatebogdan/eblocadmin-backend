package com.eblocadmin.backend.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eblocadmin.backend.users.entity.User;
import com.eblocadmin.backend.users.entity.UserType;
import com.eblocadmin.backend.users.repository.UsersRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UsersService {

	private UsersRepository usersRepository;

	public UsersService(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	// Retrieve all users data from eba_user_profile table
	public List<User> retrieveAllUsers() {
		return usersRepository.retrieveAllUsers();
	}

	// Retrieve specific data from eba_user_profile table
	public List<User> retrieveSpecificUserByEbaId(User user) {
		return usersRepository.retrieveSpecificUserByEbaId(user);
	}

	// Insert all users in eba_user_profile table
	public void insertUser(User user) {
		usersRepository.insertUser(user);
	}

	// Delete a user row from eba_user_profile
	public void deleteSpecificUserByEbaId(User user) {
		usersRepository.deleteSpecificUserByEbaId(user);
	}

	// Retrieve all data from eba_user_type table
	public List<UserType> retrieveAllUserTypes() {
		return usersRepository.retrieveAllUserTypes();
	}

	// Retrieve specific data from eba_user_type table
	public List<UserType> retrieveSpecificUserTypeByEbaId(UserType userType) {
			return usersRepository.retrieveSpecificUserTypeByEbaId(userType);
	}

	// Insert all user type in eba_user_profile table
	public void insertUserType(UserType userType) {
		usersRepository.insertUserType(userType);
	}

	// Delete a userType row from eba_user_type
	public void deleteSpecificUserTypeByEbaId(UserType userType) {
		usersRepository.deleteSpecificUserTypeByEbaId(userType);
	}

}
