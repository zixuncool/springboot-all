package com.rumo.tag;



import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.rumo.vo.SessionKeyContansts;

/**
 * 
 * int index = 0;
 * <rumo:permission code="s1001" link="/zixun/list">开始标签---doStartTag
 * 	标签体
 * </ruomo:permission> 结束标签 10
 * 
 * index
 *  <rumo:permission code="s1001" link="/zixun/list">开始标签---doStartTag
 * 	标签体
 * </ruomo:permission> 结束标签
 * 
 * @ClassName: HasUrlPermissionTag
 * @Description: 根据url判断权限标签
 * @author: mofeng
 * @date: 2016年12月21日上午11:15:32
 */
public class HasPermissionTag extends BodyTagSupport {

    private String url;// 权限链接
    private String code;//  权限编号
    
    @Override
    public int doStartTag() throws JspException { // 在标签开始处出发该方法
        
        HttpServletRequest request=(HttpServletRequest) pageContext.getRequest();
        //获取session中存放的所有权限 --jvm---redis进行存储
        List<Map<String, String>> permissions = (List<Map<String, String>>) request.getSession().getAttribute(SessionKeyContansts.SESSSION_KEY_ROLES_PERMISSIONS);
        //判断是否有权限访问
        if (isValidator(permissions)) {
            //允许访问标签body
            return BodyTagSupport.EVAL_BODY_INCLUDE;// 返回此则执行标签body中内容，SKIP_BODY则不执行
        } else {
            return BodyTagSupport.SKIP_BODY;//跳过标签体，进入到结束标签
        }
    }
    
    private boolean isValidator(List<Map<String, String>> permissions) {
    	/*//如果没有找到就false
    	boolean flag = false;
    	for (Map<String, String> map : permissions) {
    		//如果找到了就直接退出返回
			if((url!=null && map.get("url").equals(url)) || (code!=null && map.get("code").equals(code))) {
				flag = true;
				break;
			}
		}
    	return flag;*/
    	
    	return true;
    }
    
    
    
    
    

    @Override
    public int doEndTag() throws JspException {
        return BodyTagSupport.EVAL_PAGE;
    }
    

	

	public void setUrl(String url) {
		this.url = url;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	

}