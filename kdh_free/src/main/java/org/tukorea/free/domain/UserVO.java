package org.tukorea.free.domain;

import java.util.Date;


public class UserVO {

	private String id;
	
	private String passwd;


	private Date joinDate;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	public Date getJoinDate() {
		return joinDate;
	}


	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}


	@Override
	public String toString() {
		return "UserVO [id=" + id + ", passwd=" + passwd + ", joinDate=" + joinDate + "]";
	}


	public UserVO(String id, String passwd, Date joinDate) {
		this.id = id;
		this.passwd = passwd;
		this.joinDate = joinDate;
	}
	
	public UserVO() {
		
	}
}
