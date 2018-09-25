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


import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : com.rumo.tomcat.RumoRequest
 * @Description: todo
 * @Author:mofeng
 * @Date 2018/7/28 16:35
 * @Version 1.0
 */
public class RumoRequest {

    private String method;
    private String url;
    private InputStream in;
    private String params;
    private Map<String,String> map;
    public RumoRequest(InputStream in){
        this.in = in;
        try {
            //获取输入流中的数据
            BufferedInputStream bufferedInputStream = new BufferedInputStream(this.in);
            byte[] buffer = new byte[1024];
            StringBuilder stringBuffer = new StringBuilder();
            int len = 0;
            while((len = bufferedInputStream.read(buffer)) > 0){
                stringBuffer.append(new String(buffer,0,len));
                if(len<=0 || len <1024){//读完了就结束等待，防止程序的阻塞
                    break;
                }
            }
            //解析字符串
            String []  arr = stringBuffer.toString().split("\n");
            if(arr[0].indexOf("favicon.ico")==-1) {
                String[] larr = arr[0].split("\\s");
                this.method = larr[0].trim();
                String[] paramsarr = larr[1].trim().split("\\?");
                if (paramsarr.length == 1) {
                    this.url = paramsarr[0];
                } else {
                    this.url = paramsarr[0];
                    this.params = paramsarr[1];
                }


                this.map = getParameters( larr[1].trim());
                System.out.println("method是:" + this.method);
                System.out.println("请求地址是:" + this.url);
                System.out.println("请求参数是:" + this.params);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public String getMethod(){
        return method;
    }

    public String getUrl(){
        return url;
    }

    public String getParmeter(String key){
        return this.map.get(key);
    }

    /**
     * 解析出url参数中的键值对
     * 如 "index.jsp?Action=del&id=123"，解析出Action:del,id:123存入map中
     *
     * @param URL url地址
     * @return url请求参数部分
     */
    public static Map<String, String> getParameters(String URL) {
        Map<String, String> mapRequest = new HashMap<String, String>();
        String[] arrSplit = null;

        String strUrlParam = TruncateUrlPage(URL);
        if (strUrlParam == null) {
            return mapRequest;
        }
        //每个键值为一组 www.2cto.com
        arrSplit = strUrlParam.split("[&]");
        for (String strSplit : arrSplit) {
            String[] arrSplitEqual = null;
            arrSplitEqual = strSplit.split("[=]");

            //解析出键值
            if (arrSplitEqual.length > 1) {
                //正确解析
                mapRequest.put(arrSplitEqual[0], arrSplitEqual[1]);

            } else {
                if (arrSplitEqual[0] != "") {
                    //只有参数没有值，不加入
                    mapRequest.put(arrSplitEqual[0], "");
                }
            }
        }
        return mapRequest;
    }


    /**
     * 去掉url中的路径，留下请求参数部分
     *
     * @param strURL url地址
     * @return url请求参数部分
     */
    private static String TruncateUrlPage(String strURL) {
        String strAllParam = null;
        String[] arrSplit = null;

        strURL = strURL.trim();

        arrSplit = strURL.split("[?]");
        if (strURL.length() > 1) {
            if (arrSplit.length > 1) {
                if (arrSplit[1] != null) {
                    strAllParam = arrSplit[1];
                }
            }
        }

        return strAllParam;
    }

}
