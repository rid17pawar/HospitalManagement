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
	private String patientId;
	private String doctorId;  
	private int status;
	
	public static final int PENDING=1;
	public static final int DONE=0;
	
	Opd(){}
		
	public Opd(String patientId, String doctorId, int status) {
		super();
		this.patientId = patientId;
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
	public String getPatientId() {
		return patientId;
	}
	public String getDoctorId() {
		return doctorId;
	}
	public int getStatus() {
		return status;
	}
	
	@Override
	public String toString() {
		return "Opd [opdId=" + opdId + ", visitDate=" + visitDate + ", patientId=" + patientId + ", doctorId=" + doctorId + ", status="
				+ status + "]";
	}
	
}
