package com.project.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Name 
{
	private String firstName;
	private String middleName;
	private String lastName;
	
	public Name() {}
	
	public Name(String firstName, String middleName, String lastName) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}
	

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return "Name [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + "]";
	}
	
}
