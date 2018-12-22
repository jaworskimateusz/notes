package com.jaworskimateusz.validation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NewUser {
	
	@NotNull(message="required")
	@Size(min=1, message="required")
	private String name;
	
	//here create custom validEmail annotation
	@NotNull(message="required")
	@Size(min=1, message="required")
	private String email;
	
	@NotNull(message="required")
	@Size(min=1, message="required")
	private String password;
	
	@NotNull(message="required")
	@Size(min=1, message="required")
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
