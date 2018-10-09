package com.rumo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rumo.vo.CommentVo;
import com.rumo.pojo.Comment;

/**
 * 
 * todo:评论
 * Comment<br/>
 * 创建人:中华墨风<br/>
 * 时间：2018年10月09日 22:55:35 <br/>
 * @version 1.0.0<br/>
 *
 */
public interface CommentMapper {
	//添加
	public int saveComment(Comment comment);
	//修改
	public int updateComment(Comment comment);
	//删除
	public int deleteCommentById(@Param("id")Integer id);
	//查询单个
	public Comment getCommentById(@Param("id")Integer id);
	//查询所有
	public List<Comment> queryCommentAll(CommentVo commentVo);
}