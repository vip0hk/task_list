package com.hk.task.mapper;

import java.util.List;

import com.hk.task.model.Board;
import com.hk.task.util.MyMapper;

public interface BoardMapper extends MyMapper<Board> {
	
	List<Board> selecttByUserId(String userId);
}