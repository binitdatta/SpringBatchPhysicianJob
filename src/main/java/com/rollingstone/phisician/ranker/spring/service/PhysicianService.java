package com.rollingstone.phisician.ranker.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import com.rollingstone.phisician.ranker.domain.Physician;
import com.rollingstone.phisician.ranker.domain.PhysicianAddress;
import com.rollingstone.phisician.ranker.domain.PhysicianDegree;
import com.rollingstone.phisician.ranker.domain.PhysicianSpeciality;
import com.rollingstone.phisician.ranker.exception.PhysicianLoadException;
import com.rollingstone.phisician.ranker.spring.dao.IPhysicianDao;
@Service
public class PhysicianService implements IPhysicianService {

	IPhysicianDao physicianDao;
	
	
	public IPhysicianDao getPhysicianDao() {
		return physicianDao;
	}

	@Autowired
	@Required
	public void setPhysicianDao(IPhysicianDao physicianDao) {
		this.physicianDao = physicianDao;
	}

	@Override
	public void loadPhysician(Physician physician)
			throws PhysicianLoadException {
		physicianDao.loadPhysician(physician);
		
	}

	@Override
	public void loadPhysicianDegree(PhysicianDegree physicianDegree)
			throws PhysicianLoadException {
		physicianDao.loadPhysicianDegree(physicianDegree);
		
	}

	@Override
	public void loadPhysicianSpeciality(PhysicianSpeciality physicianSpaeiclity)
			throws PhysicianLoadException {
		physicianDao.loadPhysicianSpeciality(physicianSpaeiclity);
		
	}

	@Override
	public void loadPhysicianAddress(PhysicianAddress physicianAddress)
			throws PhysicianLoadException {
		physicianDao.loadPhysicianAddress(physicianAddress);
		
	}

}
