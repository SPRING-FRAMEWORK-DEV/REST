package com.spring.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rest.dao.UserDao;
import com.spring.rest.entity.User;
import com.spring.rest.exceptions.DuplicateEmailException;
import com.spring.rest.exceptions.UserNotFoundException;

@Service("userService")
public class UserService {

	@Autowired
	private UserDao userDao;

	public User saveUser(User user) {
		User userSaved = null;

		findUserByEmailId(user.getEmail());

		userSaved = userDao.insertUser(user);

		return userSaved;
	}

	public void findUserByEmailId(String emailId) {
		User user = userDao.getUserByEmailId(emailId);
		if (user != null) {
			throw new DuplicateEmailException(emailId);
		}

	}

	public User updateCluster(User user) {
		findUserById(user.getId());
		return userDao.updateUser(user);
	}

	public List<User> getAllUsers() {

		return userDao.selectAllUser();

	}

	public void removeUserById(String userId) {
		findUserById(userId);
		userDao.deleteUserById(userId);
	}

	public User findUserById(String userId) {
		User user = null;

		user = userDao.getUserById(userId);

		if (user == null)
			throw new UserNotFoundException(userId);

		return user;
	}
}
