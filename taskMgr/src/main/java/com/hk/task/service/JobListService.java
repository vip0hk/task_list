package com.hk.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.task.mapper.JobListMapper;
import com.hk.task.model.JobList;

@Service
public class JobListService {

    @Autowired
    private JobListMapper jobListMapper;

    public List<JobList> getJobListByBoardId(String boardId) {
        return jobListMapper.selectByBoardId(boardId);
    }

    public void save(JobList jobList) {
        jobListMapper.insert(jobList);
    }
  
}
