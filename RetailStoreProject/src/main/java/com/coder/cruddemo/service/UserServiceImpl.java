package com.coder.cruddemo.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coder.cruddemo.entity.User;
import com.coder.cruddemo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User addUser(User user) {
        return userRepository.save(user);	
	}

	@Override
	public User findUserById(Long userIdL) {
		 Optional<User> user =  userRepository.findById(userIdL);
	        if(user.isPresent()){
	            return user.get();
	        }else {
	        	return null;
	        }
	}

}
