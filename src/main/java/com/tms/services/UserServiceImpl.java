package com.tms.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tms.models.Role;
import com.tms.models.User;
import com.tms.models.request.CreateUserRequestDto;
import com.tms.repositories.RoleRepository;
import com.tms.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public boolean existsByUsername(String userName) {
		return userRepository.existsByUsername(userName);
	}

	@Override
	public boolean existsByEmail(String email) {
		return userRepository.existsByEmail(email);
	}

	@Override
	public boolean existsByMobile(String mobile) {
		return userRepository.existsByMobile(mobile);
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User saveUser(CreateUserRequestDto request) {
		try {
			// Create new user's account
			User user = new User();
			user.setUsername(request.getUserName());
			user.setPassword(encoder.encode(request.getPassword()));
			user.setEmail(request.getEmail());
			user.setMobile(request.getMobile());

			user.setUnlocking(true);
			user.setStatus(true);
			user.setAtemptCount(0);

			Set<Role> roles = new HashSet<>();
			if(request.getRole()!=null && !request.getRole().equals("")) {
				Role role = roleRepository.findByName(request.getRole());
				roles.add(role);
				user.setRoles(roles);
			}
			User savedUser = userRepository.save(user);
			if (savedUser != null && savedUser.getId() != null) {
				return savedUser;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
