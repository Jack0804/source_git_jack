package org.share0u.domain;

public class PointVO {
	
	private String mid;
	private int mpoint;
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public int getMpoint() {
		return mpoint;
	}
	public void setMpoint(int mpoint) {
		this.mpoint = mpoint;
	}
	@Override
	public String toString() {
		return "PointVO [mid=" + mid + ", mpoint=" + mpoint + "]";
	}
	

}
