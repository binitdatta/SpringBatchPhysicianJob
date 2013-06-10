package com.rollingstone.phisician.ranker.spring.batch;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.rollingstone.phisician.ranker.domain.Degree;
import com.rollingstone.phisician.ranker.domain.Physician;
import com.rollingstone.phisician.ranker.domain.PhysicianDegree;

public class PhysicianDegreeFieldSetMapper implements
		FieldSetMapper<PhysicianDegree> {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public PhysicianDegree mapFieldSet(FieldSet fs) {

		if (fs == null) {
			return null;
		}

		/*
		 * registration_id,year_passed,percentage,degree_name
		 */
		PhysicianDegree physicianDegree = new PhysicianDegree();

		Degree degree = new Degree();
		Physician physician = new Physician();

		physician.setPhysicianId(fs.readInt("registration_id"));

		// degree.setAwardedBy(fs.readString("awardedby"));
		degree.setDegreeId(1);
		degree.setDegreeName(fs.readString("degree_name"));

		physicianDegree.setPhysician(physician);
		physicianDegree.setDegree(degree);
		physicianDegree.setGpa(fs.readFloat("percentage"));
		physicianDegree.setPhysician(physician);
		physicianDegree.setYearPassed(fs.readInt("year_passed"));

		return physicianDegree;
	}

}