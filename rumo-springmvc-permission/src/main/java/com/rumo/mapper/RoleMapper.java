package com.rumo.mapper;

import java.util.List;

import com.rumo.pojo.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);
    
    List<Role> selectRoles();

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}