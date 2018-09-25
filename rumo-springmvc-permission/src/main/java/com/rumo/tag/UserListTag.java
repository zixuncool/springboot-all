package com.rumo.tag;



import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.github.pagehelper.PageInfo;
import com.rumo.core.ApplicationContextHelper;
import com.rumo.pojo.User;
import com.rumo.service.user.IUserService;

/**
 * 
 * @ClassName: HasUrlPermissionTag
 * @Description: 根据url判断权限标签
 * @author: mofeng
 * @date: 2016年12月21日上午11:15:32
 * 
 * 
 * doStartTag()方法的合理返回值为EVAL_BODY_INCLUDE和SKIP_BODY
----------返回值为EVAL_BODY_INCLUDE时，表明执行标签体中间的内容，--
----------返回值为SKIP_BODY时，表明不执行标签体中间的内容，会直接调到结束标签体

4）doAfterBody()方法的合理返回值为SKIP_BODY和EVAL_BODY_AGAIN
---------返回值为SKIP_BODY时，表示继续处理标签执行的下一步，
---------返回值为为EVAL_BODY_AGAIN时，表示会重复执行标签体中间的内容
 

5）doEndTag()的合理返回值为EVAL_PAGE和SKIP_PAGE
---------返回值为EVAL_PAGE时，表示标签结束后继续执行页面上的内容
---------返回值为为SKIP_PAGE时，表示不继续执行结束标签后的内容，



EVAL_BODY_INCLUDE：把Body读入存在的输出流中，doStartTag()函数可用
EVAL_PAGE：继续处理页面，doEndTag()函数可用
SKIP_BODY：忽略对Body的处理，doStartTag()和doAfterBody()函数可用
SKIP_PAGE：忽略对余下页面的处理，doEndTag()函数可用
EVAL_BODY_TAG：已经废止，由EVAL_BODY_BUFFERED取代
EVAL_BODY_BUFFERED：申请缓冲区，由setBodyContent()函数得到的BodyContent对象来处理tag的body，如果类实现了BodyTag，那么doStartTag()可用，否则非法
 * 
 */
public class UserListTag extends BodyTagSupport {

    private String var;//  acApplication/forMain.do
    
    private Iterator<User> iterator;
    private int index;
    private int count;
    

    @Override
    public int doStartTag() throws JspException { // 在标签开始处出发该方法
        /*HttpServletRequest request=(HttpServletRequest) pageContext.getRequest();
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
        IUserService userService = context.getBean(IUserService.class);*/
        IUserService userService =  ApplicationContextHelper.popBean(IUserService.class);
        if(var==null)var = "user";
        //获取session中存放的权限
        PageInfo<User> users =  userService.findUsers(0, 10);
        if(users.getList().size()>0) {
        	iterator = users.getList().iterator();
        	this.pageContext.setAttribute(var, iterator.next());
        	this.pageContext.setAttribute(var+"_size", users.getList().size());
        	this.pageContext.setAttribute(var+"_index",0);
        	this.pageContext.setAttribute(var+"_count",1);
            return BodyTagSupport.EVAL_BODY_INCLUDE;// 返回此则执行标签body中内容，SKIP_BODY则不执行
        } else {
            return BodyTagSupport.SKIP_BODY;
        }
    }
    
    
   

    @Override
	public int doAfterBody() throws JspException {
    	if(iterator.hasNext()) {
    		this.pageContext.setAttribute(var, iterator.next());
    		this.pageContext.setAttribute(var+"_index",++index);
        	this.pageContext.setAttribute(var+"_count",++count);
    		return BodyTagSupport.EVAL_BODY_AGAIN;
    	}
		return BodyTagSupport.SKIP_BODY;
	}



	@Override
    public int doEndTag() throws JspException {
		index = 0;
		count = 0;
        return BodyTagSupport.EVAL_PAGE;
    }


	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

}