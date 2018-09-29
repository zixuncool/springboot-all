
 /**
 * itbooking系统平台<br/>
 * com.rumo<br/>
 * QrcodeController.java<br/>
 * 创建人:mofeng <br/>
 * 时间：2018年9月29日-下午8:08:54 <br/>
 * 2018itbooking-版权所有<br/>
 */
package com.rumo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * QrcodeController<br/>
 * 创建人:mofeng<br/>
 * 时间：2018年9月29日-下午8:08:54 <br/>
 * @version 1.0.0<br/>
 * 
 */
@Controller
public class IndexController {

	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	
}
