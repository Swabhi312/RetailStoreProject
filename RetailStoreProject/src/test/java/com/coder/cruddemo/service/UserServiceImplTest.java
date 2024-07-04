package com.coder.cruddemo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.coder.cruddemo.entity.User;
import com.coder.cruddemo.repository.UserRepository;

public class UserServiceImplTest {

	@Mock
	UserRepository userRepository;

	@InjectMocks
	UserServiceImpl userServiceImpl;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testAddUser() {
		User mockUser = new User(9834167191L, 1L, "Swati", "Employee", "2");
		when(userRepository.save(mockUser)).thenReturn(mockUser);
		User userAdded = userServiceImpl.addUser(mockUser);
		assertEquals(mockUser, userAdded);
		verify(userRepository, times(1)).save(mockUser);
	}

	@Test
	public void testFindUserById() {

		long mockUserId = 9834167191L;
		User mockUser = new User(9834167191L, 1L, "Swati", "Employee", "2");

		when(userRepository.findById(mockUserId)).thenReturn(Optional.of(mockUser));
		User user = userServiceImpl.findUserById(mockUserId);

		assertEquals(mockUserId, user.getId());
		verify(userRepository, times(1)).findById(mockUserId);
	}

}
