package org.dwp.bpdts.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.dwp.bpdts.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestUserService {

	@Autowired
	UserService userService;
	
	@Test
	@DisplayName (value = "Get users in specified city or within specified radius")
	void testGetUsers() {
		final int expected = 9;
		final int actual = userService.getUsers().size();
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName (value = "Get all users")
	void testGetAllUsers() {
		final int expected = 1000;
		final int actual = userService.getAllUsers().size();
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName (value = "Get users in specified city")
	void testGetLondonUsers() {
		final int expected = 6;
		final int actual = userService.getUsersByCity().size();
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName (value = "Get users in specified city radius")
	void testGetLondonRadiusUsers() {
		List<User> allUsers = userService.getAllUsers();
		final int expected = 3;
		final int actual = userService.getUsersByCityRadius(allUsers).size();
		assertEquals(expected, actual);
	}
}
