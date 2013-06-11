package com.rollingstone.physician.ranker.domain;

/**
 * @author Binit Datta
 *
 */
public class PhysicianSpeciality {

	Physician physician;
	Speciality speciality;
	int rank;
	
	public PhysicianSpeciality(){
		
	}

	public Physician getPhysician() {
		return physician;
	}

	public void setPhysician(Physician physician) {
		this.physician = physician;
	}

	public Speciality getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	
	
}
