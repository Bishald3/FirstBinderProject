package com.binder.app.entity;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class User {

	@Id
    @GeneratedValue
    @Column(name="Id")
	private long Id;
	
	@Column(name="fName",nullable=false,length=50)
    String fName;
	
	@Column(name="lName",nullable=false,length=50)
    String lName;
	
	@Column(name="password",nullable=false,length=50)
    String passwor;
	
	@Column(name="userName",nullable=false,length=50)
    String userName;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getPasswor() {
		return passwor;
	}

	public void setPasswor(String passwor) {
		this.passwor = passwor;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
