package com.guochenglong.bean;

import java.io.Serializable;

public class City implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int cityid;
	private int pid;
	private String cityname;
	private int type;
	public int getCityid() {
		return cityid;
	}
	public void setCityid(int cityid) {
		this.cityid = cityid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "City [cityid=" + cityid + ", pid=" + pid + ", cityname=" + cityname + ", type=" + type + "]";
	}
	public City(int cityid, int pid, String cityname, int type) {
		super();
		this.cityid = cityid;
		this.pid = pid;
		this.cityname = cityname;
		this.type = type;
	}
	public City() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
