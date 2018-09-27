package com.rumo.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.Constants;
import com.rumo.params.UserVo;
import com.rumo.pojo.User;
import com.rumo.service.permission.IPermissionService;
import com.rumo.service.role.IRoleService;
import com.rumo.service.user.IUserService;
import com.rumo.vo.RequestThrealLocalUtil;
import com.rumo.vo.ServerResponse;
import com.rumo.vo.SessionKeyContansts;

@Controller
public class LoginController {

	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private IPermissionService permissionService;
	
	
	@RequestMapping("/login")
	public String tologin(HttpSession session) {
		User user = (User) session.getAttribute(SessionKeyContansts.SESSSION_KEY);
    	if(user!=null) {
    		return "redirect:/admin/index";
    	}
		return "login";
	}
	
	

	@ResponseBody
	@RequestMapping("/logined")
	public ServerResponse logined(@Valid UserVo userVo,HttpSession session) {
		
		String code = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		if(code!=null && !code.equalsIgnoreCase(userVo.getCode())) {
			return ServerResponse.createByValidatorError("code","验证码输入有误!!!");
		}
		
		ServerResponse response = userService.login(userVo);
		User user =  (User) response.getData();
		//把用户放入到session中
		session.setAttribute(SessionKeyContansts.SESSSION_KEY, user);
		
		//查询用户对应的角色
		ServerResponse response2 = roleService.findRoleByUserId(user.getId());
		session.setAttribute(SessionKeyContansts.SESSSION_KEY_ROLES, response2.getData());
		//查询用户对应角色对应的权限
		ServerResponse response3 =  permissionService.findRoleUserPersmission(user.getId());
		session.setAttribute(SessionKeyContansts.SESSSION_KEY_ROLES_PERMISSIONS, response3.getData());
		return response;
	}
	
	/**
	 * 
	 * 注销
	 * 方法名：logout<br/>
	 * 创建人：mofeng <br/>
	 * 时间：2018年9月20日-下午3:56:33 <br/>
	 * 手机:1564545646464<br/>
	 * @param session
	 * @return String<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login";
	}
	
}
