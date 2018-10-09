package com.rumo.controller.comment;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rumo.vo.CommentVo;
import com.rumo.service.comment.ICommentService;
import com.rumo.vo.ServerResponse;

/**
 * 
 * todo:评论Controller控制器类
 * CommentController<br/>
 * 作者:中华墨风<br/>
 * 创建时间：2018年10月09日 22:55:35 <br/>
 * @version 1.0.0<br/>
 *
 */
@Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	private ICommentService commentService;
	
	@GetMapping("/")
	public String commentindex() {
		return "comment/index";
	}

	/**
	 * 方法名：commentdetail<br/>
	 * 创建人：mofeng <br/>
	 * 时间：2018年10月09日 22:55:35 <br/>
	 * 手机:15074816437<br/>
	 * @param id
	 * @param map
	 * @return String<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@GetMapping("/{id}")
	public String commentdetail(@PathVariable("id") Integer id,ModelMap map) {
		map.addAttribute("id", id);
		return "comment/detail";
	}
	
	
	/**
	 * 模板方法，提供给分页使用
	 * 方法名：template<br/>
	 * 创建人：mofeng <br/>
	 * 时间：2018年10月09日 22:55:35 <br/>
	 * 手机:15074816437<br/>
	 * @param params
	 * @param map
	 * @return String<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@PostMapping("/template")
	public String template(CommentVo commentVo,ModelMap map) {
		ServerResponse serverResponse = commentService.queryCommentAll(commentVo);
		map.addAttribute("pages", serverResponse.getData());
		return "comment/template";
	}
	
	
	/**
	 * 根据id查询信息
	 * 方法名：getComment<br/>
	 * 创建人：mofeng <br/>
	 * 时间：2018年10月09日 22:55:35 <br/>
	 * 手机:15074816437<br/>
	 * @param id
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@ResponseBody
	@GetMapping("/getComment/{id}")
	public ServerResponse getComment(@PathVariable("id") Integer id) {
		return commentService.getCommentById(id);
	}
	
	
	/**
	 * 保存
	 * 方法名：saveComment<br/>
	 * 创建人：mofeng <br/>
	 * 时间：2018年10月09日 22:55:35<br/>
	 * 手机:15074816437<br/>
	 * @param commentVo
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@ResponseBody
	@PostMapping("/saveComment")
	public ServerResponse saveComment(@Valid CommentVo commentVo) {
		return commentService.saveComment(commentVo);
	}
	
	/**
	 * 修改
	 * 方法名：updateComment<br/>
	 * 创建人：mofeng <br/>
	 * 时间：2018年10月09日 22:55:35 <br/>
	 * 手机:15074816437<br/>
	 * @param commentVo
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@ResponseBody
	@PostMapping("/updateComment")
	public ServerResponse updateComment(@Valid CommentVo commentVo) {
		return commentService.updateComment(commentVo);
	}
	
	
	/**
	 * 删除
	 * 方法名：deleteComment<br/>
	 * 创建人：mofeng <br/>
	 * 时间：2018年10月09日 22:55:35 <br/>
	 * 手机:15074816437<br/>
	 * @param id
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@ResponseBody
	@PostMapping("/deleteComment/{id}")
	public ServerResponse deleteComment(@PathVariable("id") Integer id) {
		return commentService.deleteCommentById(id);
	}
	
}
