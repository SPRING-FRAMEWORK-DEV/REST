package com.spring.main;
import java.io.IOException;

import com.spring.model.UserModel;
import com.spring.utils.ValidateUser;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ValidateUser v = new ValidateUser();
		v.validateUserModel(new UserModel("xyz", "asdf"));

	}

}
