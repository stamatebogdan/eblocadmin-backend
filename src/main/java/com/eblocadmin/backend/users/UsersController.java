	package com.eblocadmin.backend.users;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eblocadmin.backend.users.entity.User;
import com.eblocadmin.backend.users.entity.UserType;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping(value="/api/users")
public class UsersController {
	
	private UsersService usersService;
	
	public UsersController(UsersService usersService) {
		this.usersService = usersService;
	}
	
	@GetMapping(value="/retrieveAllUsers")
	public List<User> retrieveAllUsers() {		
            return usersService.retrieveAllUsers();    
    }
	
	@GetMapping(value="/retrieveSpecificUserByEbaId")
	public List<User> retrieveSpecificUserByEbaId(User user) {		
            return usersService.retrieveSpecificUserByEbaId(user);    
    }
	
	@PostMapping(value="/insertUser")
	public void insertUser(@RequestBody User user) {
		usersService.insertUser(user);				
	}
	
	@PostMapping(value="/deleteSpecificUserByEbaId")
	public void deleteSpecificUserByEbaId(User user) {
		usersService.deleteSpecificUserByEbaId(user);
	}
	
	@GetMapping(value="/retrieveAllUserTypes")
	public List<UserType> retrieveAllUserTypes() {		
            return usersService.retrieveAllUserTypes();    
    }
	
	@GetMapping(value="/retrieveSpecificUserTypeByEbaId")
	public List<UserType> retrieveSpecificUserTypeByEbaId(UserType userType) {		
            return usersService.retrieveSpecificUserTypeByEbaId(userType);    
    }
	
	@PostMapping(value="/insertUserType")
	public void insertUserType(@RequestBody UserType userType) {
		usersService.insertUserType(userType);				
	}
	
	@PostMapping(value="/deleteSpecificUserTypeByEbaId")
	public void deleteSpecificUserTypeByEbaId(UserType userType) {
		usersService.deleteSpecificUserTypeByEbaId(userType);
	}
	
}
