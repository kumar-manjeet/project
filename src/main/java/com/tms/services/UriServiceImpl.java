package com.tms.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.models.Role;
import com.tms.models.Uri;
import com.tms.repositories.UriRepository;

@Service
public class UriServiceImpl implements UriService{
	
	@Autowired
	private UriRepository uriRepository;
	
	public Set<String> getRolesByUri(String uri){
		Set<String> role = new HashSet<>();
		try {
			Uri byUriEndpoint = uriRepository.findByUriEndpoint(uri);
			Set<Role> roles = byUriEndpoint.getRoles();
			for(Role data :roles) {
				role.add(data.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return role;
	}
	
}
