package com.rumo.config;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.view.freemarker.FreeMarkerView;


public class MyFreemarkerView extends FreeMarkerView {
 
    @Override
    protected void exposeHelpers(Map<String, Object> model, HttpServletRequest request) throws Exception {
        String base = RequestUtil.getBasePath(request);
        model.put("base", base);
        super.exposeHelpers(model, request);
    }
    
}
