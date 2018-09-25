package com.rumo.controller.test;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rumo.core.BeanValidator;
import com.rumo.vo.ServerResponse;
import com.rumo.vo.TestVo;

@Controller
public class ValidatorController {

	
	
	//todo:http://localhost:8082/valid?id=5&msg=23&phone=1508768
	@ResponseBody
	@RequestMapping("/valid")
	public ServerResponse valid(TestVo testVo) {
		//进行数据验证
		BeanValidator.check(testVo);
		return ServerResponse.createBySuccess(testVo);
	}
	
	@ResponseBody
	@RequestMapping("/valid2")
	public ServerResponse valid2(@Valid TestVo testVo) {
		return ServerResponse.createBySuccess(testVo);
	}
	
}
