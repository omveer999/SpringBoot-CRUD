package com.example.usermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.usermanagement.exception.UserNotFoundException;
import com.example.usermanagement.exception.UserUnProcessabilityException;
import com.example.usermanagement.model.User;
import com.example.usermanagement.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController{
	@Autowired
	UserService userService;
	
	@GetMapping("/{id}") 
	public User getUser(@PathVariable long id)throws UserNotFoundException {
			return userService.getUserById(id);
	}
	
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws UserUnProcessabilityException{
		return userService.createUser(user);
	}
	
	@PatchMapping("/{id}")
	public User updateUser(@PathVariable long id,@RequestBody User user)throws UserUnProcessabilityException,UserNotFoundException{
		return userService.updateUser(id,user);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable long id) {
		userService.deleteUser(id);
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		
	}
}
