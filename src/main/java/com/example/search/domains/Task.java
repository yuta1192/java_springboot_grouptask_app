package com.example.search.domains;

import java.sql.Date;

public class Task {

	private int id;
	private boolean status;
	private String title;
	private Date timelimit;
	private int memberId;

	public Task(int id, boolean status, String title, Date timelimit, int memberId) {
		this.id = id;
		this.status = status;
		this.title = title;
		this.timelimit = timelimit;
		this.memberId = memberId;
	}
	
	public Task(String title, Date timelimit, int memberId) {
		this.title = title;
		this.timelimit = timelimit;
		this.memberId = memberId;
	}
	
	public Task(int memberId) {
		this.memberId = memberId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getTimelimit() {
		return timelimit;
	}

	public void setTimelimit(Date timelimit) {
		this.timelimit = timelimit;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
}
