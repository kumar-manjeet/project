package com.tms.models.reponse;

public class UriResponseDto {

	private Long uriId;
	private String uriName;
	private Boolean status;
	public Long getUriId() {
		return uriId;
	}
	public void setUriId(Long uriId) {
		this.uriId = uriId;
	}
	public String getUriName() {
		return uriName;
	}
	public void setUriName(String uriName) {
		this.uriName = uriName;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "UriResponseDto [uriId=" + uriId + ", uriName=" + uriName + ", status=" + status + "]";
	}
	
	
}
