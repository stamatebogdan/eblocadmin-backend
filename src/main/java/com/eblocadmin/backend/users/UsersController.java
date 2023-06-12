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

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping(value="/api/users")
public class UsersController {
	
	private UsersService usersService;
	
	public UsersController(UsersService usersService) {
		this.usersService = usersService;
	}
	
	@GetMapping(value="/all")
	public List<User> getUsers() {		
            return usersService.getSomeUsers();    
    }
	
	@PostMapping(value="/insert")
	public void insertUser(@RequestBody User user) {
		System.out.println("USer from POST: " + user);
		usersService.insertUser(user);				
	}
}
