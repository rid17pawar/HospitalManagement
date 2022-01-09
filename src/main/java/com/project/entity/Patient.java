package com.project.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Patient 
{
	//to store date i.e. yyyy-mm-dd
		@Temporal(TemporalType.DATE)
		private Date registrationDate;
		
		@Id
		@GenericGenerator(name = "patientId", strategy = "com.project.dao.receptionist.PatientIdGenerator")
		@GeneratedValue(generator = "patientId") //to generate auto incremented custom values for column
		private String pid;
		
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
		
		private String bloodGroup;
		private String chronicDiseases;
		private String medicineAllergy;	
		private String doctorId;
		
		Patient(){}
		
		public Patient(Name name, String birthdate, String gender, String emailID, long mobileNo,
				long adharNo, String country, String state, String city, Address address, String bloodGroup,
				String chronicDiseases, String medicineAllergy, String doctorId) {
			super();
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
			this.bloodGroup = bloodGroup;
			this.chronicDiseases = chronicDiseases;
			this.medicineAllergy = medicineAllergy;
			this.doctorId = doctorId;
		}
		
		public void setRegistrationDate(Date registrationDate) {
			this.registrationDate = registrationDate;
		}
		public void setDoctorId(String doctorId) {
			this.doctorId = doctorId;
		}
		public Date getRegistrationDate() {
			return registrationDate;
		}
		public String getPid() {
			return pid;
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
		public String getBloodGroup() {
			return bloodGroup;
		}
		public String getChronicDiseases() {
			return chronicDiseases;
		}
		public String getMedicineAllergy() {
			return medicineAllergy;
		}
		public String getDoctorId() {
			return doctorId;
		}

		@Override
		public String toString() {
			return "Patient [registrationDate=" + registrationDate + ", pid=" + pid + ", name=" + name + ", birthdate="
					+ birthdate + ", gender=" + gender + ", emailID=" + emailID + ", mobileNo=" + mobileNo
					+ ", adharNo=" + adharNo + ", country=" + country + ", state=" + state + ", city=" + city
					+ ", address=" + address + ", bloodGroup=" + bloodGroup + ", chronicDiseases=" + chronicDiseases
					+ ", medicineAllergy=" + medicineAllergy + ", doctorId=" + doctorId + "]";
		}
			
}
