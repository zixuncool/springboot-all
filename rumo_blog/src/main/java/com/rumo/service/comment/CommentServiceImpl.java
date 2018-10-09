package com.rumo.service.comment;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rumo.mapper.CommentMapper;
import com.rumo.vo.CommentVo;
import com.rumo.pojo.Comment;
import com.rumo.vo.ServerResponse;


/**
 * 
 * todo:评论Service实现类
 * CommentServiceImpl<br/>
 * 作者:中华墨风<br/>
 * 创建时间：2018年10月09日 22:55:35 <br/>
 * @version 1.0.0<br/>
 *
 */
@Service
public class CommentServiceImpl implements ICommentService  {

	@Autowired
	private CommentMapper commentMapper;
	
	public ServerResponse queryCommentAll(CommentVo commentVo){
		PageHelper.startPage(commentVo.getPageNo(), commentVo.getPageSize());
		List<Comment> comments = commentMapper.queryCommentAll(commentVo);
		PageInfo<Comment> pageInfo = new PageInfo<>(comments);
		return ServerResponse.createBySuccess(pageInfo);
	}
	
	@Override
	public ServerResponse saveComment(CommentVo commentVo) {
		Comment comment = new Comment();
		BeanUtils.copyProperties(commentVo, comment);
		int count = commentMapper.saveComment(comment);
		return count>0?ServerResponse.createBySuccess(comment):ServerResponse.createByError();
	}

	
	@Override
	public ServerResponse updateComment(CommentVo commentVo) {
		Comment comment = new Comment();
		BeanUtils.copyProperties(commentVo, comment);
		int count = commentMapper.updateComment(comment);
		return count>0?ServerResponse.createBySuccess(comment):ServerResponse.createByError();
	}

	
	@Override
	public ServerResponse deleteCommentById(Integer id) {
		int count = commentMapper.deleteCommentById(id);
		return count>0?ServerResponse.createBySuccess():ServerResponse.createByError();
	}

	
	@Override
	public ServerResponse getCommentById(Integer id) {
		Comment comment = commentMapper.getCommentById(id);
		return comment!=null?ServerResponse.createBySuccess(comment):ServerResponse.createByError();
	}
	
	
}
