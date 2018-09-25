package com.rumo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.rumo.pojo.Folder;

public interface IFolderMapper {
	
	//keyProperty 来自pojo  keyColumn来自表
	//Property都是写pojo的属性 , Column全部来自表的字段 
	@Insert("insert into rumo_folder(name,sort,parent_id,status) values (#{name},#{sort},#{parentId},#{status})")
	@SelectKey(statement="select max(id)+1 as id from rumo_folder",before=true,keyColumn="id",resultType=int.class, keyProperty="id")
	public int saveFolder(Folder folder);
	
	@Select("select id,name,create_time as createTime,sort,parent_id as parentId,status from rumo_folder where parent_id = #{rid} and status = 1 order by sort asc")
	public List<Folder> findFolders(@Param("rid")int rootId);
	
	@Select("select id,name,create_time as createTime,sort,parent_id as parentId,status from rumo_folder where status = 1")
	public List<Folder> findFoldersAll();
	
	//@Delete("delete from rumo_folder where id = #{id}") 删除当前元素,但是不包含子孙元素
	// 删除当前元素,并且不包含子孙元素
	//	把下面的函数在你的mysql客户端执行一下。
	// DROP FUNCTION  IF EXISTS getChildFolderNodes;
	//	CREATE FUNCTION getChildFolderNodes(rootId INT)
	//	RETURNS varchar(1000) READS SQL DATA
	//	BEGIN
	//	  /*定时临时变量开始接收*/
	//	  DECLARE sTemp VARCHAR(1000);
	//	  /*定时临时变量拼接的子节点的id*/
	//	  DECLARE sTempChd VARCHAR(1000);
	//	  /*给临时变量赋值*/
	//	  SET sTemp = '0';
	//	  SET sTempChd = cast(rootId as CHAR); 
	//	  WHILE sTempChd !=0  DO
	//	    SET sTemp = concat(sTemp,',',sTempChd);
	//	    SELECT group_concat(id) INTO sTempChd FROM rumo_folder where FIND_IN_SET(parent_id,sTempChd)>0;
	//	  END WHILE;
	//	  /*返回值*/
	//	  RETURN sTemp;
	//	END;
	//@Delete("DELETE FROM rumo_folder where FIND_IN_SET(id,getChildFolderNodes(#{id}))")
    //public int deleteById(@Param("id") Integer id);
	
	//建议大家修改状态+人工修复
	@Delete("update rumo_folder set status = #{status} where id = #{id}")
    public int deleteById(@Param("id") Integer id,@Param("status") Integer status);
    
	@Update("update rumo_folder set name = #{name} where id = #{id}")
    public int updateFolder(Folder folder);

}
