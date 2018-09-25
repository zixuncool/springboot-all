package com.rumo.controller.permission;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rumo.core.ApplicationContextHelper;
import com.rumo.service.permission.IPermissionService;
import com.rumo.vo.ServerResponse;

@Controller
@RequestMapping("/admin/permission")
public class PermissionController {

	
	
	
	
	@ResponseBody
	@RequestMapping("/save")
	public ServerResponse save() {
		IPermissionService permissionService = ApplicationContextHelper.popBean(IPermissionService.class);
		return permissionService.save(null);
	}
	
	
	@ResponseBody
	@RequestMapping("/findp")
	public ServerResponse findPers() {
		IPermissionService permissionService = ApplicationContextHelper.popBean(IPermissionService.class);
		return permissionService.findRoleUserPersmission(1);
	}
	
	
	
}
