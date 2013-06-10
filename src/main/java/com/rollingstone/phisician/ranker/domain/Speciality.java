package com.rollingstone.phisician.ranker.domain;

/**
 * @author Binit Datta
 *
 */
public class Speciality {

	long specialityId;
	String speciality;
	
	public Speciality(){
		
	}

	public long getSpecialityId() {
		return specialityId;
	}

	public void setSpecialityId(long specialityId) {
		this.specialityId = specialityId;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
	
}
