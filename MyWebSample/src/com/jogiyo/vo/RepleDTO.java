package com.jogiyo.vo;

public class RepleDTO {
	private int repleNo;
	private int pNo;
	private int reSeq;
	private int reLevel;
	private int userCode;
	private int boardNo;
	private String repleText;
	private String reDate;
	
	private int evalScore;
	private String checkCode;
	
	public int getEvalScore() {
		return evalScore;
	}
	public void setEvalScore(int evalScore) {
		this.evalScore = evalScore;
	}
	public String getCheckCode() {
		return checkCode;
	}
	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}
	public String getReDate() {
		return reDate;
	}
	public void setReDate(String reDate) {
		this.reDate = reDate;
	}
	public int getRepleNo() {
		return repleNo;
	}
	public void setRepleNo(int repleNo) {
		this.repleNo = repleNo;
	}
	public int getpNo() {
		return pNo;
	}
	public void setpNo(int pNo) {
		this.pNo = pNo;
	}
	public int getReSeq() {
		return reSeq;
	}
	public void setReSeq(int reSeq) {
		this.reSeq = reSeq;
	}
	public int getReLevel() {
		return reLevel;
	}
	public void setReLevel(int reLevel) {
		this.reLevel = reLevel;
	}
	public String getRepleText() {
		return repleText;
	}
	public void setRepleText(String repleText) {
		this.repleText = repleText;
	}
	public int getUserCode() {
		return userCode;
	}
	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	@Override
	public String toString() {
		return "RepleDTO [repleNo=" + repleNo + ", pNo=" + pNo + ", reSeq=" + reSeq + ", reLevel=" + reLevel
				+ ", userCode=" + userCode + ", boardNo=" + boardNo + ", repleText=" + repleText + ", reDate=" + reDate
				+ ", evalScore=" + evalScore + ", checkCode=" + checkCode + "]";
	}

	
	
}
