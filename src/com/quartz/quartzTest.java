package com.quartz;

import java.text.ParseException;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
@ClassName: quartzTest
@Description: 特别注意Quartz版本，不同版本代码差别较大
@author BEE 
@date 2016-5-23 上午10:54:39
 */
public class quartzTest {
	public static void main(String args[]) throws SchedulerException,
			ParseException {
		JobDetail jobDetail = JobBuilder.newJob(SimpleJob.class).withIdentity("testJob_1", "group_1").build();

		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger_1", "group_1").startNow().withSchedule(
						SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(10) // 时间间隔
						.withRepeatCount(5) // 重复次数(将执行6次)
				).build();
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sched = sf.getScheduler();

		sched.scheduleJob(jobDetail, trigger);

		sched.start();

	}
}
