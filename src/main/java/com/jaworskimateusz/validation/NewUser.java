package com.jaworskimateusz.validation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@FieldConfirm.List({
	@FieldConfirm(password="password", confirmedPassword="confirmedPassword", message="Passwords must match." )})
public class NewUser {
	
	@NotNull(message="Name is required.")
	@Size(max=50, message="Name must contain less than 50 characters.")
	private String name;
	
	@VerifyEmail
	@Size(max=50, message="Email must contain less than 50 characters.")
	private String email;
	
	@NotNull(message="Password is required.")
	@Size(min=6, message="Password must contain minimum 6 characters.")
	@Size(max=80, message="Name must contain less than 80 characters.")
	private String password;
	
	private String confirmedPassword;
	
	public NewUser() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getConfirmedPassword() {
		return confirmedPassword;
	}

	public void setConfirmedPassword(String confirmedPassword) {
		this.confirmedPassword = confirmedPassword;
	}

	@Override
	public String toString() {
		return "NewUser [name=" + name + ", email=" + email + ", password= ***** " + ", confirmedPassword= ***** ]";
	}

}
