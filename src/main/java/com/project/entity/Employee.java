package com.project.entity;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Employee 
{
	//to store date i.e. yyyy-mm-dd
	@Temporal(TemporalType.DATE)
	private Date joiningDate;
	
	@Id
	@GenericGenerator(name = "employeeId", strategy = "com.project.dao.administrator.EmployeeIdGenerator")
	@GeneratedValue(generator = "employeeId") //to generate auto incremented custom values for column
	private String eid;
	
	private Name name;
	
	private String birthdate;
	private String gender;
	
	@Column(unique=true)
	private String emailID;	//optional
	
	@Column(unique=true)
	private long mobileNo;	
	
	@Column(unique=true)
	private long adharNo;
	
	private String country;
	private String state;
	private String city;
	
	private Address address;
	
	private String role;
	private String qualification;
	private String specialization;	//optional
	private int status;
		
	public Employee(){}

	public Employee(Date joiningDate, Name name, String birthdate, String gender, String emailID, long mobileNo,
			long adharNo, String country, String state, String city, Address address, String role, String qualification,
			String specialization) {
		super();
		this.joiningDate = joiningDate;
		this.name = name;
		this.birthdate = birthdate;
		this.gender = gender;
		this.emailID = emailID;
		this.mobileNo = mobileNo;
		this.adharNo = adharNo;
		this.country = country;
		this.state = state;
		this.city = city;
		this.address = address;
		this.role = role;
		this.qualification = qualification;
		this.specialization = specialization;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	

	public Date getJoiningDate() {
		return joiningDate;
	}

	public String getEid() {
		return eid;
	}

	public Name getName() {
		return name;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public String getGender() {
		return gender;
	}

	public String getEmailID() {
		return emailID;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public long getAdharNo() {
		return adharNo;
	}

	public String getCountry() {
		return country;
	}

	public String getState() {
		return state;
	}

	public String getCity() {
		return city;
	}

	public Address getAddress() {
		return address;
	}

	public String getRole() {
		return role;
	}

	public String getQualification() {
		return qualification;
	}

	public String getSpecialization() {
		return specialization;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Employee [joiningDate=" + joiningDate + ", eid=" + eid + ", name=" + name + ", birthdate=" + birthdate
				+ ", gender=" + gender + ", emailID=" + emailID + ", mobileNo=" + mobileNo + ", adharNo=" + adharNo
				+ ", country=" + country + ", state=" + state + ", city=" + city + ", address=" + address + ", role="
				+ role + ", qualification=" + qualification + ", specialization=" + specialization + "]";
	}

	
}
