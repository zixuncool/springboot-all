package com.rumo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.rumo.pojo.Resource;

/**
 * 关于文件资源的处理
 * @author Administrator
 *
 */
public interface IResourceMapper {
	
	@Insert("INSERT INTO rumo_resources(name,seq,status,folder_id,filesize,ext,oldname,type,is_delete,user_id,path) values (#{name},#{seq},#{status},#{folderId},#{filesize},#{ext},#{oldname},#{type},#{isDelete},#{userId},#{path})")
	@SelectKey(statement="select max(id)+1 as id from rumo_folder",before=true,keyColumn="id",resultType=int.class, keyProperty="id")
	public int saveResource(Resource resource);
	
	@Select("select id,name,seq,status,folder_id as folderId,filesize,ext,oldname,type,is_delete as isDelete,user_id as userId,create_time as createTime,path from rumo_resources WHERE folder_id = #{fid} ORDER BY create_time desc")
	public List<Resource> findResources(@Param("fid")int folderId);
	
	@Select("select id,name,seq,status,folder_id as folderId,filesize,ext,oldname,type,is_delete as isDelete,user_id as userId,create_time as createTime,path from rumo_resources ORDER BY create_time desc")
	public List<Resource> findResourcesAll();
	
	//建议大家修改状态+人工修复
	@Delete("update rumo_resources set name = #{status} where id = #{id}")
    public int deleteById(@Param("id") Integer id,@Param("status") Integer status);
    
	@Update("update rumo_resources set name = #{name} where id = #{id}")
    public int updateResources(Resource resource);

}
