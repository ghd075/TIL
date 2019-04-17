package com.jogiyo.vo;

import java.util.Date;

public class NoticeDto {
	private String notice_no;
	private String notice_title;
	private String notice_contents;
	private String n_date;
	public String getNotice_no() {
		return notice_no;
	}
	public void setNotice_no(String notice_no) {
		this.notice_no = notice_no;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getNotice_contents() {
		return notice_contents;
	}
	public void setNotice_contents(String notice_contents) {
		this.notice_contents = notice_contents;
	}
	public String getN_date() {
		return n_date;
	}
	public void setN_date(String n_date) {
		this.n_date = n_date;
	}
	@Override
	public String toString() {
		return "NoticeDto [notice_no=" + notice_no + ", notice_title=" + notice_title + ", notice_contents="
				+ notice_contents + ", n_date=" + n_date + "]";
	}
	public NoticeDto(String notice_no, String notice_title, String notice_contents, String n_date) {
		super();
		this.notice_no = notice_no;
		this.notice_title = notice_title;
		this.notice_contents = notice_contents;
		this.n_date = n_date;
	}
	public NoticeDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}