package com.hk.task.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hk.task.model.JobInfo;
import com.hk.task.service.JobInfoService;
import com.hk.task.util.GsonUtils;

@RestController
@RequestMapping("/jobs")
public class JobInfoController {

    @Autowired
    private JobInfoService jobInfoService;
    
    @RequestMapping(value = "/list/{listId}")
    public List<JobInfo> getJobsByListId(@PathVariable Integer listId) {
    	List<JobInfo> jobs = jobInfoService.getJobsByListId(listId);
        return jobs;
    }
    
//    @RequestMapping
//    public List<JobInfo> getAll() {
//    	List<JobInfo> boards = jobInfoService.getAll();
//        return boards;
//    }

    @RequestMapping(value = "/add")
    public JobInfo add(JobInfo newJob) {
    	int maxSortValue = jobInfoService.getMaxSortValue(newJob.getListId());
    	newJob.setJobSort(maxSortValue + 1);
    	jobInfoService.save(newJob);
        return newJob;
    }
    
    @RequestMapping(value = "/update")
    public JobInfo update(JobInfo newJob) {
    	jobInfoService.save(newJob);
        return newJob;
    }
    
    @RequestMapping(value = "/sort2")
    public Map<String, Boolean> updateSort2(int oldJobId, int toListId, String toList) {
    	
    	Gson gson = GsonUtils.build();
    	List<JobInfo> jobInfos = gson.fromJson(toList, new TypeToken<ArrayList<JobInfo>>() {}.getType());
    	
    	// 1,移动到新的列表
    	jobInfoService.move2NewJobBox(oldJobId, toListId);
    	
    	JobInfo jobInfo = null;
    	for (int i = 0,len = jobInfos.size(); i < len; i++) {
			jobInfo = jobInfos.get(i);
			jobInfo.setJobSort(i);
			jobInfoService.updateSort(jobInfo);
			
		}

    	Map<String, Boolean> result = new HashMap<String, Boolean>();
    	result.put("result", true);
    	return result;
    }
    
    @RequestMapping(value = "/sort3")
    public Map<String, Boolean> updateSort3(String fromList) {
    	
    	Gson gson = GsonUtils.build();
    	List<JobInfo> jobInfos = gson.fromJson(fromList, new TypeToken<ArrayList<JobInfo>>() {}.getType());
    	
    	// 内部排序
    	JobInfo jobInfo = null;
    	for (int i = 0,len = jobInfos.size(); i < len; i++) {
			jobInfo = jobInfos.get(i);
			jobInfo.setJobSort(i);
			jobInfoService.updateSort(jobInfo);
			
		}

    	Map<String, Boolean> result = new HashMap<String, Boolean>();
    	result.put("result", true);
    	return result;
    }
    

    @RequestMapping(value = "/view/{id}")
    public JobInfo view(@PathVariable String id) {
    	JobInfo jobInfo = jobInfoService.getById(id);
        return jobInfo;
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelMap delete(@PathVariable String id) {
        ModelMap result = new ModelMap();
        jobInfoService.deleteById(id);
        result.put("msg", "删除成功!");
        return result;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelMap save(JobInfo jobInfo) {
        ModelMap result = new ModelMap();
        String msg = jobInfo.getJobId() == null ? "新增成功!" : "更新成功!";
        jobInfoService.save(jobInfo);
        result.put("userInfo", jobInfo);
        result.put("msg", msg);
        return result;
    }
}
