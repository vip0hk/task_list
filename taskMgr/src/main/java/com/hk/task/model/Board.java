package com.hk.task.model;

import javax.persistence.*;

public class Board {
    @Id
    @Column(name = "board_id")
    private Integer boardId;

    @Column(name = "board_name")
    private String boardName;

    @Column(name = "board_color")
    private String boardColor;
    
    @Column(name = "user_id")
    private String userId;

    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
     * @return board_id
     */
    public Integer getBoardId() {
        return boardId;
    }

    /**
     * @param boardId
     */
    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }

    /**
     * @return board_name
     */
    public String getBoardName() {
        return boardName;
    }

    /**
     * @param boardName
     */
    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    /**
     * @return board_color
     */
    public String getBoardColor() {
        return boardColor;
    }

    /**
     * @param boardColor
     */
    public void setBoardColor(String boardColor) {
        this.boardColor = boardColor;
    }
}