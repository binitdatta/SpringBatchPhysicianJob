package com.rollingstone.phisician.ranker.spring.batch;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

import com.rollingstone.phisician.ranker.domain.PhysicianSpeciality;
import com.rollingstone.phisician.ranker.exception.PhysicianLoadException;

public class PhysicianSpecialityItemWriter extends PhysicianBaseItemWriter
		implements ItemWriter<PhysicianSpeciality> {

	private static final Logger LOG = LoggerFactory
			.getLogger(PhysicianSpecialityItemWriter.class);

	@Override
	public void write(List<? extends PhysicianSpeciality> physicianSpecialities) {

		try {
			for (PhysicianSpeciality physicianSpeciality : physicianSpecialities) {
				physicianService.loadPhysicianSpeciality(physicianSpeciality);
			}
		} catch (PhysicianLoadException ple) {

			LOG.debug(ple.getMessage());
		}

	}

}