package com.rumo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rumo.sevice.IFolderService;
import com.rumo.vo.FolderVo;
import com.rumo.vo.ServerResponse2;

@RestController
public class FolderController {

	@Autowired
	private IFolderService folderService;
	
	@RequestMapping(value="/findFolders")
	public ServerResponse2 findFolders(@RequestParam(value="rootId",defaultValue="1",required=false)Integer rootId,
			@RequestParam(value="pageNo",defaultValue="0",required=false)Integer pageNo,
			@RequestParam(value="pageSize",defaultValue="10",required=false)Integer pageSize) {
		return folderService.findFolders(rootId, pageNo, pageSize);
	}
	
	
	@PostMapping(value="/saveFolder")
	public ServerResponse2 saveFolder(FolderVo folderVo) {
		return folderService.saveFolder(folderVo);
	}
	
	
	@GetMapping(value="/getNodes")
	public ServerResponse2 findFolders(){
		return folderService.getTreeNodes();
	};
	
	
	@GetMapping(value="/update")
	public ServerResponse2 update(FolderVo folderVo){
		return folderService.updateFolder(folderVo);
	};
	
	@GetMapping(value="/delete/{id}")
	public ServerResponse2 delete(@PathVariable("id")Integer id){
		return folderService.deleteById(id);
	}
}
