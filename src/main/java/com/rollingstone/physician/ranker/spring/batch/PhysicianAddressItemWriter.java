package com.rollingstone.physician.ranker.spring.batch;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

import com.rollingstone.physician.ranker.domain.PhysicianAddress;
import com.rollingstone.physician.ranker.exception.PhysicianLoadException;

public class PhysicianAddressItemWriter extends PhysicianBaseItemWriter
		implements ItemWriter<PhysicianAddress> {

	private static final Logger LOG = LoggerFactory
			.getLogger(PhysicianAddressItemWriter.class);

	@Override
	public void write(List<? extends PhysicianAddress> addresses) {

		try {
			for (PhysicianAddress address : addresses) {
				getPhysicianService().loadPhysicianAddress(address);
			}
		} catch (PhysicianLoadException ple) {

			LOG.debug(ple.getMessage());
		}

	}
}
