package com.hk.task.mapper;

import java.util.List;

import com.hk.task.model.JobList;
import com.hk.task.util.MyMapper;

public interface JobListMapper extends MyMapper<JobList> {
	
	List<JobList> selectByBoardId(String boardId);
}