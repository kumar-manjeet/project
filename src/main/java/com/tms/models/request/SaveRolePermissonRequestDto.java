package com.tms.models.request;

import java.util.ArrayList;
import java.util.List;

import com.tms.models.reponse.UriResponseDto;

public class SaveRolePermissonRequestDto {

	private Long roleId;
	
	private ArrayList<UriResponseDto> uriResponseDto;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public ArrayList<UriResponseDto> getUriResponseDto() {
		return uriResponseDto;
	}

	public void setUriResponseDto(ArrayList<UriResponseDto> uriResponseDto) {
		this.uriResponseDto = uriResponseDto;
	}

	@Override
	public String toString() {
		return "SaveRolePermissonRequestDto [roleId=" + roleId + ", uriResponseDto=" + uriResponseDto + "]";
	}


	
}
