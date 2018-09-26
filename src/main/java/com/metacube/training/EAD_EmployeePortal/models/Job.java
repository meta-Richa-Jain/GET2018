package com.metacube.training.EAD_EmployeePortal.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "job_title_master")
public class Job {

	@Id
	@Column(name = "code")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int code;

	@Column(name = "title")
	private String title;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
