package com.binder.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class UserInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	@Column(name="fName",nullable=false,length=50)
    String fName;
	
	@Column(name="lName",nullable=false,length=50)
    String lName;
	
	@Column(name="password",nullable=false,length=50)
    String password;
	
	@Column(name="userName",nullable=false,length=50)
    String userName;
	
	public UserInfo(){
		super();
	}

	public long getId() {
		return Id;
	}

	public void setId(int id) {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
