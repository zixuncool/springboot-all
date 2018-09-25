package com.rumo.tag;
//Foreach自定义标签

//Connection类族：  <sky:forEach var="item" items="${list}">${item}</sky:forEach>   <sky:forEach var="item" items="${set}">${item}</sky:forEach>
//Map类族：<sky:forEach var="en" items="map">${en.key} ----- ${en.value}</sky:forEach>

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ForEachTag extends SimpleTagSupport {

	/* 用一个Collection类来进行转换 */
	private Collection coll;

	private Object items;
	private String var;

	public void setItems(Object items) {
		/* 设置coll的值：当为Collection类族时直接转换，否则保存Set<Entry<K,V>>形式的Connection */
		if (items instanceof Collection) {
			coll = (Collection) items;
		} else if (items instanceof Map) {
			Map map = (Map) items;
			coll = map.entrySet();
		}
	}

	public void setVar(String var) {
		this.var = var;
	}

	@Override
    public void doTag() throws JspException, IOException {
        for (Iterator it = coll.iterator(); it.hasNext(); ) {
            //得到单个对象
            Object obj = (Object) it.next();
            
            //将单个对象放入域对象中
            PageContext pageContext = (PageContext) this.getJspContext();
            pageContext.getRequest().setAttribute(this.var, obj);
            
            //将标签封装的表达式输出到页面中
            this.getJspBody().invoke(null);
        }
    }
	
}