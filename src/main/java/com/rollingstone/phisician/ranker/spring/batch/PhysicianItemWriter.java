package com.rollingstone.phisician.ranker.spring.batch;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

import com.rollingstone.phisician.ranker.domain.Physician;
import com.rollingstone.phisician.ranker.exception.PhysicianLoadException;

public class PhysicianItemWriter extends PhysicianBaseItemWriter implements
		ItemWriter<Physician> {
	private static final Logger LOG = LoggerFactory
			.getLogger(PhysicianItemWriter.class);

	@Override
	public void write(List<? extends Physician> physicians) {

		try {
			for (Physician physician : physicians) {
				getPhysicianService().loadPhysician(physician);
			}
		} catch (PhysicianLoadException ple) {

			LOG.debug(ple.getMessage());
		}

	}

}