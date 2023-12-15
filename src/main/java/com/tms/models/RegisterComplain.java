package com.tms.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RegisterComplain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "terminal_id")
	private Long terminalId;

	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "name")
	private String name;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "origin")
	private String origin;

	@Column(name = "product")
	private String product;

	@Column(name = "complain_taken_by")
	private String complainTakenBy;

	@Column(name = "complain_date")
	private LocalDateTime complainDate;

	@Column(name = "follow_up_date")
	private LocalDateTime followUpDate;

	@Column(name = "status")
	private String status;

	@Column(name = "address")
	private String address;

	@Column(name = "description")
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

	public LocalDateTime getFollowUpData() {
		return followUpDate;
	}

	public void setFollowUpData(LocalDateTime followUpDate) {
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
		return "RegisterComplain [id=" + id + ", terminalId=" + terminalId + ", mobileNumber=" + mobileNumber
				+ ", name=" + name + ", emailId=" + emailId + ", origin=" + origin + ", product=" + product
				+ ", complainTakenBy=" + complainTakenBy + ", complainDate=" + complainDate + ", followUpDate="
				+ followUpDate + ", status=" + status + ", address=" + address + ", description=" + description + "]";
	}
}
