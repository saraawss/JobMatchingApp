package com.app.services;

import static com.app.utils.LocationDistanceCalculator.distance;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.config.AppConfig;
import com.app.domain.Job;
import com.app.domain.Worker;


public interface MainJobMatcherService {

	
	public List<Job> getJobMatcher(long workerId);

}
