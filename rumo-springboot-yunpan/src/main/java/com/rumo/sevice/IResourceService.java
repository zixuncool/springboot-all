package com.rumo.sevice;

import com.rumo.vo.ResourceVo;
import com.rumo.vo.ServerResponse2;

public interface IResourceService {
	
	/**
	 * 保存资源
	 * @param resource
	 * @return
	 */
	public ServerResponse2 saveResource(ResourceVo resourceVo);
	
	/**
	 * 根据目录查找资源
	 * @param folderId
	 * @return
	 */
	public ServerResponse2 findResources(int folderId,int pageNo,int pageSize);
	
	/**
	 * 查询所有资源
	 * @return
	 */
	public ServerResponse2 findResourcesAll(int pageNo,int pageSize);
	
	/**
	 * 根据id删除文件
	 * @param id
	 * @param status
	 * @return
	 */
    public ServerResponse2 deleteById( Integer id, Integer status);
    
    /**
     * 修改资源
     * @param resource
     * @return
     */
    public ServerResponse2 updateResources(ResourceVo resourceVo);
    
		
}

