package org.share0u.domain;

import java.io.File;
import java.sql.Date;

public class MemberVO {

	private String mid;
	private String mname;
	private String mpw;
	private String mrole;
	private Date regdate;
	private File mphoto;
	
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public String getMrole() {
		return mrole;
	}
	public void setMrole(String mrole) {
		this.mrole = mrole;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public File getMphoto() {
		return mphoto;
	}
	public void setMphoto(File mphoto) {
		this.mphoto = mphoto;
	}
	@Override
	public String toString() {
		return "MemberVO [mid=" + mid + ", mname=" + mname + ", mpw=" + mpw + ", mrole=" + mrole + ", regdate="
				+ regdate + ", mphoto=" + mphoto + "]";
	}
	
	
	
	
}
