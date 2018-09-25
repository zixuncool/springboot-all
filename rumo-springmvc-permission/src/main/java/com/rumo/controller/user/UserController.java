package com.rumo.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rumo.core.ApplicationContextHelper;
import com.rumo.pojo.Params;
import com.rumo.service.user.IUserService;
import com.rumo.vo.ServerResponse;

@Controller
@RequestMapping("/admin/user")
public class UserController {

	
	/*@Autowired
	private IUserService userService;*/
	
	
	@RequestMapping("/{path}")
	public String userpath(@PathVariable("path")String path) {
		return "/admin/user/"+path;
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
	public String findUsers(Params params,ModelMap modelMap) {
		IUserService userService = ApplicationContextHelper.popBean(IUserService.class);
		ServerResponse serverResponse = userService.findUsers(params);
		//此serverResponse.getData()是一个@PageInfo<User> getList对象
		modelMap.addAttribute("pages", serverResponse.getData());
		return "admin/members/template";
		
	}
	
	
}
