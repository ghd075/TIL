package com.springbook.biz.board;

import java.sql.Date;
import java.util.Arrays;

//import org.springframework.web.multipart.MultipartFile;

public class BoardVO {
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;
	private String msg;
	private String searchCondition;
	private String searchKeyword;
	private String[] seqs;
	//private MultipartFile uploadFile;
	private String filename;
	private int first;
	private int last;
	
	/*
	 * public MultipartFile getUploadFile() { return uploadFile; }
	 * 
	 * public void setUploadFile(MultipartFile uploadFile) { this.uploadFile =
	 * uploadFile; }
	 */
	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getLast() {
		return last;
	}

	public void setLast(int last) {
		this.last = last;
	}
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getSeq() {
		return seq;
	}
	
	public void setSeq(int seq) {
		this.seq = seq;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getWriter() {
		return writer;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getRegDate() {
		return regDate;
	}
	
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	public int getCnt() {
		return cnt;
	}
	
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public String[] getSeqs() {
		return seqs;
	}

	public void setSeqs(String[] seqs) {
		this.seqs = seqs;
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regDate="
				+ regDate + ", cnt=" + cnt + ", msg=" + msg + ", searchCondition=" + searchCondition
				+ ", searchKeyword=" + searchKeyword + ", seqs=" + Arrays.toString(seqs) + ", filename=" + filename
				+ ", first=" + first + ", last=" + last + "]";
	}
}
