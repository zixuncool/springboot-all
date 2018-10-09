package com.rumo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.rumo.pojo.User;
import com.rumo.vo.UserVo;

/**
 * 
 * todo:用户模块
 * User<br/>
 * 创建人:中华墨风<br/>
 * 时间：2018年09月26日 21:51:32 <br/>
 * @version 1.0.0<br/>
 *
 */
public interface UserMapper {
	//添加
	public int saveUser(User user);
	//修改
	public int updateUser(User user);
	//删除
	public int deleteUserById(@Param("id")Long id);
	//查询单个
	public User getUserById(@Param("id")Long id);
	//查询所有
	public List<User> queryUserAll(UserVo userVo);
	//保存短信
	public int savePhone(@Param("telephone")String telephone,@Param("type")Integer type,@Param("code")Integer code);
  	//查询短信
	public Integer queryPhone(@Param("telephone")String telephone,@Param("type")Integer type);
	//统计用户信息
	public Map<String, Object> countUserInfo(@Param("userId")Long userId);
}