package com.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;

@Entity
public class Opd 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //to generate auto incremented values for column
	private int opdId=1;
	
	//to store date i.e. yyyy-mm-dd
	@Temporal(TemporalType.DATE)
	private Date visitDate;
	private String pid;
	private String doctorId;  
	private int status;
	
	public static final int PENDING=1;
	public static final int DONE=0;
	
	Opd(){}
		
	public Opd(String pid, String doctorId, int status) {
		super();
		this.pid = pid;
		this.doctorId = doctorId;
		this.status = status;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getOpdId() {
		return opdId;
	}
	public Date getVisitDate() {
		return visitDate;
	}
	public String getPid() {
		return pid;
	}
	public String getDoctorId() {
		return doctorId;
	}
	public int getStatus() {
		return status;
	}
	
	@Override
	public String toString() {
		return "Opd [opdId=" + opdId + ", visitDate=" + visitDate + ", pid=" + pid + ", doctorId=" + doctorId + ", status="
				+ status + "]";
	}
	
}
