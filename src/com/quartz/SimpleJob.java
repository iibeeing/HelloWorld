package com.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SimpleJob implements Job {

	@Override
	public void execute(JobExecutionContext jobCtx)
			throws JobExecutionException {
		//该方法可以包含想要执行的任何代码
		System.out.println(jobCtx.getTrigger().getKey() + " triggered.time is. " + (new Date()));
	}

}
