package com.sample;

import java.io.Serializable;
import java.util.Date;

public class Task implements Serializable{
	private int id;
	private String member;
	private Date deadline;
	private String text;
	private boolean isCompleted;

	public Task() {

	}

	public Task(int id, String member, Date deadline, String text) {
		super();
		this.id = id;
		this.member = member;
		this.deadline = deadline;
		this.text = text;
		this.isCompleted = false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", member=" + member + ", deadline=" + deadline + ", text=" + text + ", isCompleted="
				+ isCompleted + "]";
	}

}


