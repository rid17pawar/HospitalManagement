package com.project.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OpdDetails 
{
	@Id
	int opdid;
	String symptoms;
	String diagnosis;
	String medicinesDose;
	String dos;
	String donts;
	String investigations;
	String followupDate;
	int fees;
	
	public OpdDetails() {}

	public OpdDetails(String symptoms, String diagnosis, String medicinesDose, String dos, String donts,
			String investigations, String followupDate, int fees) {
		super();
		this.symptoms = symptoms;
		this.diagnosis = diagnosis;
		this.medicinesDose = medicinesDose;
		this.dos = dos;
		this.donts = donts;
		this.investigations = investigations;
		this.followupDate = followupDate;
		this.fees = fees;
	}

	public void setOpdid(int opdid) {
		this.opdid = opdid;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public void setMedicinesDose(String medicinesDose) {
		this.medicinesDose = medicinesDose;
	}

	public void setDos(String dos) {
		this.dos = dos;
	}

	public void setDonts(String donts) {
		this.donts = donts;
	}

	public void setInvestigations(String investigations) {
		this.investigations = investigations;
	}

	public void setFollowupDate(String followupDate) {
		this.followupDate = followupDate;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	public int getOpdid() {
		return opdid;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public String getMedicinesDose() {
		return medicinesDose;
	}

	public String getDos() {
		return dos;
	}

	public String getDonts() {
		return donts;
	}

	public String getInvestigations() {
		return investigations;
	}

	public String getFollowupDate() {
		return followupDate;
	}

	public int getFees() {
		return fees;
	}

	@Override
	public String toString() {
		return "OpdDetails [opdid=" + opdid + ", symptoms=" + symptoms + ", diagnosis=" + diagnosis + ", medicinesDose="
				+ medicinesDose + ", dos=" + dos + ", donts=" + donts + ", investigations=" + investigations
				+ ", followupDate=" + followupDate + ", fees=" + fees + "]";
	}

}
