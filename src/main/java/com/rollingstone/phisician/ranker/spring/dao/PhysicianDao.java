package com.rollingstone.phisician.ranker.spring.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rollingstone.phisician.ranker.domain.Physician;
import com.rollingstone.phisician.ranker.domain.PhysicianAddress;
import com.rollingstone.phisician.ranker.domain.PhysicianDegree;
import com.rollingstone.phisician.ranker.domain.PhysicianSpeciality;
import com.rollingstone.phisician.ranker.exception.PhysicianLoadException;
import com.rollingstone.phisician.ranker.spring.constants.PhysicianConstants;

@Transactional
@Repository
public class PhysicianDao extends JdbcDaoSupport implements IPhysicianDao {

	private static final Logger LOG = LoggerFactory
			.getLogger(PhysicianDao.class);

	/*
	 * PhysicianDao(){ jdbcTemplate = new JdbcTemplate(getDataSource()); }
	 * 
	 * private JdbcTemplate jdbcTemplate;
	 */

	@Override
	public void loadPhysician(Physician physician)
			throws PhysicianLoadException {
		getJdbcTemplate().update(PhysicianConstants.INSERT_QUERY_P,
				physician.getPhysicianName(), physician.getAge(),
				physician.getGender(), physician.getDateofBirth(),
				physician.getEmailAddress(),
				physician.getResidentialLandLine(),
				physician.getOfficeLandLine(), physician.getCellPhone());
	}

	@Override
	public void loadPhysicianDegree(PhysicianDegree physicianDegree)
			throws PhysicianLoadException {
		getJdbcTemplate().update(PhysicianConstants.INSERT_QUERY_D,
				physicianDegree.getPhysician().getPhysicianId(),
				physicianDegree.getDegree().getDegreeId(),
				physicianDegree.getYearPassed(), physicianDegree.getGpa());

	}

	@Override
	public void loadPhysicianSpeciality(PhysicianSpeciality physicianSpaeiclity)
			throws PhysicianLoadException {
		getJdbcTemplate().update(PhysicianConstants.INSERT_QUERY_S,
				physicianSpaeiclity.getPhysician().getPhysicianId(),
				physicianSpaeiclity.getSpeciality().getSpecialityId(),
				physicianSpaeiclity.getRank());

	}

	@Override
	public void loadPhysicianAddress(PhysicianAddress physicianAddress)
			throws PhysicianLoadException {
		getJdbcTemplate().update(PhysicianConstants.INSERT_QUERY_A,
				physicianAddress.getHouseNumber(), physicianAddress.getCity(),
				physicianAddress.getState(), physicianAddress.getZip(),
				physicianAddress.getCountry(),
				physicianAddress.getAddressType(),
				physicianAddress.getOwnerId());

	}

}
