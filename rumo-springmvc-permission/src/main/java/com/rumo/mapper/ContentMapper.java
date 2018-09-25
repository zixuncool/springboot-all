package com.rumo.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.rumo.pojo.Params;
import com.rumo.pojo.Content;


public interface ContentMapper {
    
    List<Content> selectByPrimaryKeyAll(Params params);
}