
 /**
 * itbooking系统平台<br/>
 * com.rumo<br/>
 * QrcodeController.java<br/>
 * 创建人:mofeng <br/>
 * 时间：2018年9月29日-下午8:08:54 <br/>
 * 2018itbooking-版权所有<br/>
 */
package com.rumo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.swetake.util.Qrcode;

/**
 * 
 * QrcodeController<br/>
 * 创建人:mofeng<br/>
 * 时间：2018年9月29日-下午8:08:54 <br/>
 * @version 1.0.0<br/>
 * 
 */
@Controller
public class QrcodeController {

	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	
	
	/**
	 * 生成微信支付码
	 * (这里用一句话描述这个方法的作用)<BR>
	 * 方法名：gainQrCode<BR>
	 * 创建人：小威 <BR>
	 * 时间：2015年10月19日-下午2:48:05 <BR>
	 * @return
	 * @throws Exception String<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	@ResponseBody
	@RequestMapping("/qrcode")
	public byte[] pay(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		try {
			//创建一个qrcode
			Qrcode qrcode = new Qrcode();
			//设置二维码的纠错级别 L(7%) M(15%) Q(25%) H(30%)
			qrcode.setQrcodeErrorCorrect('M');
			//设置二维码的编码模式 Binary
			qrcode.setQrcodeEncodeMode('B');
			//设置二维码的版本号 1-40  1:21*21   2:25*25  40：177*177
			qrcode.setQrcodeVersion(7);
			
			//获取图片缓存流对象
			int width = 140;
			int height = 140;
			BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
			
			//获取画笔
			Graphics2D gs = image.createGraphics();
			//设置背景颜色白色
			gs.setBackground(Color.WHITE);
			//设置画笔颜色
			gs.setColor(Color.BLACK);
			gs.clearRect(0,0, width, height);
			
			//设置内容 二维码的内容，文字，连接，图片
			//app 扫码登录-扫码器必须自己开发才有用，用微信QQ无用---http://app.com/?token=23sdkffksldfsdfsdf
			String content = request.getParameter("k");
			
			//获取内容的字节数组  设置编码格式
			byte[] contentBytes = content.getBytes("utf-8");
			
			//设置偏移量 
			int pixoff = 2;
			//绘制二维码
			if(contentBytes.length>0 && contentBytes.length<150){
				boolean[][] code = qrcode.calQrcode(contentBytes);
				for(int i=0;i<code.length;i++){
					for(int j=0;j<code.length;j++){
						if(code[j][i]){
							gs.fillRect(j*3+pixoff,i*3+pixoff, 3, 3);
						}
					}
				}	
			}
			
			//实例化image对象，服务器目录 30*30
			String realPath = request.getServletContext().getRealPath("/");
			String pic = "D:\\location.png";
			//String pic = realPath+"\\location.png";
			BufferedImage buffImg = ImageIO.read(new File(pic));
			//在二维码里面插入图片
			gs.drawImage(buffImg,55,55, 30, 30, null);
			//释放资源
			gs.dispose();
			
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			ImageOutputStream imageOut = ImageIO.createImageOutputStream(output);
	 		ImageIO.write(image, "png", imageOut);
			imageOut.close();
			ByteArrayInputStream input = new ByteArrayInputStream(
					output.toByteArray());
			return FileCopyUtils.copyToByteArray(input);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
