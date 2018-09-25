package com.rumo.sevice;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rumo.mapper.IResourceMapper;
import com.rumo.pojo.Resource;
import com.rumo.vo.ResourceVo;
import com.rumo.vo.ServerResponse2;


/**
 * 目录的service
 * @author Administrator
 *
 */
@Service
public class ResourceServiceImpl implements IResourceService {

	
	@Autowired
	private IResourceMapper resourceMapper;

	@Override
	public ServerResponse2 saveResource(ResourceVo resourceVo) {
		Resource resource = new Resource();
		BeanUtils.copyProperties(resourceVo, resource);
		//对列不一致的，重新复制
		resource.setName(resourceVo.getNewname());
		resource.setFilesize(resourceVo.getSize());
		resource.setType(1);
		resource.setStatus(1);
		resource.setUserId(1);
		resource.setIsDelete(0);
		resource.setSeq(0);
		int flag = resourceMapper.saveResource(resource);
		return  flag > 0 ? ServerResponse2.createBySuccess(resource) : ServerResponse2.createByError();
	}

	@Override
	public ServerResponse2 findResources(int folderId,int pageNo,int pageSize) {
		//1:设置分页参数，此代码一定要放在查询之前，否则无效.原理mybatis的插件---jdk动态代理模式
		PageHelper.startPage(pageNo, pageSize);
		//2:查询方法
		List<Resource> resources = resourceMapper.findResources(folderId);
		//把查询的结果和总数用PageInfo包裹一起带出去
		PageInfo<Resource> pageInfo = new PageInfo<Resource>(resources);
		return ServerResponse2.createBySuccess(pageInfo);
	}

	@Override
	public ServerResponse2 findResourcesAll(int pageNo,int pageSize) {
		//1:设置分页参数，此代码一定要放在查询之前，否则无效.原理mybatis的插件---jdk动态代理模式
		PageHelper.startPage(pageNo, pageSize);
		//2:查询方法
		List<Resource> resources = resourceMapper.findResourcesAll();
		//把查询的结果和总数用PageInfo包裹一起带出去
		PageInfo<Resource> pageInfo = new PageInfo<Resource>(resources);
		return ServerResponse2.createBySuccess(pageInfo);
	}

	@Override
	public ServerResponse2 deleteById(Integer id, Integer status) {
		return null;
	}

	@Override
	public ServerResponse2 updateResources(ResourceVo resourceVo) {
		return null;
	}
	
    
}
