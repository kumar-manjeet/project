package com.tms.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.tms.models.Role;
import com.tms.models.Uri;
import com.tms.models.reponse.UriResponseDto;
import com.tms.models.request.SaveRolePermissonRequestDto;
import com.tms.services.PermissionService;
import com.tms.vo.RoleVo;
import com.tms.vo.UriVo;

@Controller
public class PermissionController {

	@Autowired
	private PermissionService permissionService;
	
	@GetMapping("/assignPermission")
	public String assignPermission(Model model) {
		List<RoleVo> roles = new ArrayList<>();
		RoleVo roleVo = new RoleVo();
		try {
			roles = permissionService.getAllRoles();
			model.addAttribute("roles", roles);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("roleVo", roleVo);
		model.addAttribute("content", "assignPermission");
		return "home";
	}
	
	@PostMapping("/uriPermissionList")
	public String getAllUris(@RequestParam Long roleId, Model model) {
		try {
			List<UriResponseDto> rolePermssionOnUriByRoleId = permissionService.getRolePermssionOnUriByRoleId(roleId);
			RoleVo roleVo = permissionService.getRoleById(roleId);
			List<RoleVo> roles = permissionService.getAllRoles();
			model.addAttribute("roleVo", roleVo);
			model.addAttribute("roles", roles);
			model.addAttribute("rolePermssionOnUriByRoleId", rolePermssionOnUriByRoleId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("content", "assignPermission");
		return "home";
	}
	
	@PostMapping("/saveRolePermisson")
	public String saveRolePermisson(@ModelAttribute SaveRolePermissonRequestDto request, Model model) {
		try {
			Boolean saveRolePermisson = permissionService.saveRolePermisson(request);
			if(saveRolePermisson !=null && saveRolePermisson == true) {
				model.addAttribute("msg", "Permission Assigned");
			}
			else {
				model.addAttribute("msg", "Permission Not Assigned, Something went wrong !!");
			}
			List<UriResponseDto> rolePermssionOnUriByRoleId = permissionService.getRolePermssionOnUriByRoleId(request.getRoleId());
			RoleVo roleVo = permissionService.getRoleById(request.getRoleId());
			List<RoleVo> roles = permissionService.getAllRoles();
			model.addAttribute("roleVo", roleVo);
			model.addAttribute("roles", roles);
			model.addAttribute("rolePermssionOnUriByRoleId", rolePermssionOnUriByRoleId);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "Permission Not Assigned, Something went wrong !!");
		}
		model.addAttribute("content", "assignPermission");
		return "home";
	}
	
	@GetMapping("/getUri")
	public String getUri(Model model) {
		try {
			List<UriVo> allUri = permissionService.getAllUri();
			model.addAttribute("uris", allUri);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("content", "uriDetails");
		return "home";
	}
	
	@PostMapping("/saveUri")
	public String saveUri(@RequestParam String uri, Model model) {
		try {
			UriVo uriVo = permissionService.getUri(uri);
			if(uriVo == null) {
				Uri saveUri = permissionService.saveUri(uri);
				if(saveUri.getId() != null) {
					model.addAttribute("msg", "Uri saved Successfully.");
				}else {
					model.addAttribute("msg", "Uri not saved, Something went wrong!!");
				}
			}else {
				model.addAttribute("msg", "Uri already present !!");
			}
			List<UriVo> allUri = permissionService.getAllUri();
			model.addAttribute("uris", allUri);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "Something went wrong !!");
		}
		model.addAttribute("content", "uriDetails");
		return "home";
	}
	
	@GetMapping("/getRole")
	public String getRole(Model model) {
		try {
			List<RoleVo> allRoles = permissionService.getAllRoles();
			model.addAttribute("roles", allRoles);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("content", "roleDetails");
		return "home";
	}
	
	@PostMapping("/saveRole")
	public String saveRole(@RequestParam String role, Model model) {
		try {
			RoleVo roleVo = permissionService.getRole(role);
			if(roleVo == null) {
				Role saveRole = permissionService.saveRole(role);
				if(saveRole.getId() != null) {
					model.addAttribute("msg", "Role saved Successfully.");
				}else {
					model.addAttribute("msg", "Role not saved, Something went wrong!!");
				}
			}else {
				model.addAttribute("msg", "Role already present !!");
			}
			List<RoleVo> allRoles = permissionService.getAllRoles();
			model.addAttribute("roles", allRoles);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "Something went wrong !!");
		}
		model.addAttribute("content", "roleDetails");
		return "home";
	}
	
}
