package com.react.app.model;

import java.util.Date;

public class SampleResponse {
	Date date;
	int id;

	public SampleResponse(int id) {
		super();
		this.date = new Date();
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}