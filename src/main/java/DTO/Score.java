package DTO;

import java.sql.Date;

//score_no number primary key,/*max +1*/
//score_type char (1), /* a 출석, p 과제, e 시험*/
//score number not null,
//reg_date date not null,
//apply_no number not null,

//점
public class Score {
	int scoreNo;
	String scoreType;
	int scoreNumber;
	Date regDate;
	int applyNo;
	public int getScoreNo() {
		return scoreNo;
	}
	public void setScoreNo(int scoreNo) {
		this.scoreNo = scoreNo;
	}
	public String getScoreType() {
		return scoreType;
	}
	public void setScoreType(String scoreType) {
		this.scoreType = scoreType;
	}
	public int getScoreNumber() {
		return scoreNumber;
	}
	public void setScoreNumber(int scoreNumber) {
		this.scoreNumber = scoreNumber;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getApplyNo() {
		return applyNo;
	}
	public void setApplyNo(int applyNo) {
		this.applyNo = applyNo;
	}
	
	
}
