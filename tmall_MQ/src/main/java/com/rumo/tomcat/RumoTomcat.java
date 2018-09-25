package com.rumo.tomcat;
//                            _ooOoo_
//                           o8888888o
//                           88" . "88
//                           (| -_- |)
//                            O\ = /O
//                        ____/`---'\____
//                      .   ' \\| |// `.
//                       / \\||| : |||// \
//                     / _||||| -:- |||||- \
//                       | | \\\ - /// | |
//                     | \_| ''\---/'' | |
//                      \ .-\__ `-` ___/-. /
//                   ___`. .' /--.--\ `. . __
//                ."" '< `.___\_<|>_/___.' >'"".
//               | | : `- \`.;`\ _ /`;.`/ - ` : | |
//                 \ \ `-. \_ __\ /__ _/ .-` / /
//         ======`-.____`-.___\_____/___.-`____.-'======
//                            `=---='
//
//         .............................................
//                  佛祖镇楼                  BUG辟易
//          佛曰:
//                  写字楼里写字间，写字间里程序员；
//                  程序人员写程序，又拿程序换酒钱。
//                  酒醒只在网上坐，酒醉还来网下眠；
//                  酒醉酒醒日复日，网上网下年复年。
//                  但愿老死电脑间，不愿鞠躬老板前；
//                  奔驰宝马贵者趣，公交自行程序员。
//                  别人笑我忒疯癫，我笑自己命太贱；
//                  不见满街漂亮妹，哪个归得程序员？

import sun.reflect.generics.scope.Scope;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

/**
 * @ClassName : com.rumo.tomcat.RumoTomcat
 * @Description: todo
 * @Author:mofeng
 * @Date 2018/7/28 16:23
 * @Version 1.0
 */
public class RumoTomcat {

    private Properties properties = new Properties();
    private Map<Pattern,Class<?>> servletMapping = new HashMap<Pattern,Class<?>>();


    public void start(int port){
        try {
            //读取属性配置文件
            FileInputStream fileInputStream = new FileInputStream("D:\\projects\\tmall_MQ\\src\\main\\java\\com\\rumo\\tomcat\\web.properties");
            properties.load(fileInputStream);
            fileInputStream.close();

            //解析配置文件,将url和Servlet以键值对的方式存放
            for (Object key : properties.keySet()){
                String k = key.toString();
                if(k.endsWith(".url")){
                    String name = k.replaceAll("\\.url","");
                    Pattern pattern = Pattern.compile(properties.getProperty(k));
                    Class<?> clz = Class.forName(properties.getProperty(name+".className"));
                    servletMapping.put(pattern,clz);
                }
            }

            ServerSocket server = new ServerSocket(port);
            System.out.println("濡沫tomcat启动起来了...端口号是:"+port);
            ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
            while (true){
                final Socket socket = server.accept();
                newCachedThreadPool.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            OutputStream out = socket.getOutputStream();
                            InputStream in = socket.getInputStream();
                            RumoRequest request = new RumoRequest(in);
                            RumoResponse response = new RumoResponse(out);
                            //循环匹配
                            for (Map.Entry<Pattern,Class<?>> entry : servletMapping.entrySet()){
                                if(request.getUrl()!=null && entry.getKey().matcher(request.getUrl()).matches()){
                                    RumServlet servlet = (RumServlet)entry.getValue().newInstance();
                                    if("get".equalsIgnoreCase(request.getMethod())){
                                        servlet.doGet(request,response);
                                    }else{
                                        servlet.doPost(request,response);
                                    }
                                }
                            }
                            out.close();
                            socket.close();
                        }catch (Exception ex){
                            ex.printStackTrace();
                        }
                    }
                });
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args){
        new RumoTomcat().start(9090);
    }
}
