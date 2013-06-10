package com.rollingstone.phisician.ranker.spring.batch;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

import com.rollingstone.phisician.ranker.domain.PhysicianDegree;
import com.rollingstone.phisician.ranker.exception.PhysicianLoadException;

public class PhysicianDegreeItemWriter extends PhysicianBaseItemWriter
		implements ItemWriter<PhysicianDegree> {

	private static final Logger LOG = LoggerFactory
			.getLogger(PhysicianDegreeItemWriter.class);

	@Override
	public void write(List<? extends PhysicianDegree> physicianDegrees) {

		try {
			for (PhysicianDegree physicianDegree : physicianDegrees) {
				getPhysicianService().loadPhysicianDegree(physicianDegree);
			}
		} catch (PhysicianLoadException ple) {

			LOG.debug(ple.getMessage());
		}

	}

}
