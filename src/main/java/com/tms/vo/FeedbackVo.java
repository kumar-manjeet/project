package com.tms.vo;

public class FeedbackVo {

	private Long id;

	private Long terminalId;

	private String mobile;

	private String name;

	private String email;

	private String caseOrigin;

	private String category;

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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCaseOrigin() {
		return caseOrigin;
	}

	public void setCaseOrigin(String caseOrigin) {
		this.caseOrigin = caseOrigin;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "FeedbackVo [id=" + id + ", terminalId=" + terminalId + ", mobile=" + mobile + ", name=" + name
				+ ", email=" + email + ", caseOrigin=" + caseOrigin + ", category=" + category + "]";
	}

}
