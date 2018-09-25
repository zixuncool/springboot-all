package com.rumo.controller.stat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.rumo.core.ApplicationContextHelper;
import com.rumo.pojo.Params;
import com.rumo.service.stat.IStatService;
import com.rumo.vo.ServerResponse;

@Controller
@RequestMapping("/admin/stat")
public class StatController {

	
	@Autowired
	private IStatService statService;
	
	
	@RequestMapping("/{path}")
	public String statpath(@PathVariable("path")String path) {
		return "/admin/stat/"+path;
	}
	
	/**
	 * todo:http://localhost:8082/admin/stat/template/1/10
	 * 方法名：findStats<br/>
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
	public String findStats(Params params,ModelMap modelMap) {
		ServerResponse serverResponse = statService.findStats(params);
		//此serverResponse.getData()是一个@PageInfo<Stat> getList对象
		modelMap.addAttribute("pages", serverResponse.getData());
		return "admin/stat/template";
	}
	
	
}
