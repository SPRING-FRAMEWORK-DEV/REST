package com.spring.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.entity.User;
import com.spring.rest.service.UserService;
import com.spring.rest.uri.UserRestURIConstants;
//@PreAuthorize("hasRole('ROLE_USER')")
@RestController("userController")
public class RestUserController {
	private static final Logger logger = LoggerFactory
			.getLogger(RestUserController.class);

	@Autowired
	private UserService userService;

	// Map to store Clusters, ideally we should use database
	Map<Integer, User> userData = new HashMap<Integer, User>();

	// GET DUMMY USER - BY RABINDRA PATRA
	@RequestMapping(value = UserRestURIConstants.DUMMY_USER, method = RequestMethod.GET)
	public @ResponseBody
	User getDummyUser() {
		logger.info("Start getDummyUser");
		User user = new User("FName", "Lname", "Email", "Password", "Role");

		userData.put(9999, user);
		return user;
	}

	// GET USER BY ID - BY RABINDRA PATRA
	@RequestMapping(value = UserRestURIConstants.GET_USER, method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable("id") String id) {
		logger.info("Start getUser. ID=" + id);
		ResponseEntity<User> response = null;
		User user = userService.findUserById(id);
		response = new ResponseEntity<>(user, HttpStatus.OK);
		logger.info("returning user : " + id);
		return response;
	}

	// GET CLUSTER LIST - BY RABINDRA PATRA
	@RequestMapping(value = UserRestURIConstants.GET_ALL_USER, method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllClusters() {

		logger.info("Start getAllClusters.");
		ResponseEntity<List<User>> response = null;
		List<User> users = userService.getAllUsers();
		response = new ResponseEntity<>(users, HttpStatus.OK);
		logger.info("returning user list");
		return response;

	}

	// CREATE NEW CLUSTER - BY RABINDRA PATRA
	@RequestMapping(value = UserRestURIConstants.CREATE_USER, method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<User> createCluster(@RequestBody User user) {
		logger.info("Start createUser.");
		ResponseEntity<User> response = null;
		response = new ResponseEntity<>(userService.saveUser(user),
				HttpStatus.OK);
		return response;
	}

	// UPDATE AN EXISTING CLUSTER - BY RABINDRA PATRA
	@RequestMapping(value = UserRestURIConstants.UPDATE_USER, method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<User> updateCluster(
			@PathVariable("id") String userId, @RequestBody User user) {
		logger.info("Start updateUser.");
		ResponseEntity<User> response = null;
		user.setId(userId);
		response = new ResponseEntity<>(userService.updateCluster(user),
				HttpStatus.OK);
		logger.info("User updated.");
		return response;

	}

	// DELETE A CLUSTER BY ID - BY RABINDRA PATRA
	@RequestMapping(value = UserRestURIConstants.DELETE_USER, method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteCluster(
			@PathVariable("id") String userId) {
		logger.info("Start deleteUser.");

		ResponseEntity<String> response = null;
		userService.removeUserById(userId);
		response = new ResponseEntity<>(HttpStatus.OK);
		logger.info("User Deleted");
		return response;
	}
}
