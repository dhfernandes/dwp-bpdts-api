package org.dwp.bpdts.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.dwp.bpdts.model.User;
import org.dwp.bpdts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for users
 */
@RestController
@RequestMapping("/api/v1")
public class UserController {

	private static Logger log = Logger.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	/**
	 * Get users in London or within a 50 mile radius
	 * @return list of users
	 */
	@GetMapping(value = "/users")
	public List<User> getUsers() {
		List<User> users = userService.getUsers();
		log.info("User count:" + users.size());
		return users;
	}
	
}
