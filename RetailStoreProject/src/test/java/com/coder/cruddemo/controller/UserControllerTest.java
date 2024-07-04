package com.coder.cruddemo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.coder.cruddemo.entity.User;
import com.coder.cruddemo.service.UserService;

 class UserControllerTest {

	@InjectMocks
	UserController userController;

	@Mock
	UserService userService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testAddUser() {
		User mockUser = new User(9834167191L, 1L, "Swati", "Employee", "2");
		when(userService.addUser(mockUser)).thenReturn(mockUser);
		ResponseEntity<User> response = userController.addUser(mockUser);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertEquals(mockUser, response.getBody());
		verify(userService, times(1)).addUser(mockUser);
	}

	@Test
	public void testFetchUserDetails() {
		long mockUserId = 9834167191L;
		User mockUser = new User(9834167191L, 1L, "Swati", "Employee", "2");
		when(userService.findUserById(mockUserId)).thenReturn(mockUser);
		ResponseEntity<User> response = userController.fetchUserDetails(mockUserId);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(mockUser, response.getBody());
		verify(userService, times(1)).findUserById(mockUserId);
	}

}
