package com.rumo.service.comment;

import com.rumo.vo.ServerResponse;
import com.rumo.vo.CommentVo;

public interface ICommentService {
	
	/**
	 * 
	 *  保存评论
	 * 方法名：saveComment<br/>
	 * 创建人：中华墨风 <br/>
	 * 时间：2018年9月26日-下午7:11:44 <br/>
	 * 手机:1564545646464<br/>
	 * @param comment
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public ServerResponse saveComment(CommentVo commentVo);
	
	/**
	 * 
	 * (修改评论)<br/>
	 * 方法名：updateComment<br/>
	 * 创建人：中华墨风 <br/>
	 * 时间：2018年10月09日 22:55:35 <br/>
	 * 手机:1564545646464<br/>
	 * @param comment
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public ServerResponse updateComment(CommentVo commentVo);
	
	/**
	 * 
	 * (根据id删除评论)<br/>
	 * 方法名：deleteCommentById<br/>
	 * 创建人：中华墨风 <br/>
	 * 时间：2018年10月09日 22:55:35 <br/>
	 * 手机:1564545646464<br/>
	 * @param id
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public ServerResponse deleteCommentById(Integer id);
	
	/**
	 * 
	 * (根据id获取评论)<br/>
	 * 方法名：getCommentById<br/>
	 * 创建人：中华墨风 <br/>
	 * 时间：2018年10月09日 22:55:35 <br/>
	 * 手机:1564545646464<br/>
	 * @param id
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public ServerResponse getCommentById(Integer id);
	
	/**
	 * 
	 * (查询所有的评论)<br/>
	 * 方法名：queryCommentAll<br/>
	 * 创建人：中华墨风 <br/>
	 * 时间：2018年10月09日 22:55:35 <br/>
	 * 手机:1564545646464<br/>
	 * @param param
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public ServerResponse queryCommentAll(CommentVo commentVo);
}
