package com.rollingstone.phisician.ranker.domain;

/**
 * @author Binit Datta
 *
 */
public class PhysicianDegree {

	Physician physician;
	Degree degree;
	int yearPassed;
	float gpa;
	
	public PhysicianDegree(){
		
	}

	public Physician getPhysician() {
		return physician;
	}

	public void setPhysician(Physician physician) {
		this.physician = physician;
	}

	public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	public int getYearPassed() {
		return yearPassed;
	}

	public void setYearPassed(int yearPassed) {
		this.yearPassed = yearPassed;
	}

	public float getGpa() {
		return gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}
	
	
}
