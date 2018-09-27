
 /**
 * itbooking系统平台<br/>
 * com.rumo.controller.role<br/>
 * RoleController.java<br/>
 * 创建人:mofeng <br/>
 * 时间：2018年9月24日-下午9:38:42 <br/>
 * 2018itbooking-版权所有<br/>
 */
package com.rumo.controller.role;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rumo.pojo.Params;
import com.rumo.pojo.Role;
import com.rumo.pojo.User;
import com.rumo.service.role.IRoleService;
import com.rumo.util.IpUtil;
import com.rumo.vo.RoleVo;
import com.rumo.vo.ServerResponse;
import com.rumo.vo.SessionKeyContansts;

/**
 * 
 * RoleController<br/>
 * 创建人:mofeng<br/>
 * 时间：2018年9月24日-下午9:38:42 <br/>
 * @version 1.0.0<br/>
 * 
 */
@Controller
@RequestMapping("/admin/role")
public class RoleController {
	
	@Autowired
	private IRoleService roleService;

	@RequestMapping("/{path}")
	public String rolepath(@PathVariable("path")String path) {
		return "/admin/role/"+path;
	}
	
	@RequestMapping("/admin-role")
	public String adminRrole(ModelMap modelMap) {
		ServerResponse response = roleService.findRoles(0, 10);
		//response.getData()是一个pageInfo对象，不是你的角色数据, response.getData().getList()
		modelMap.addAttribute("pageInfo", response.getData());
		return "/admin/role/admin-role";
	}
	
	/**
	 * todo:http://localhost:8082/admin/user/template/1/10
	 * 方法名：findUsers<br/>
	 * 创建人：mofeng <br/>
	 * 时间：2018年9月25日-下午9:27:38 <br/>
	 * 手机:1564545646464<br/>
	 * @param pageNo
	 * @param pageSize
	 * @param modelMap
	 * @return String<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@RequestMapping("/template")
	public String findRoles(Params params,ModelMap modelMap) {
		return "admin/role/template";
	}
	
	
	@ResponseBody
	@PostMapping("/save")
	public ServerResponse saveRole(RoleVo roleVo) {
		//保存用户
		return roleService.saveRole(roleVo);
	}
	
	
	@ResponseBody
	@PostMapping("/delete/{id}")
	public ServerResponse deleteRole(@PathVariable("id")Integer id) {
		//保存用户
		return roleService.deleteRole(id);
	}
	
}
