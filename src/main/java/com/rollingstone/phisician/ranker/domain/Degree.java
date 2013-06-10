package com.rollingstone.phisician.ranker.domain;

/**
 * @author Binit Datta
 *
 */
public class Degree {

	long degreeId;
	String degreeName;
	String awardedBy;
	
	public Degree(){
		
	}

	public long getDegreeId() {
		return degreeId;
	}

	public void setDegreeId(long degreeId) {
		this.degreeId = degreeId;
	}

	public String getDegreeName() {
		return degreeName;
	}

	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}

	public String getAwardedBy() {
		return awardedBy;
	}

	public void setAwardedBy(String awardedBy) {
		this.awardedBy = awardedBy;
	}
	
	
}
