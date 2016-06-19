package org.share0u.domain;

import java.io.File;
import java.sql.Date;

public class RecordVO {
	
	private int rid;
	private int rhits;
	private int rpoint;
	private int rowCnt;
	
	private String rtitle;
	private Date regdate;
	private Date modifydate;
	private String mid;
	private String rcontent;
	private String rshare;
	private String rnotice;
	private File rfile;
	private String rwho;
	
	private String select;
	
	public String getSelect() {
		return select;
	}
	public void setSelect(String select) {
		this.select = select;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRtitle() {
		return rtitle;
	}
	public void setRtitle(String rtitle) {
		this.rtitle = rtitle;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getModifydate() {
		return modifydate;
	}
	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}
	public int getRhits() {
		return rhits;
	}
	public void setRhits(int rhits) {
		this.rhits = rhits;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public int getRpoint() {
		return rpoint;
	}
	public void setRpoint(int rpoint) {
		this.rpoint = rpoint;
	}
	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}
	public String getRshare() {
		return rshare;
	}
	public void setRshare(String rshare) {
		this.rshare = rshare;
	}
	public String getRnotice() {
		return rnotice;
	}
	public void setRnotice(String rnotice) {
		this.rnotice = rnotice;
	}
	public File getRfile() {
		return rfile;
	}
	public void setRfile(File rfile) {
		this.rfile = rfile;
	}
	public String getRwho() {
		return rwho;
	}
	public void setRwho(String rwho) {
		this.rwho = rwho;
	}
	@Override
	public String toString() {
		return "RecordVO [rid=" + rid + ", rtitle=" + rtitle + ", regdate=" + regdate + ", modifydate=" + modifydate
				+ ", rhits=" + rhits + ", mid=" + mid + ", rpoint=" + rpoint + ", rcontent=" + rcontent + ", rshare="
				+ rshare + ", rnotice=" + rnotice + ", rfile=" + rfile + ", rwho=" + rwho + "]";
	}
	

}
