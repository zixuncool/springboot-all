package com.rumo.sevice;

import com.rumo.vo.FolderVo;
import com.rumo.vo.ServerResponse2;

public interface IFolderService {

	/**
	 *  保存目录
	 * @param folder
	 * @return
	 */
	public ServerResponse2 saveFolder(FolderVo folderVo);
	
	/**
	 * 查询目录
	 * @return
	 */
	public ServerResponse2 findFolders(Integer rootId,int pageNo,int pageSize);
	
	

	// 获取标准JSON数据
    public  ServerResponse2 getTreeNodes();
    
    
    
    /**
     * 根据id删除目录元素
     * @param id
     * @return
     */
    public ServerResponse2 deleteById(Integer id);
    
    /**
     * 修改元素
     * @param folder
     * @return
     */
    public ServerResponse2 updateFolder(FolderVo foldervo);
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
		
}

