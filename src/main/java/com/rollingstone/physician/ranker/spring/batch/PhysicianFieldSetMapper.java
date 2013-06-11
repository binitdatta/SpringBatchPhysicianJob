package com.rollingstone.physician.ranker.spring.batch;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.rollingstone.physician.ranker.domain.Physician;

public class PhysicianFieldSetMapper implements FieldSetMapper<Physician> {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Physician mapFieldSet(FieldSet fs) {

		if (fs == null) {
			return null;
		}

		/*
		 * registration_id,physician_name,age,gender,dob,email,residence_land_phone
		 * ,office_land_phone,cell_phone
		 */
		Physician physician = new Physician();

		physician.setAge(fs.readInt("age"));
		physician.setCellPhone(fs.readString("cell_phone"));
		physician.setDateofBirth(fs.readString("dob"));
		physician.setEmailAddress(fs.readString("email"));
		physician.setGender(fs.readString("gender"));
		physician.setOfficeLandLine(fs.readString("office_land_phone"));
		physician.setPhysicianName(fs.readString("physician_name"));
		physician.setPhysicianId(fs.readInt("registration_id"));
		physician.setResidentialLandLine(fs.readString("residence_land_phone"));

		return physician;
	}

}