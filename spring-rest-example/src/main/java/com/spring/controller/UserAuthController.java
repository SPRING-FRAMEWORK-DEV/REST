package com.spring.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.model.UserModel;
import com.spring.service.UserAuthService;

@Controller("userAuthController")
public class UserAuthController {

	@Autowired
	private UserAuthService service;

	@RequestMapping(value = "user/dummy", method = RequestMethod.GET)
	public @ResponseBody UserModel getDummyUser() {
		UserModel model = new UserModel("helloUser", "abcdefPass");

		return model;
	}

	@RequestMapping(value = "user/validate", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> validateUserCredentials(@RequestBody UserModel model) throws IOException {
		/*
		 * logger.info("Start createUser."); ResponseEntity<User> response =
		 * null; response = new ResponseEntity<>(userService.saveUser(user),
		 * HttpStatus.OK); return response;
		 */
		ResponseEntity<String> response = null;
		String serviceMessage = service.validateUser(model);
		response = new ResponseEntity<String>(serviceMessage, HttpStatus.OK);

		return response;
	}

}
