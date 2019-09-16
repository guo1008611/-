package com.guochenglong.bean;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.Length;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	//规定姓名长度为5
	@Length(min=5)
	private String username;
	
	private String hobby;
	//stitd位置 站点 产所  birthplace出生地
	private String site;
	
	//出生日期
	private Date birthdate;
	
	//密码
	private String password;
	
	private String sex;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", hobby=" + hobby + ", site=" + site + ", birthdate="
				+ birthdate + ", password=" + password + ", sex=" + sex + "]";
	}

	public User(int id, String username, String hobby, String site, Date birthdate, String password, String sex) {
		super();
		this.id = id;
		this.username = username;
		this.hobby = hobby;
		this.site = site;
		this.birthdate = birthdate;
		this.password = password;
		this.sex = sex;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	
}
