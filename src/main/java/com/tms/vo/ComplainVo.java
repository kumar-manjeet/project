package com.tms.vo;

import java.time.LocalDateTime;

public class ComplainVo {

	private Long id;

	private Long terminalId;

	private String mobileNumber;

	private String name;

	private String emailId;

	private String origin;

	private String product;

	private String complainTakenBy;

	private LocalDateTime complainDate;

	private LocalDateTime followUpDate;

	private String status;

	private String address;

	
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(Long terminalId) {
		this.terminalId = terminalId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getComplainTakenBy() {
		return complainTakenBy;
	}

	public void setComplainTakenBy(String complainTakenBy) {
		this.complainTakenBy = complainTakenBy;
	}

	public LocalDateTime getComplainDate() {
		return complainDate;
	}

	public void setComplainDate(LocalDateTime complainDate) {
		this.complainDate = complainDate;
	}

	public LocalDateTime getFollowUpDate() {
		return followUpDate;
	}

	public void setFollowUpDate(LocalDateTime followUpDate) {
		this.followUpDate = followUpDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ComplainVo [id=" + id + ", terminalId=" + terminalId + ", mobileNumber=" + mobileNumber + ", name="
				+ name + ", emailId=" + emailId + ", origin=" + origin + ", product=" + product + ", complainTakenBy="
				+ complainTakenBy + ", complainDate=" + complainDate + ", followUpDate=" + followUpDate + ", status="
				+ status + ", address=" + address + ", description=" + description + "]";
	}

}
