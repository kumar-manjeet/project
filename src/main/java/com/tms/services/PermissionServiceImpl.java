package com.tms.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.models.Role;
import com.tms.models.Uri;
import com.tms.models.reponse.UriResponseDto;
import com.tms.models.request.SaveRolePermissonRequestDto;
import com.tms.repositories.RoleRepository;
import com.tms.repositories.UriRepository;
import com.tms.repositories.UserRepository;
import com.tms.vo.RoleVo;
import com.tms.vo.UriVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UriRepository uriRepository;
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public List<RoleVo> getAllRoles() {
		List<RoleVo> rolesVo = new ArrayList<>();
		try {
			List<Role> roles = roleRepository.findAll();
			rolesVo = roles.stream().map(data -> {
				RoleVo roleVo = new RoleVo();
				roleVo.setId(data.getId());
				roleVo.setName(data.getName());
				return roleVo;
			}).collect(Collectors.toList());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rolesVo;
	}

	@Override
	public List<UriResponseDto> getRolePermssionOnUriByRoleId(Long id) {
		List<UriResponseDto> uriDetails = new ArrayList<>();
		try {
			Role role = roleRepository.findById(id).get();
			Set<Uri> uris = role.getUris();
			Set<Long> uriIds = uris.stream().map(data -> {
				return data.getId();
			}).collect(Collectors.toSet());
			List<Uri> allUri = uriRepository.findAll();
			uriDetails = allUri.stream().map(data -> {
				UriResponseDto uriDetail = new UriResponseDto();
				uriDetail.setUriId(data.getId());
				uriDetail.setUriName(data.getUriEndpoint());
				if (uriIds.contains(data.getId())) {
					uriDetail.setStatus(true);
				} else {
					uriDetail.setStatus(false);
				}
				return uriDetail;
			}).collect(Collectors.toList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return uriDetails;
	}

	@Override
	public RoleVo getRoleById(Long id) {
		RoleVo roleVo = new RoleVo();
		try {
			Role role = roleRepository.findById(id).get();
			roleVo.setId(role.getId());
			roleVo.setName(role.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roleVo;
	}

	@Override
	public Boolean saveRolePermisson(SaveRolePermissonRequestDto request) {
		try {
			Set<Uri> uris = new HashSet<>();
//			List<Uri> allUris = uriRepository.findAll();
			for(UriResponseDto data : request.getUriResponseDto()) {
				if(data.getStatus() != null && data.getStatus() == true) {
					Uri uri = uriRepository.findById(data.getUriId()).get();
					uris.add(uri);
				}
			}
			Role role = roleRepository.findById(request.getRoleId()).get();
			role.setUris(uris);
			Role save = roleRepository.save(role);
			if(save != null) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<UriVo> getAllUri() {
		List<UriVo> uris = new ArrayList<>();
		try {
			List<Uri> allUri = uriRepository.findAll();
			uris = allUri.stream().map(data -> {
				UriVo uriVo = new UriVo();
				uriVo.setId(data.getId());
				uriVo.setUriEndpoint(data.getUriEndpoint());
				return uriVo;
			}).collect(Collectors.toList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return uris;
	}

	@Override
	public UriVo getUri(String uri) {
		UriVo uriVo = new UriVo();
		try {
			Uri byUriEndpoint = uriRepository.findByUriEndpoint(uri);
			if(byUriEndpoint!=null) {
				uriVo.setId(byUriEndpoint.getId());
				uriVo.setUriEndpoint(byUriEndpoint.getUriEndpoint());
				return uriVo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Uri saveUri(String uri) {
		Uri uriData = new Uri();
		try {
			uriData.setUriEndpoint(uri);
			uriData = uriRepository.save(uriData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return uriData;
		
	}

	@Override
	public RoleVo getRole(String role) {
		RoleVo roleVo = new RoleVo();
		try {
			Role roleDetail = roleRepository.findByName(role);
			if(roleDetail!=null) {
				roleVo.setId(roleDetail.getId());
				roleVo.setName(roleDetail.getName());
				return roleVo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Role saveRole(String role) {
		Role roleData = new Role();
		try {
			roleData.setName(role);
			roleData = roleRepository.save(roleData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roleData;
	}

}
