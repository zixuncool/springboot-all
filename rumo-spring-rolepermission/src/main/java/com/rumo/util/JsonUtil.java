package com.rumo.util;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rumo.pojo.User;

/**
 *  by mofeng
 */
public class JsonUtil {

	public static final String STANDARD_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static ObjectMapper objectMapper = new ObjectMapper();
    private static Logger log = LoggerFactory.getLogger(JsonUtil.class);
    static{
    	
        //对象的所有字段全部列入
        objectMapper.setSerializationInclusion(Inclusion.ALWAYS);
        /*objectMapper.setSerializationInclusion(Inclusion.NON_NULL);*/

        //取消默认转换timestamps形式
        objectMapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS,false);

        //忽略空Bean转json的错误
        objectMapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS,false);

        //所有的日期格式都统一为以下的样式，即yyyy-MM-dd HH:mm:ss
        objectMapper.setDateFormat(new SimpleDateFormat(STANDARD_FORMAT));
        
        //json User id username  {id:1,username:"mofeng",phone:"xxxx"}
        //忽略 在json字符串中存在，但是在java对象中不存在对应属性的情况。防止错误
        objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,false);
    }

    /**
     * json对象转成字符串
     * @param obj
     * @return
     */
    public static <T> String obj2String(T obj){
        if(obj == null){
            return null;
        }
        try {
            return obj instanceof String ? (String)obj :  objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            log.warn("Parse Object to String error",e);
            return null;
        }
    }
    
    
    /**
     * json对象转成字符串
     * @param obj
     * @return
     */
    public static <T> String obj2StringPretty(T obj){
        if(obj == null){
            return null;
        }
        try {
            return obj instanceof String ? (String)obj :  objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (Exception e) {
            log.warn("Parse Object to String error",e);
            return null;
        }
    }

    
    /**
     * 	字符串转成对象
     * @param obj
     * @return
     */
    public static <T> T string2Obj(String str,Class<T> clazz){
        if(StringUtils.isEmpty(str) || clazz == null){
            return null;
        }

        try {
            return clazz.equals(String.class)? (T)str : objectMapper.readValue(str,clazz);
        } catch (Exception e) {
            log.warn("Parse String to Object error",e);
            return null;
        }
    }

    /**
     * 	字符串转成对象
     * @param obj
     * @return
     */
    public static <T> T string2Obj(String str, TypeReference<T> typeReference){
        if(StringUtils.isEmpty(str) || typeReference == null){
            return null;
        }
        try {
            return (T)(typeReference.getType().equals(String.class)? str : objectMapper.readValue(str,typeReference));
        } catch (Exception e) {
            log.warn("Parse String to Object error",e);
            return null;
        }
    }

    
    /**
     * 	字符串转成对象
     * @param obj
     * @return
     */
    public static <T> T string2Obj(String str,Class<?> collectionClass,Class<?>... elementClasses){
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(collectionClass,elementClasses);
        try {
            return objectMapper.readValue(str,javaType);
        } catch (Exception e) {
            log.warn("Parse String to Object error",e);
            return null;
        }
    }


    public static void main(String[] args) {

       /* User user = new User();
        user.setId(2);
        user.setUsername("mofeng@happymmall.com");
        user.setOperateTime(new Date());
        String userJsonPretty = JsonUtil.obj2StringPretty(user);
        log.info("userJson:{}",userJsonPretty);

        System.out.println("------------------------------");
        
        User user2 = JsonUtil.string2Obj(userJsonPretty, User.class);
        System.out.println(user2.getUsername());*/
    	
    	List<User> users = new ArrayList<>();
    	User user = new User();
        user.setId(2);
        user.setUsername("mofeng@happymmall.com");
        user.setOperateTime(new Date());
        users.add(user);
        user = new User();
        user.setId(3);
        user.setUsername("keke@happymmall.com");
        user.setOperateTime(new Date());
        users.add(user);
    	
        String userJsonPretty = JsonUtil.obj2String(users);
        System.out.println(userJsonPretty);
        
        
        
        System.out.println("=-=============================");
        List<User> users2 = JsonUtil.string2Obj(userJsonPretty, List.class,User.class);
        for (User user2 : users2) {
			System.out.println(user2.getUsername());
		}
        

    }


}