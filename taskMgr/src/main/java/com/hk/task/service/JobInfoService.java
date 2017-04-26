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
    
    public boolean updateSorts(int jobId,int listFrom,int listTo,int from,int to){
    	
    	// 1，把listFrom的from后面排序全部-1
    	// 2, 把listTo的to后面排序全部+1
    	int v2 = jobInfoMapper.updateSortsById(listFrom, from);
    	int v3 = jobInfoMapper.updateSortsBySortValue(listTo,to);
    	int v1 = jobInfoMapper.updateSortById(jobId, to, listTo);
    	return v1 >0 && v2 >0 && v3 > 0;
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

}
