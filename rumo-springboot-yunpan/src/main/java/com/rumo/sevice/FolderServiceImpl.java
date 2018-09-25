package com.rumo.sevice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rumo.mapper.IFolderMapper;
import com.rumo.pojo.Folder;
import com.rumo.vo.FolderVo;
import com.rumo.vo.ServerResponse2;


/**
 * 目录的service
 * @author Administrator
 *
 */
@Service
public class FolderServiceImpl implements IFolderService {

	
	@Autowired
	private IFolderMapper folderMapper;
	
	@Override
	@Transactional
	public ServerResponse2 saveFolder(FolderVo folderVo) {
		Folder folder = new Folder();
		BeanUtils.copyProperties(folderVo, folder);
		
		folder.setStatus(1);
		folder.setSort(0);
		int flag = folderMapper.saveFolder(folder);
		if(flag>0) {
			return ServerResponse2.createBySuccess(folder);
		}
		return ServerResponse2.createByError();
	}

	@Override
	public ServerResponse2 findFolders(Integer rootId,int pageNo,int pageSize) {
		//1:设置分页
		PageHelper.startPage(pageNo, pageSize);
		List<Folder> folders = folderMapper.findFolders(rootId);
		//设置分页
		PageInfo<Folder> pageInfo = new PageInfo<>(folders); 
		return ServerResponse2.createBySuccess(pageInfo);
	}
	
	
	
	// 获取标准JSON数据
    public  ServerResponse2 getTreeNodes() {
       //1：先把所有的根节点全部查找出来.
       List<Folder> folders = folderMapper.findFolders(0);
		
       //2：定义装在数据的容器
       List<Map<String, Object>> parentList = new ArrayList<>();
       
       for (int i = 0; i < folders.size(); i++) {
    	   Folder folder = folders.get(i);
    	   Map<String, Object> map = new HashMap<>();
    	   map.put("id", folder.getId());
    	   map.put("open", i==0);
    	   map.put("url", "http://www.baidu.com");
    	   map.put("target", "_blank");
    	   //map.put("checked", true);//选择复选框
		   map.put("name", folder.getName());
		   map.put("pid", folder.getParentId());
           parentList.add(map);
       }
       
       //递归去获取所有的子孙元素 ，parentList 整个tree的根，
       recursionChildren(parentList,folders);
       return ServerResponse2.createBySuccess(parentList);
    }

	
    public  void recursionChildren (List<Map<String, Object>> parentList, List<Folder> allList) {
    	
    	 for (Map<String, Object> parentMap : parentList) {//{c:2,f:3,g:4}
    		//检索获取每个元素的所有的子节点
		   List<Folder> cfolders = folderMapper.findFolders(Integer.parseInt(String.valueOf(parentMap.get("id")))); //2
		    //子元素中
		   List<Map<String, Object>> childrenList = new ArrayList<>();
		   for (Folder cfolder : cfolders) {
			   Map<String, Object> cmap = new HashMap<>();
			   cmap.put("id", cfolder.getId());
			   //cmap.put("checked", true);//选择复选框
			   cmap.put("name", cfolder.getName());
			   cmap.put("pid", cfolder.getParentId());
			   childrenList.add(cmap);
		   }
		   
		   if(childrenList!=null && childrenList.size()>0) {
			   //递归
			   recursionChildren(childrenList,allList);
			   //追加到容器中
			   parentMap.put("children",childrenList);
		   }
    	 }
    }

	@Override
	public ServerResponse2 deleteById(Integer id) {
		//int flag = folderMapper.deleteById(id);
		int flag = folderMapper.deleteById(id,0);
		if(flag>0) {
			return ServerResponse2.createBySuccess();
		}else {
			return ServerResponse2.createByError();
		}
	}

	@Override
	public ServerResponse2 updateFolder(FolderVo folderVo) {
		Folder folder = new Folder();
		//folder.setId(folderVo.getId());
		//folder.setName(folderVo.getName());
		BeanUtils.copyProperties(folderVo, folder);
		int flag = folderMapper.updateFolder(folder);
		if(flag>0) {
			return ServerResponse2.createBySuccess();
		}else {
			return ServerResponse2.createByError();
		}
	}
    
    
    
}
