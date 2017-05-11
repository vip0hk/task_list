package com.hk.task.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hk.task.model.JobInfo;
import com.hk.task.model.JobList;
import com.hk.task.service.JobInfoService;
import com.hk.task.service.JobListService;
import com.hk.task.util.GsonUtils;

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
    
    @RequestMapping(value = "/sort1")
    public Map<String, Boolean> updateSort1(String list) {
    	
    	Gson gson = GsonUtils.build();
    	List<JobList> jobBoxs = gson.fromJson(list, new TypeToken<ArrayList<JobList>>() {}.getType());
    	
    	// 内部排序
    	JobList jobList = null;
    	for (int i = 0,len = jobBoxs.size(); i < len; i++) {
			jobList = jobBoxs.get(i);
			jobList.setListSort(i);
			jobListService.updateSort(jobList);
			
		}

    	Map<String, Boolean> result = new HashMap<String, Boolean>();
    	result.put("result", true);
    	return result;
    }
    

}
