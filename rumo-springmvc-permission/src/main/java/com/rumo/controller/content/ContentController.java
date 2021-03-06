package com.rumo.controller.content;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.rumo.core.ApplicationContextHelper;
import com.rumo.pojo.Params;
import com.rumo.service.content.IContentService;
import com.rumo.vo.ServerResponse;

@Controller
@RequestMapping("/admin/content")
public class ContentController {

	
	@Autowired
	private IContentService contentService;
	
	
	@RequestMapping("/{path}")
	public String contentpath(@PathVariable("path")String path) {
		return "/admin/content/"+path;
	}
	
	/**
	 * todo:http://localhost:8082/admin/content/template/1/10
	 * 方法名：findContents<br/>
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
	public String findContents(Params params,ModelMap modelMap) {
		ServerResponse serverResponse = contentService.findContents(params);
		//此serverResponse.getData()是一个@PageInfo<Content> getList对象
		modelMap.addAttribute("pages", serverResponse.getData());
		return "admin/content/template";
	}
	
	
}
