package com.rumo.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rumo.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);
    
    List<User> selectByPrimaryKeyAll();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User selectByPhone(@Param("telephone")String telephone);
}