package com.hk.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.task.mapper.BoardMapper;
import com.hk.task.model.Board;

@Service
public class BoardService {

    @Autowired
    private BoardMapper boardMapper;

    public List<Board> getByUserId(String userId) {
        return boardMapper.selecttByUserId(userId);
    }
    
    public Board getById(String id) {
        return boardMapper.selectByPrimaryKey(id);
    }

    public void deleteById(String id) {
    	boardMapper.deleteByPrimaryKey(id);
    }

    public void save(Board board) {
        if (board.getBoardId() != null) {
        	boardMapper.updateByPrimaryKey(board);
        } else {
        	boardMapper.insert(board);
        }
    }

}
