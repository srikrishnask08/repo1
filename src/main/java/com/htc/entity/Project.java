package com.htc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long projectId;
	private String clientname;

	public Project() {
		super();
	}

	public Project(Long projectId, String clientname) {
		super();
		this.projectId = projectId;
		this.clientname = clientname;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getClientname() {
		return clientname;
	}

	public void setClientname(String clientname) {
		this.clientname = clientname;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", clientname=" + clientname + "]";
	}





}
