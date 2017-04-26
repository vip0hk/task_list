package com.hk.task.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hk.task.model.JobInfo;
import com.hk.task.util.MyMapper;

public interface JobInfoMapper extends MyMapper<JobInfo> {
	
	List<JobInfo> selectJobsByListId(Integer listId);
	
	int selectMaxSortValue(int listId);
	
	int updateSortById(@Param("jobId")int jobId, @Param("sortValue")int sortValue,@Param("listId")int listId);
	int updateSortsBySortValue(@Param("listId")int listId, @Param("sortValue")int sortValue);
	int updateSortsById(@Param("listId") int listId, @Param("jobSort")int jobSort);
}