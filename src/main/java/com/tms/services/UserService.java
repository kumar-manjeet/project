package com.tms.services;

import com.tms.models.User;
import com.tms.models.request.CreateUserRequestDto;

public interface UserService {

	boolean existsByUsername(String userName);

	boolean existsByEmail(String email);

	boolean existsByMobile(String mobile);

	User save(User user);

	User saveUser(CreateUserRequestDto request);

}
