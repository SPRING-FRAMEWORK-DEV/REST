package com.spring.rest.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -631611274910672660L;
	
	private String id;
	//@Size(min = 3, max = 30)
	private String firstName;

	//@Size(min = 3, max = 30)
	private String lastName;

	//@Email
	//@NotEmpty
	private String email;
	
	//@NotEmpty
	private String password;
	
	//@NotEmpty
	private String role;
	private String userId;
	private boolean isVerified;

	private String session_token;
	private String e_reg_verif_token;
	private boolean e_reg_verif_token_verified;

	private Date st_exp_date;
	private Date e_reg_verif_token_exp_date;

	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String firstName, String lastName, String email,
			String password, String role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean isVerified() {
		return isVerified;
	}

	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

	public String getSession_token() {
		return session_token;
	}

	public void setSession_token(String session_token) {
		this.session_token = session_token;
	}

	public String getE_reg_verif_token() {
		return e_reg_verif_token;
	}

	public void setE_reg_verif_token(String e_reg_verif_token) {
		this.e_reg_verif_token = e_reg_verif_token;
	}

	public boolean isE_reg_verif_token_verified() {
		return e_reg_verif_token_verified;
	}

	public void setE_reg_verif_token_verified(boolean e_reg_verif_token_verified) {
		this.e_reg_verif_token_verified = e_reg_verif_token_verified;
	}

	public Date getSt_exp_date() {
		return st_exp_date;
	}

	public void setSt_exp_date(Date st_exp_date) {
		this.st_exp_date = st_exp_date;
	}

	public Date getE_reg_verif_token_exp_date() {
		return e_reg_verif_token_exp_date;
	}

	public void setE_reg_verif_token_exp_date(Date e_reg_verif_token_exp_date) {
		this.e_reg_verif_token_exp_date = e_reg_verif_token_exp_date;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", password=" + password
				+ ", role=" + role + ", userId=" + userId + ", isVerified="
				+ isVerified + ", session_token=" + session_token
				+ ", e_reg_verif_token=" + e_reg_verif_token
				+ ", e_reg_verif_token_verified=" + e_reg_verif_token_verified
				+ ", st_exp_date=" + st_exp_date
				+ ", e_reg_verif_token_exp_date=" + e_reg_verif_token_exp_date
				+ "]";
	}
	
	

}
