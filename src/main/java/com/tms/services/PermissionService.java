package com.tms.services;

import java.util.List;

import com.tms.models.Role;
import com.tms.models.Uri;
import com.tms.models.reponse.UriResponseDto;
import com.tms.models.request.SaveRolePermissonRequestDto;
import com.tms.vo.RoleVo;
import com.tms.vo.UriVo;

public interface PermissionService {

	List<RoleVo> getAllRoles();

	List<UriResponseDto> getRolePermssionOnUriByRoleId(Long id);

	RoleVo getRoleById(Long id);

	Boolean saveRolePermisson(SaveRolePermissonRequestDto request);

	List<UriVo> getAllUri();

	UriVo getUri(String uri);

	Uri saveUri(String uri);

	RoleVo getRole(String role);

	Role saveRole(String role);

}
