package com.hk.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hk.task.model.JobInfo;
import com.hk.task.model.JobList;
import com.hk.task.service.JobInfoService;
import com.hk.task.service.JobListService;

@RestController
@RequestMapping("/jobBoxs")
public class JobListController {

    @Autowired
    private JobListService jobListService;
    
    @Autowired
    private JobInfoService jobInfoService;

    @RequestMapping(value = "/board/{boardId}")
    public List<JobList> jobLists(@PathVariable String boardId) {
    	List<JobList> jobBoxs = jobListService.getJobListByBoardId(boardId);
    	for (JobList jobList : jobBoxs) {
    		
	    	List<JobInfo> dbJobs = jobInfoService.getJobsByListId(jobList.getListId());
    		
			jobList.setJobs(dbJobs);
		}
        return jobBoxs;
    }
    
    @RequestMapping(value = "/add")
    public JobList add(JobList jobList) {
    	jobListService.save(jobList);
        return jobList;
    }

}
