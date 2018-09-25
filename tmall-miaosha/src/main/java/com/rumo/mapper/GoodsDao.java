package com.rumo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.rumo.bean.MiaoshaGoods;
import com.rumo.vo.GoodsVo;

@Mapper
public interface GoodsDao {
	
	@Select("select g.*,mg.stock_count, mg.start_date, mg.end_date,mg.miaosha_price from tb_miaosha_goods mg left join tb_goods g on mg.goods_id = g.id")
	public List<GoodsVo> listGoodsVo();

	@Select("select g.*,mg.stock_count, mg.start_date, mg.end_date,mg.miaosha_price from tb_miaosha_goods mg left join tb_goods g on mg.goods_id = g.id where g.id = #{goodsId}")
	public GoodsVo getGoodsVoByGoodsId(@Param("goodsId")long goodsId);

	@Update("update tb_miaosha_goods set stock_count = stock_count - 1 where goods_id = #{goodsId} and stock_count > 0")
	public int reduceStock(MiaoshaGoods g);

	@Update("update miaosha_goods set stock_count = #{stockCount} where goods_id = #{goodsId}")
	public int resetStock(MiaoshaGoods g);
}
