package com.hk.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.task.mapper.JobInfoMapper;
import com.hk.task.model.JobInfo;

@Service
public class JobInfoService {

    @Autowired
    private JobInfoMapper jobInfoMapper;

    public List<JobInfo> getJobsByListId(Integer listId){
    	return jobInfoMapper.selectJobsByListId(listId);
    }
    
    public List<JobInfo> getAll() {
        return jobInfoMapper.selectAll();
    }
    
    public int getMaxSortValue(int listId){
    	return jobInfoMapper.selectMaxSortValue(listId);
    }
    
    public JobInfo getById(String id) {
        return jobInfoMapper.selectByPrimaryKey(id);
    }

    public void deleteById(String id) {
    	jobInfoMapper.deleteByPrimaryKey(id);
    }

    public void save(JobInfo jobInfo) {
        if (jobInfo.getJobId() != null && !"".equals(jobInfo.getJobId())) {
        	jobInfoMapper.updateByPrimaryKey(jobInfo);
        } else {
        	jobInfoMapper.insert(jobInfo);
        }
    }
    
    public boolean move2NewJobBox(int oldJobId, int toListId){
    	int row = jobInfoMapper.updateListId(oldJobId,toListId);
    	return row > 0;
    }
    public boolean updateSort(JobInfo jobInfo){
    	int row = jobInfoMapper.updateSort(jobInfo);
    	return row > 0;
    }

}
