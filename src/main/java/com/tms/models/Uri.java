package com.tms.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="uri")
public class Uri {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="uri_endpoint")
	private String uriEndpoint; 
	
	@ManyToMany(mappedBy = "uris", fetch = FetchType.EAGER)
	private Set<Role> roles;

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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Uri [id=" + id + ", uriEndpoint=" + uriEndpoint + ", roles=" + roles + "]";
	}
	
	
}
