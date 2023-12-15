package com.tms.vo;

public class UriVo {

	private Long id;
	
	private String uriEndpoint;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUriEndpoint() {
		return uriEndpoint;
	}

	public void setUriEndpoint(String uriEndpoint) {
		this.uriEndpoint = uriEndpoint;
	}

	@Override
	public String toString() {
		return "UriVo [id=" + id + ", uriEndpoint=" + uriEndpoint + "]";
	}
	
	
}
