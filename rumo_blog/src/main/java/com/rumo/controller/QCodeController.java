/**
 * tzdesk系统平台
 * moonvip
 * com.tz.web.pay
 * I.java
 * 创建人:xuchengfei 
 * 时间：2015年12月12日-下午2:26:11 
 * 2015濡沫教育公司-版权所有
 */
package com.rumo.controller;

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
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rumo.util.TmConstant;
import com.rumo.util.TmStringUtils;
import com.swetake.util.Qrcode;

/**
 * 
 * mvn install:install-file -Dfile="D:\Qrcode.jar" -DgroupId=com.rumo.qrcode -DartifactId=Qrcode -Dversion=1.0 -Dpackaging=jar
 * 创建人:xuchengfei 
 * 时间：2015年12月12日-下午2:26:11 
 * @version 1.0.0
 * 
 */
@Controller
@RequestMapping("/qrcode")
public class QCodeController  {
	
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
	@RequestMapping
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
			
			//设置内容
			String content = request.getParameter("k");
			//判断空
			if(TmStringUtils.isEmpty(content)){
				content = TmConstant.BASEPATH;
			}else{
				content  = TmConstant.BASEPATH+"/"+content;
			}
			
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
			
			//实例化image对象
			File pic = ResourceUtils.getFile("classpath:static/img/favicon.png");
			BufferedImage buffImg = ImageIO.read(pic);
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