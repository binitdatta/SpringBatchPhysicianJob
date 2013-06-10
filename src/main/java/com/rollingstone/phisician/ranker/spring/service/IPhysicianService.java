package com.rollingstone.phisician.ranker.spring.service;

import com.rollingstone.phisician.ranker.domain.PhysicianAddress;
import com.rollingstone.phisician.ranker.domain.Physician;
import com.rollingstone.phisician.ranker.domain.PhysicianDegree;
import com.rollingstone.phisician.ranker.domain.PhysicianSpeciality;
import com.rollingstone.phisician.ranker.exception.PhysicianLoadException;

public interface IPhysicianService {

	void loadPhysician(Physician  physician) throws PhysicianLoadException;
	
	void loadPhysicianDegree(PhysicianDegree physicianDegree) throws PhysicianLoadException;

	void loadPhysicianSpeciality(PhysicianSpeciality physicianSpaeiclity) throws PhysicianLoadException;

	void loadPhysicianAddress(PhysicianAddress physicianAddress) throws PhysicianLoadException;

	
	}
