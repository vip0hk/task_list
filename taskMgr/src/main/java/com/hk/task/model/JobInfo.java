package com.hk.task.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "job_info")
public class JobInfo {
    @Id
    @Column(name = "job_id")
    private Integer jobId;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "job_desc")
    private String jobDesc;

    @Column(name = "job_color")
    private String jobColor;

    @Column(name = "job_end_date")
    private Date jobEndDate;

    @Column(name = "list_id")
    private Integer listId;
    
    @Column(name="job_sort")
    private int jobSort;

    public int getJobSort() {
		return jobSort;
	}

	public void setJobSort(int jobSort) {
		this.jobSort = jobSort;
	}

	/**
     * @return job_id
     */
    public Integer getJobId() {
        return jobId;
    }

    /**
     * @param jobId
     */
    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    /**
     * @return job_title
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * @param jobTitle
     */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    /**
     * @return job_desc
     */
    public String getJobDesc() {
        return jobDesc;
    }

    /**
     * @param jobDesc
     */
    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    /**
     * @return job_color
     */
    public String getJobColor() {
        return jobColor;
    }

    /**
     * @param jobColor
     */
    public void setJobColor(String jobColor) {
        this.jobColor = jobColor;
    }

    /**
     * @return job_end_date
     */
    public Date getJobEndDate() {
        return jobEndDate;
    }

    /**
     * @param jobEndDate
     */
    public void setJobEndDate(Date jobEndDate) {
        this.jobEndDate = jobEndDate;
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
}