package com.rollingstone.phisician.ranker.spring.batch;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.rollingstone.phisician.ranker.domain.Physician;
import com.rollingstone.phisician.ranker.domain.PhysicianSpeciality;
import com.rollingstone.phisician.ranker.domain.Speciality;

public class PhysicianSpecialityFieldSetMapper implements
		FieldSetMapper<PhysicianSpeciality> {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public PhysicianSpeciality mapFieldSet(FieldSet fs) {

		if (fs == null) {
			return null;
		}

		/*
		 * registration_id,speciality,rank
		 */

		PhysicianSpeciality physicianSpeciality = new PhysicianSpeciality();

		Speciality speciality = new Speciality();

		Physician physician = new Physician();

		physician.setPhysicianId(fs.readInt("registration_id"));

		speciality.setSpeciality(fs.readString("speciality"));
		speciality.setSpecialityId(1);
		// speciality.setSpecialityId(specialityId) // TODO

		physicianSpeciality.setPhysician(physician);

		physicianSpeciality.setSpeciality(speciality);
		physicianSpeciality.setRank(fs.readInt("rank"));

		return physicianSpeciality;
	}

}