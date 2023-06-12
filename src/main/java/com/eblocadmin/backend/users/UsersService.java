package com.eblocadmin.backend.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eblocadmin.backend.users.entity.User;
import com.eblocadmin.backend.users.repository.UsersRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UsersService {
	
	private UsersRepository usersRepository;
	
	public UsersService(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}
	
	public List<User> getSomeUsers(){
		return usersRepository.getAnything();		
	}
	
	public void insertUser(User user){
		usersRepository.insertUser(user);
	}
}
