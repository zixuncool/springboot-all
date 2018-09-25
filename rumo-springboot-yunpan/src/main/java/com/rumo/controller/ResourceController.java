package com.rumo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rumo.sevice.IResourceService;
import com.rumo.vo.ResourceVo;
import com.rumo.vo.ServerResponse2;

@Controller
public class ResourceController {
	
	//ctrl+shift+o--快速的把一个类中或者整个包所有的没有被引用的类全部删除

	@Autowired
	private IResourceService resourceService;
	
	@ResponseBody
	@PostMapping("/saveResource")
	public ServerResponse2 saveResource(ResourceVo resourceVo) {
		return resourceService.saveResource(resourceVo);
	}
	
	@RequestMapping("/findResource/{folderId}/{pageNo}/{pageSize}")
	public String findResource(
			@PathVariable("folderId")Integer folderId,
			@PathVariable("pageNo")Integer pageNo,
			@PathVariable("pageSize")Integer pageSize,
			ModelMap modelMap) {
		ServerResponse2 serverResponse2 = resourceService.findResources(folderId,pageNo,pageSize);
		modelMap.addAttribute("response", serverResponse2);
		return "resourceTemplate";
	}
	
	
	
	@RequestMapping("/findResourceall/{pageNo}/{pageSize}")
	public String findResourceall(
			@PathVariable("pageNo")Integer pageNo,
			@PathVariable("pageSize")Integer pageSize,
			ModelMap modelMap) {
		ServerResponse2 serverResponse2 = resourceService.findResourcesAll(pageNo,pageSize);
		modelMap.addAttribute("response", serverResponse2);
		return "resourceTemplate";
	}


}
