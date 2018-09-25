package com.rumo.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rumo.bean.User;
import com.rumo.exception.GlobalException;
import com.rumo.mapper.MiaoshaUserDao;
import com.rumo.redis.MiaoshaUserKey;
import com.rumo.redis.RedisService;
import com.rumo.util.CodeMsg;
import com.rumo.util.MD5Util;
import com.rumo.util.UUIDUtil;
import com.rumo.vo.LoginVo;

@Service
public class MiaoshaUserService {
	
	
	public static final String COOKI_NAME_TOKEN = "token";
	
	@Autowired
	MiaoshaUserDao miaoshaUserDao;
	
	@Autowired
	RedisService redisService;
	
	/**
	 * 获取用户信息
	 * @param id
	 * @return
	 */
	public User getById(Long id) {
		//取缓存
		User user = redisService.get(MiaoshaUserKey.getById, id, User.class);
		if(user!=null) {
			return user;
		}
		
		User user2 = miaoshaUserDao.getById(id);
		if(user2!=null) {
			redisService.set(MiaoshaUserKey.getById, id, user2);
		}
		return user2;
	}

	/**
	  * 延长session的有效期，因为如果登录了，根据cookieid一直更新redis里面的时间，防止在使用过程中过期.
	 * @param response
	 * @param token
	 * @return
	 */
	public User getByToken(HttpServletResponse response, String token) {
		if(StringUtils.isEmpty(token)) {
			return null;
		}
		User user = redisService.get(MiaoshaUserKey.token, token, User.class);
		//延长有效期
		if(user != null) {
			addCookie(response, token, user);
		}
		return user;
	}

	/**
	 * 修改用户密码
	 * @param token
	 * @param id
	 * @param formPass
	 * @return
	 */
	public boolean updatePassword(String token, long id, String formPass) {
		//取user
		User user = getById(id);
		if(user == null) {
			throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
		}
		//更新数据库
		User toBeUpdate = new User();
		toBeUpdate.setId(id);
		toBeUpdate.setPassword(MD5Util.formPassToDBPass(formPass, user.getSalt()));
		miaoshaUserDao.update(toBeUpdate);
		//处理缓存
		redisService.delete(MiaoshaUserKey.getById, ""+id);
		user.setPassword(toBeUpdate.getPassword());
		redisService.set(MiaoshaUserKey.token, token, user);
		return true;
	}
	

	/**
	 * 登录逻辑处理
	 * @param response
	 * @param loginVo
	 * @return
	 */
	public String login(HttpServletResponse response, LoginVo loginVo) {
		if(loginVo == null) {
			throw new GlobalException(CodeMsg.SERVER_ERROR);
		}
		String mobile = loginVo.getMobile();
		String formPass = loginVo.getPassword();
		//判断手机号是否存在
		User user = getById(Long.parseLong(mobile));
		if(user == null) {
			throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
		}
		//验证密码
		String dbPass = user.getPassword();
		String saltDB = user.getSalt();
		String calcPass = MD5Util.formPassToDBPass(formPass, saltDB);
		if(!calcPass.equals(dbPass)) {
			throw new GlobalException(CodeMsg.PASSWORD_ERROR);
		}
		//生成cookie
		String token = UUIDUtil.uuid();
		addCookie(response, token, user);
		return token;
	}
	
	private void addCookie(HttpServletResponse response, String token, User user) {
		redisService.set(MiaoshaUserKey.token, token, user);
		Cookie cookie = new Cookie(COOKI_NAME_TOKEN, token);
		cookie.setMaxAge(MiaoshaUserKey.token.expireSeconds());
		cookie.setPath("/");
		response.addCookie(cookie);
	}

}
