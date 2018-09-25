package com.rumo.config;
 
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.stereotype.Component;

import freemarker.template.SimpleDate;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;
 
/**
 * Created by shiqm on 2017-05-03.
 */
@Component("dateFormat")
public class DateFormateMethodTag implements TemplateMethodModelEx {
    @Override
    public Object exec(List arguments) throws TemplateModelException {
        if (null != arguments && 2 == arguments.size()) {
        	SimpleDate date = (SimpleDate) arguments.get(0);
            String pattern = String.valueOf(arguments.get(1));
            String dateStr = new SimpleDateFormat(pattern).format(date.getAsDate());
            return dateStr;
        } else {
            return arguments.get(0);
        }
    }
}