package com.project.entity;

//Not annotated using @Entity bcoz we dont want to store its data in database
public class _OpdRecord
{
	String doctorId;
	String doctorName;
	String pid;
	String patientName;
	
	public _OpdRecord() {}
	
	public String getDoctorId() {
		return doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public String getPid() {
		return pid;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	@Override
	public String toString() {
		return "_OpdRecord [doctorId=" + doctorId + ", doctorName=" + doctorName + ", pid=" + pid + ", patientName="
				+ patientName + "]";
	}
	
}
