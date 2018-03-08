package com.app.logics;

import static com.app.utils.LocationDistanceCalculator.distance;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.config.AppConfig;
import com.app.domain.Job;
import com.app.domain.Worker;
import com.app.services.MainJobMatcherService;
import com.app.services.MainJobService;
import com.app.services.MainWorkerService;

@Component
public class JobMatcherService implements MainJobMatcherService{

	@Autowired
	MainWorkerService workerService;
	
	@Autowired
	MainJobService jobService;
	
	@Override
	public List<Job> getJobMatcher(long workerId) {
		
		List<Worker> workerList = workerService.getWorkerList();
		
		List<Job> jobList = jobService.getJobList();
		
		//Filter workerId from workerList and assuming all the workers are active
		//workerList = workerList.stream().filter(w -> w.isActive() && w.getUserId() == workerId).collect(Collectors.toList());
		workerList = workerList.stream().filter(w -> w.getUserId() == workerId).collect(Collectors.toList());
		
		List<Job> matchedJobs = new ArrayList<>();
		
		for(Worker worker : workerList) {
			
			//Filer based on Driving License
			matchedJobs = jobList.stream().filter(p -> p.isDriverLicenseRequired() == worker.isHasDriversLicense()).collect(Collectors.toList());
			
			//Filtering based on jobSearchAddress.maxJobDistance
			matchedJobs = matchedJobs.stream().filter(p -> distance(
	                worker.getJobSearchAddress().getLatitude(),
	                p.getLocation().getLatitude(),
	                worker.getJobSearchAddress().getLongitude(),
	                p.getLocation().getLongitude(),
	                worker.getJobSearchAddress().getUnit()) <= worker.getJobSearchAddress().getMaxJobDistance())
	                .collect(Collectors.toList());
			
			//Filer based on Certificates
			matchedJobs = matchedJobs.stream().filter(p -> isWorkerHasRequiredCertificates(p.getRequiredCertificates(),worker.getCertificates())== true).collect(Collectors.toList());
	        
			//Filer based on Skills
			matchedJobs = matchedJobs.stream().filter(p -> worker.getSkills().contains(p.getJobTitle())).collect(Collectors.toList());
			
			if(matchedJobs.size() > AppConfig.JOBS_LIMIT){
                matchedJobs.subList(AppConfig.JOBS_LIMIT, matchedJobs.size()).clear();
            }
			
		}
		
		return matchedJobs;
		
	}
	
	private boolean isWorkerHasRequiredCertificates(List requiredCertificates, List certificates){
        for(Object certificate :requiredCertificates){
            if(certificates.contains(certificate)) {
                return true;
            }
        }
        return false;
    }

}
