package com.rollingstone.phisician.ranker.spring.schedular;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class PhysicianLoaderJob extends QuartzJobBean {

	private PhysicianLoaderTask physicianLoaderTask;

	public PhysicianLoaderTask getPhysicianLoaderTask() {
		return physicianLoaderTask;
	}

	@Autowired
	@Required
	public void setPhysicianLoaderTask(PhysicianLoaderTask physicianLoaderTask) {
		this.physicianLoaderTask = physicianLoaderTask;
	}

	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		physicianLoaderTask.loadPhysicians();

	}
}