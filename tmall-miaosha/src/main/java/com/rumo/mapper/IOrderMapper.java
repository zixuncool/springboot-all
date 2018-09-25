package com.rumo.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.rumo.bean.Order;

//@Mapper 如果你加了@MapperScan 可加可不加，
public interface IOrderMapper {

	@Select("select * from tb_order where order_id = #{id}")
	public Order getById(@Param("id")String id);
	
}
