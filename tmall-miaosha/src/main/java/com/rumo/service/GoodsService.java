package com.rumo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rumo.bean.MiaoshaGoods;
import com.rumo.mapper.GoodsDao;
import com.rumo.vo.GoodsVo;

@Service
public class GoodsService {
	
	@Autowired
	GoodsDao goodsDao;
	
//	public List<GoodsVo> listGoodsVo(){
//		return goodsDao.listGoodsVo();
//	}
//
//	public GoodsVo getGoodsVoByGoodsId(long goodsId) {
//		return goodsDao.getGoodsVoByGoodsId(goodsId);
//	}
//
//	public void reduceStock(GoodsVo goods) {
//		MiaoshaGoods g = new MiaoshaGoods();
//		g.setGoodsId(goods.getId());
//		goodsDao.reduceStock(g);
//	}
	
	
	public List<GoodsVo> listGoodsVo(){
		return goodsDao.listGoodsVo();
	}

	public GoodsVo getGoodsVoByGoodsId(long goodsId) {
		return goodsDao.getGoodsVoByGoodsId(goodsId);
	}

	public boolean reduceStock(GoodsVo goods) {
		MiaoshaGoods g = new MiaoshaGoods();
		g.setGoodsId(goods.getId());
		int ret = goodsDao.reduceStock(g);
		return ret > 0;
	}

	public void resetStock(List<GoodsVo> goodsList) {
		for(GoodsVo goods : goodsList ) {
			MiaoshaGoods g = new MiaoshaGoods();
			g.setGoodsId(goods.getId());
			g.setStockCount(goods.getStockCount());
			goodsDao.resetStock(g);
		}
	}
	
	
	
}
