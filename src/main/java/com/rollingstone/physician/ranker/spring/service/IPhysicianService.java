package com.rollingstone.physician.ranker.spring.service;

import com.rollingstone.physician.ranker.domain.Physician;
import com.rollingstone.physician.ranker.domain.PhysicianAddress;
import com.rollingstone.physician.ranker.domain.PhysicianDegree;
import com.rollingstone.physician.ranker.domain.PhysicianSpeciality;
import com.rollingstone.physician.ranker.exception.PhysicianLoadException;

public interface IPhysicianService {

	void loadPhysician(Physician  physician) throws PhysicianLoadException;
	
	void loadPhysicianDegree(PhysicianDegree physicianDegree) throws PhysicianLoadException;

	void loadPhysicianSpeciality(PhysicianSpeciality physicianSpaeiclity) throws PhysicianLoadException;

	void loadPhysicianAddress(PhysicianAddress physicianAddress) throws PhysicianLoadException;

	
	}
