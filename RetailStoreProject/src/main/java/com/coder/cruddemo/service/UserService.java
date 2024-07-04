package com.coder.cruddemo.service;

import com.coder.cruddemo.entity.User;

public interface UserService {

	public User addUser(User user) ;

	public User findUserById(Long userIdL);
}
