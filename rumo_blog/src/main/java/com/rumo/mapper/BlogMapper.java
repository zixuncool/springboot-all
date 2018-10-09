package com.rumo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.rumo.pojo.Blog;
import com.rumo.vo.BlogVo;

/**
 * 
 * todo:内容博文模块
 * Blog<br/>
 * 创建人:中华墨风<br/>
 * 时间：2018年09月26日 21:46:48 <br/>
 * @version 1.0.0<br/>
 *
 */
public interface BlogMapper {
	//添加
	public int saveBlog(Blog blog);
	//修改
	public int updateBlog(Blog blog);
	//删除
	public int deleteBlogById(@Param("id")Integer id);
	//查询单个
	public Blog getBlogById(@Param("id")Integer id);
	//查询所有
	public List<Blog> queryBlogAll(BlogVo blogVo);
	
	
	
	//根据课程查询所有的文章
	public List<Blog> queryBlogByCourseId(@Param("courseId")Integer courseId);
	//关联查询所有分类用户相关信息
	public List<Map<String,Object>> queryBlogMapAll(BlogVo blogVo);
	//关联查询所有分类用户相关信息
	public List<Map<String,Object>> queryBlogGroupYear(BlogVo blogVo);
	//关联查询相关信息
	public Map<String,Object> selectBlogsById(@Param("id")Integer id);
	//统计文章的点击数，因为静态化的原因
	public int counthitsblog(@Param("blogId")Integer blogId);
	//更新用户点击数
	public int updateBlogHit(@Param("num")Integer num,@Param("id")Integer id);
	//查询用户预览的文章
	public List<Map<String,Object>> queryBlogHits(@Param("userId")Long userId);
	//保存用户预览的文章
	public int saveBlogHit(@Param("userId")Long userId,@Param("blogId")Integer blogId,@Param("type")Integer type);
	//查询用户是否已经预览该文章
	public int countBlogHit(@Param("userId")Long userId,@Param("blogId")Integer blogId,@Param("type")Integer type);
	
}