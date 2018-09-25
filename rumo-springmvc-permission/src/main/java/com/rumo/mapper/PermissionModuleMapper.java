package com.rumo.mapper;

import com.rumo.pojo.PermissionModule;

public interface PermissionModuleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PermissionModule record);

    int insertSelective(PermissionModule record);

    PermissionModule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PermissionModule record);

    int updateByPrimaryKey(PermissionModule record);
}