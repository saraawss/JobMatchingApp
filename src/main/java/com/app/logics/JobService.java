package com.app.logics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.app.config.AppConfig;
import com.app.domain.Job;
import com.app.domain.Worker;
import com.app.services.MainJobService;

@Component
public class JobService implements MainJobService{
	
	//Getting the data to Job Object
	@Override
	public List<Job> getJobList() {
		RestTemplate restTemplate = new RestTemplate();
	    Job[] jobList = restTemplate.getForObject(AppConfig.JOBS_ENDPOINT, Job[].class);
	    	    
	    List<Job> jobs = Arrays.stream(jobList).collect(Collectors.toList());
	    
	    return jobs;
	}
}
