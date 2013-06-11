package com.rollingstone.physician.ranker.spring.schedular;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

public class PhysicianLoaderTask {

	private static final Logger LOG = LoggerFactory
			.getLogger(PhysicianLoaderTask.class);

	private JobLauncher jobLauncher;

	private Job physicianJob;

	public Job getPhysicianJob() {
		return physicianJob;
	}

	@Autowired
	@Qualifier("physicianJob")
	public void setPhysicianJob(Job physicianJob) {
		this.physicianJob = physicianJob;
	}

	public JobLauncher getJobLauncher() {
		return jobLauncher;
	}

	@Autowired
	@Required
	public void setJobLauncher(JobLauncher jobLauncher) {
		this.jobLauncher = jobLauncher;
	}

	public void loadPhysicians() {

		LOG.info("Entered sendEvents");
		try {
			Map<String, JobParameter> parameters = new HashMap<String, JobParameter>();
			parameters.put("date", new JobParameter(new Date()));

			jobLauncher.run(physicianJob, new JobParameters(parameters));

		} catch (JobInstanceAlreadyCompleteException ex) {
			LOG.debug("This job has been completed already!");

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}