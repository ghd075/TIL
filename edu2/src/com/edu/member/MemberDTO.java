package com.edu.member;

public class MemberDTO {
	String userid;
	String userpw;
	String username;
	String job;
	String hobby;
	String info;
	String gender;
	String regdate;
	
	
	
	public MemberDTO(String userid, String userpw, String username, String job, String hobby, String info,
			String gender, String regdate) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.job = job;
		this.hobby = hobby;
		this.info = info;
		this.gender = gender;
		this.regdate = regdate;
	}
	
	public MemberDTO() {
		
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "MemberDTO [userid=" + userid + ", userpw=" + userpw + ", username=" + username + ", job=" + job
				+ ", hobby=" + hobby + ", info=" + info + ", gender=" + gender + ", regdate=" + regdate + "]";
	}
	
}
