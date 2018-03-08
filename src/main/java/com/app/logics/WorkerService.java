package com.app.logics;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.app.config.AppConfig;
import com.app.domain.Worker;
import com.app.services.MainWorkerService;

@Component
public class WorkerService implements MainWorkerService{
	
	//Getting the data to Worker Object
	@Override
	public List<Worker> getWorkerList() {
		RestTemplate restTemplate = new RestTemplate();
	    Worker[] workerList = restTemplate.getForObject(AppConfig.WORKERS_ENDPOINT, Worker[].class);
	    
	    List<Worker> workers = Arrays.stream(workerList).collect(Collectors.toList());
	    
	    return workers;
	}
}
