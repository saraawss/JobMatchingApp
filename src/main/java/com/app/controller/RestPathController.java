package com.app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.domain.Job;
import com.app.domain.Worker;
import com.app.domain.WorkerForView;
import com.app.services.MainJobMatcherService;
import com.app.services.MainWorkerService;

@RestController
public class RestPathController {
	
	@Autowired
	MainWorkerService workerService;
	
	@Autowired
	MainJobMatcherService jobMatcherService;
	
	/**
     * This method will find out the best matching jobs for a given worker.
     * @param workerId
     * @return List of matched jobs
     */
	
	@RequestMapping(value = "/jobmatcher/{workerId}", produces = MediaType.APPLICATION_JSON_VALUE , method = RequestMethod.GET)
    List<Job> getMatchingJobs(@PathVariable long workerId) {

    	try {
    		List<Job> jobs = jobMatcherService.getJobMatcher(workerId);
            return jobs;
        }catch (Exception ex){
            return new ArrayList<>();
        }
    }
    
    @RequestMapping(value = "/workers", method = RequestMethod.GET)
    List<WorkerForView> getWorkerList() {

    	try {
    		List<Worker> workers = workerService.getWorkerList();
            List<WorkerForView> workerList = new ArrayList<>();
            
            for(Worker worker : workers) {
            	WorkerForView workerForView = new WorkerForView();
            	workerForView.setUserId(worker.getUserId());
            	workerForView.setFullName(worker.getName().getFirst()+" "+worker.getName().getLast());
            	workerList.add(workerForView);
            }
            
            return workerList;
        }catch (Exception ex){
            return new ArrayList<>();
        }
    }

}
