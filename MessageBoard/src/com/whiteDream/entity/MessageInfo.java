package com.whiteDream.entity;

import java.util.Date;

public class MessageInfo {
	private int mid;
	
	private String message;

	private Date mtime;

	public void setMtime(Date mtime) {
		this.mtime = mtime;
	}

	public Date getMtime() {
		return mtime;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public int getMid() {
		return mid;
	}
}
