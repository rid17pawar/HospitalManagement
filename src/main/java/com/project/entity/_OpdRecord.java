package com.project.entity;

//Not annotated using @Entity bcoz we dont want to store its data in database
public class _OpdRecord
{
	Doctor doctor;
	String pid;
	String patientName;
	
	public _OpdRecord() {}
	
	public String getDoctorId() {
		return doctor.getDoctorId();
	}
	public String getDoctorName() {
		return doctor.getName();
	}
	public String getPid() {
		return pid;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setDoctorId(String doctorId) {
		this.doctor.setDoctorId(doctorId);
	}
	public void setDoctorName(String doctorName) {
		this.doctor.setName(doctorName);
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	@Override
	public String toString() {
		return "_OpdRecord [doctorId=" + doctor.getDoctorId() + ", doctorName=" + doctor.getName() + ", pid=" + pid + ", patientName="
				+ patientName + "]";
	}
	
}
