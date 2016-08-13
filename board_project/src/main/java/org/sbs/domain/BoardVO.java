package org.sbs.domain;

import java.sql.Date;

public class BoardVO {
	
	String 	writer;
	String 	contents;
	String 	title;
	
	Date   	regDate;
	Date   	modifyDate;
	
	int    	bno;
	int    	hits;
	int		count;
	int    	comments;
	char 	deleted;
	
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		
		this.count = count;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getComments() {
		return comments;
	}
	public void setComments(int comments) {
		this.comments = comments;
	}
	public char getDeleted() {
		return deleted;
	}
	public void setDeleted(char deleted) {
		this.deleted = deleted;
	}
	
	@Override
	public String toString() {
		return "BoardVO [writer=" + writer + ", contents=" + contents + ", title=" + title + ", regDate=" + regDate
				+ ", modifyDate=" + modifyDate + ", bno=" + bno + ", hits=" + hits + ", count=" + count + ", comments="
				+ comments + ", deleted=" + deleted + "]";
	}
	
	
	
	
}