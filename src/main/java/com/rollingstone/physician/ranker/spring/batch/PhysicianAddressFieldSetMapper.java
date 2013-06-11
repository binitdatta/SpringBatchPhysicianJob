package com.rollingstone.physician.ranker.spring.batch;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.rollingstone.physician.ranker.domain.PhysicianAddress;

/**
 * @author Binit Datta
 * 
 */
public class PhysicianAddressFieldSetMapper implements
		FieldSetMapper<PhysicianAddress> {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public PhysicianAddress mapFieldSet(FieldSet fs) {

		if (fs == null) {
			return null;
		}

		/*
		 * registration_id,house_number,city,state,zip,country,type
		 */
		PhysicianAddress address = new PhysicianAddress();

		address.setOwnerId(fs.readInt("registration_id"));
		address.setCity(fs.readString("city"));
		address.setCountry(fs.readString("country"));
		address.setHouseNumber(fs.readString("house_number"));

		address.setAddressType(fs.readString("type"));

		address.setState(fs.readString("state"));
		address.setZip(fs.readString("zip"));

		return address;
	}

}
