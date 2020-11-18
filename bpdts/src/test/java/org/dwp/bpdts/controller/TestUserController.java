package org.dwp.bpdts.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.dwp.bpdts.model.User;
import org.dwp.bpdts.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class TestUserController {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	UserService userService;

	@Test
	@DisplayName (value = "Get users for specified city and radius")
	public void TestGetUsers() throws Exception {
		List<User> users = Stream.of(
				new User(135, "Mechelle", "Boam", "mboam3q@thetimes.co.uk", "113.71.242.187", -6.5115909, 105.652983), 
				new User(396, "Terry", "Stowgill", "tstowgillaz@webeden.co.uk", "143.190.50.240", -6.7098551, 111.3479498))
			    .collect(Collectors.toList());
	    given(userService.getUsers()).willReturn(users);
		mvc.perform(get("/api/v1/users"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", hasSize(2)));
	}
	
	@Test
	@DisplayName (value = "Test invalid URL")
	public void TestGetUsersInvalid() throws Exception {
		List<User> users = Stream.of(
				new User(135, "Mechelle", "Boam", "mboam3q@thetimes.co.uk", "113.71.242.187", -6.5115909, 105.652983), 
				new User(396, "Terry", "Stowgill", "tstowgillaz@webeden.co.uk", "143.190.50.240", -6.7098551, 111.3479498))
			    .collect(Collectors.toList());
	    given(userService.getUsers()).willReturn(users);
		mvc.perform(get("/api/v1/u"))
			.andExpect(status().isNotFound());
	}

}
