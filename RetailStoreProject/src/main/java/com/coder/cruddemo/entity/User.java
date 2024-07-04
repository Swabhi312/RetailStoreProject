package com.coder.cruddemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "User")
public class User {
	@Id
	private long mobileNumber;
	private long id;
	private String userName;
	private String userType;
	private String userDuration;

	public User() {
		super();
	}

	public User(long mobileNumber, long id, String userName, String userType, String userDuration) {
		super();
		this.mobileNumber = mobileNumber;
		this.id = id;
		this.userName = userName;
		this.userType = userType;
		this.userDuration = userDuration;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserDuration() {
		return userDuration;
	}

	public void setUserDuration(String userDuration) {
		this.userDuration = userDuration;
	}

}
