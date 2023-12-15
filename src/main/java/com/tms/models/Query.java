package com.tms.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Query")
public class Query {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "terminal_id")
	private String terminalId;

	@Column(name = "oper_date")
	private String openDate;

	@Column(name = "channel")
	private String channel;

	@Column(name = "query_type")
	private String queryType;

	@Column(name = "priority_group")
	private String priorityGroup;

	@Column(name = "assign_to")
	private String assignTo;

	@Column(name = "email")
	private String email;

	@Column(name = "related_search")
	private String relatedSearch;

	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "status")
	private String status;

	@Column(name = "description")
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public String getOpenDate() {
		return openDate;
	}

	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getQueryType() {
		return queryType;
	}

	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}

	public String getPriorityGroup() {
		return priorityGroup;
	}

	public void setPriorityGroup(String priorityGroup) {
		this.priorityGroup = priorityGroup;
	}

	public String getAssignTo() {
		return assignTo;
	}

	public void setAssignTo(String assignTo) {
		this.assignTo = assignTo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRelatedSearch() {
		return relatedSearch;
	}

	public void setRelatedSearch(String relatedSearch) {
		this.relatedSearch = relatedSearch;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Query [id=" + id + ", terminalId=" + terminalId + ", openDate=" + openDate + ", channel=" + channel
				+ ", queryType=" + queryType + ", priorityGroup=" + priorityGroup + ", assignTo=" + assignTo
				+ ", email=" + email + ", relatedSearch=" + relatedSearch + ", mobileNumber=" + mobileNumber
				+ ", status=" + status + ", description=" + description + "]";
	}
	
	

}
