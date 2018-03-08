package com.app.JobMatchingApp;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.domain.Job;
import com.app.domain.Worker;
import com.app.services.MainJobMatcherService;
import com.app.services.MainJobService;
import com.app.services.MainWorkerService;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest{
	
	@Autowired
	MainWorkerService workerService;
	
	@Autowired
	MainJobService jobService;
	
	@Autowired
	MainJobMatcherService jobMatcherService;
	
    @Test
    public void getWorkerlist() {
    	List<Worker> workers = workerService.getWorkerList();
    	Assert.assertEquals(workers.size(), 50);
    }
    
    @Test
    public void getJoblist() {
    	List<Job> jobs = jobService.getJobList();
    	Assert.assertEquals(jobs.size(), 40);
    	
    }
   
    @Test
    public void getMatchingJobs() {
    	List<Job> jobs = jobMatcherService.getJobMatcher(12);
    	Assert.assertEquals(jobs.size(), 3);
    }
}
