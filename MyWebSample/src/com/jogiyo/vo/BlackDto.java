package com.jogiyo.vo;

public class BlackDto {
	String userid;

	public BlackDto(String userid) {
		super();
		this.userid = userid;
	}

	public BlackDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BlackDto [userid=" + userid + "]";
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
}
