package com.rollingstone.phisician.ranker.domain;

import java.util.Date;

/**
 * @author Binit Datta
 *
 */
public class Physician {

	long physicianId;
	String physicianName;
	PhysicianAddress residencialAddress;
	PhysicianAddress officeAddress;
	int age;
	String gender;
	String dateofBirth;
	String emailAddress;
	String residentialLandLine;
	String officeLandLine;
	String cellPhone;
	
	public Physician(){
		
	}

	public long getPhysicianId() {
		return physicianId;
	}

	public void setPhysicianId(long physicianId) {
		this.physicianId = physicianId;
	}

	public String getPhysicianName() {
		return physicianName;
	}

	public void setPhysicianName(String physicianName) {
		this.physicianName = physicianName;
	}

	public PhysicianAddress getResidencialAddress() {
		return residencialAddress;
	}

	public void setResidencialAddress(PhysicianAddress residencialAddress) {
		this.residencialAddress = residencialAddress;
	}

	public PhysicianAddress getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(PhysicianAddress officeAddress) {
		this.officeAddress = officeAddress;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateofBirth() {
		return dateofBirth;
	}

	public void setDateofBirth(String dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getResidentialLandLine() {
		return residentialLandLine;
	}

	public void setResidentialLandLine(String residentialLandLine) {
		this.residentialLandLine = residentialLandLine;
	}

	public String getOfficeLandLine() {
		return officeLandLine;
	}

	public void setOfficeLandLine(String officeLandLine) {
		this.officeLandLine = officeLandLine;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	
	
	
}
