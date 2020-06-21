package com.project.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address 
{
	private String residentialAddress;
	private String permanentAddress;	//optional
	
	Address(){}
	
	public Address(String residentialAddress, String permanentAddress) {
		super();
		this.residentialAddress = residentialAddress;
		this.permanentAddress = permanentAddress;
	}

	public String getResidentialAddress() {
		return residentialAddress;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	@Override
	public String toString() {
		return "Address [residentialAddress=" + residentialAddress + ", permanentAddress=" + permanentAddress + "]";
	}
	
	
}
