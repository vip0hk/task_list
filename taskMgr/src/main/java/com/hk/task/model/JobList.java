package com.hk.task.model;

import java.util.List;

import javax.persistence.*;

@Table(name = "job_list")
public class JobList {
    @Id
    @Column(name = "list_id")
    private Integer listId;

    @Column(name = "list_title")
    private String listTitle;

    @Column(name = "board_id")
    private String boardId;
    
    @Transient
    private List<JobInfo> jobs;
    
    public List<JobInfo> getJobs() {
		return jobs;
	}

	public void setJobs(List<JobInfo> jobs) {
		this.jobs = jobs;
	}

	/**
     * @return list_id
     */
    public Integer getListId() {
        return listId;
    }

    /**
     * @param listId
     */
    public void setListId(Integer listId) {
        this.listId = listId;
    }

    /**
     * @return list_title
     */
    public String getListTitle() {
        return listTitle;
    }

    /**
     * @param listTitle
     */
    public void setListTitle(String listTitle) {
        this.listTitle = listTitle;
    }

    /**
     * @return board_id
     */
    public String getBoardId() {
        return boardId;
    }

    /**
     * @param boardId
     */
    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }
}