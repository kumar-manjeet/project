package com.tms.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.models.Role;
import com.tms.models.User;
import com.tms.models.reponse.ResponseDto;
import com.tms.models.request.CreateUserRequestDto;
import com.tms.repositories.RoleRepository;
import com.tms.repositories.UserRepository;
import com.tms.utils.StatusResponse;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<String> findRoleByUserName(String username) {
		List<String> roleNames = new ArrayList<>();
		try {
			User user = userRepository.findByUsername(username);
			if(user != null) {
				Set<Role> roles = user.getRoles();
				Iterator<Role> iterator = roles.iterator();
				while(iterator.hasNext()) {
					roleNames.add(iterator.next().getName());
				}
				return roleNames;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResponseDto saveUser(CreateUserRequestDto request) {
		ResponseDto response = new ResponseDto();
		try {
			User savedUser = userService.saveUser(request);
			if (savedUser != null && savedUser.getId() != null) {
					response.setMessage("User regestered successfully");
					response.setStatus(StatusResponse.Success);
				}else{
					response.setMessage("User not regestered !!");
					response.setStatus(StatusResponse.Failed);
				}

			
		} catch (Exception e) {
			e.printStackTrace();
			response.setMessage("Something went wrong");
			response.setStatus(StatusResponse.Failed);
		}
		return response;
	}

	@Override
	public List<String> findAllRoles() {
		List<String> roles = new ArrayList<String>();
		try {
			List<Role> allRole = roleRepository.findAll();
			if(!allRole.isEmpty()) {
				for(Role role:allRole) {
					roles.add(role.getName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roles;
	}

}
