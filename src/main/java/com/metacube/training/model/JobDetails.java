package com.metacube.training.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "job_details")
public class JobDetails {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "emp_code")
	private int empCode;

	@Column(name = "date_of_joining")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date doj;

	@Column(name = "total_exp")
	private int totalExp;

	@Column(name = "job_code")
	private int jobCode;

	@Column(name = "reporting_mgr")
	private int reportingMgr;

	@Column(name = "team_lead")
	private int teamLead;

	@Column(name = "curr_proj_id")
	private int currProjId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmpCode() {
		return empCode;
	}

	public void setEmpCode(int empCode) {
		this.empCode = empCode;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public int getTotalExp() {
		return totalExp;
	}

	public void setTotalExp(int totalExp) {
		this.totalExp = totalExp;
	}

	public int getJobCode() {
		return jobCode;
	}

	public void setJobCode(int jobCode) {
		this.jobCode = jobCode;
	}

	public int getReportingMgr() {
		return reportingMgr;
	}

	public void setReportingMgr(int reportingMgr) {
		this.reportingMgr = reportingMgr;
	}

	public int getTeamLead() {
		return teamLead;
	}

	public void setTeamLead(int teamLead) {
		this.teamLead = teamLead;
	}

	public int getCurrProjId() {
		return currProjId;
	}

	public void setCurrProjId(int currProjId) {
		this.currProjId = currProjId;
	}

}
