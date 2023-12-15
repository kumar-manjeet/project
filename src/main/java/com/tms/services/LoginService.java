package com.tms.services;

import java.util.List;

import com.tms.models.reponse.ResponseDto;
import com.tms.models.request.CreateUserRequestDto;

public interface LoginService {

	List<String> findRoleByUserName(String username);

	ResponseDto saveUser(CreateUserRequestDto request);

	List<String> findAllRoles();

}
