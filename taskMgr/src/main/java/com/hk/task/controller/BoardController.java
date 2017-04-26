package com.hk.task.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hk.task.model.Board;
import com.hk.task.model.SysUser;
import com.hk.task.service.BoardService;

@RestController
@RequestMapping("/boards")
public class BoardController {

    @Autowired
    private BoardService boardService;
    
    /**
     * 当前登录用户
     * @param session
     * @return
     */
    private SysUser getLoginUser(HttpSession session){
    	SysUser loginUser = (SysUser) session.getAttribute("loginUser");
    	return loginUser;
    }
    /**
     * 取得用户白板集合
     * @return
     */
    @RequestMapping
    public List<Board> getByUserId(HttpSession session) {
    	
    	SysUser loginUser = getLoginUser(session);
    	List<Board> boards = boardService.getByUserId(loginUser.getUserId());
        return boards;
    }

    /**
     * 创建白板
     * @param board
     * @return
     */
    @RequestMapping(value = "/add")
    public Board add(Board board, HttpSession session) {
    	SysUser loginUser = getLoginUser(session);
    	board.setUserId(loginUser.getUserId());
    	boardService.save(board);
        return board;
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelMap delete(@PathVariable String id) {
        ModelMap result = new ModelMap();
        boardService.deleteById(id);
        result.put("msg", "删除成功!");
        return result;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelMap save(Board board) {
        ModelMap result = new ModelMap();
        String msg = board.getBoardId() == null ? "新增成功!" : "更新成功!";
        boardService.save(board);
        result.put("userInfo", board);
        result.put("msg", msg);
        return result;
    }
}
