package com.example.usermanagement.service;


import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.usermanagement.exception.InvalidRequestException;
import com.example.usermanagement.exception.UserNotFoundException;
import com.example.usermanagement.exception.UserUnProcessabilityException;
import com.example.usermanagement.model.User;
import com.example.usermanagement.repositary.UserDao;

@Service
public class UserService {
	private static final Logger logger=LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	UserDao userDao;
	
	public User getUserById(long id) throws UserNotFoundException{
		try {
			User user=userDao.findById(id).get();
			if(user==null)
				throw new UserNotFoundException("Unable to get user by id");
			else
				return user;
		}
		catch(Exception ex) {
			logger.error("Error occured : {}",ex.getMessage());
			throw new UserNotFoundException("Unable to get user by id");
		}
	}

	public User createUser(User user) {
		try {
			logger.info("In @createUser service : {} name:{}",user.toString(),user.getName());
			return userDao.save(user);
		}catch(Exception ex) {
			logger.error("Error occured : {}",ex.getMessage());
			throw new UserUnProcessabilityException(ex.getMessage());
		}
	}

	public User updateUser(long id, User user) {
		logger.info("In @updateUser service id:{} and payload: {}",id,user.toString());
		try {
			User oldUser=userDao.findById(id).get();
			logger.info("oldUser: {}",oldUser);
			if(oldUser!=null) {
				User updateUser=new User();
				
				if(user.getName()!=null)
				oldUser.setName(user.getName());
				
				if(user.getEmail()!=null)
				oldUser.setEmail(user.getName());
				
				if(user.getPassword()!=null)
				oldUser.setPassword(user.getName());
				
				if(user.getUsername()!=null)
				oldUser.setUsername(user.getUsername());
				
				logger.info("updateUser : {}",oldUser.toString());
				return userDao.save(oldUser);
			}
			else {
				throw new UserNotFoundException("Unable to found user by given id : "+id);
			}
		}catch(Exception ex) {
			logger.error("error occured : {}",ex.getMessage());
			throw new UserUnProcessabilityException(ex.getMessage());
		}
	
	}
	
	
	public void deleteUser(long id) {
		logger.info("In @deleteUser service id:{}",id);
		try {
			User user=userDao.findById(id).get();
			if(user!=null) {
				userDao.deleteById(id);
				logger.info("User Deleted Successfully by id : {}",id);
			}else {
				throw new UserNotFoundException("Unable to found user by given id : "+id);
			}
		}catch(Exception ex) {
			throw new UserUnProcessabilityException(ex.getMessage());
		}
	}

}
