package com.spring.rest.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.rest.entity.User;
import com.spring.rest.exceptions.DuplicateEmailException;
import com.spring.rest.exceptions.UserNotFoundException;

@Repository("userDao")
public class UserDao {
	public User insertUser(User user) {
		User userSaved = null;

		return null;
	}

	public User getUserByEmailId(String emailId) {
		return null;
	}

	public User updateUser(User user) {
		return null;
	}

	public List<User> selectAllUser() {

		return null;

	}

	public void deleteUserById(String userId) {

	}

	public User getUserById(String userId) {
		return null;
	}
}
