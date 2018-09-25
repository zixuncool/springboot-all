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

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @ClassName : com.rumo.tomcat.RumoResponse
 * @Description: todo
 * @Author:mofeng
 * @Date 2018/7/28 16:34
 * @Version 1.0
 */
public class RumoResponse {

    private OutputStream out ;

    public RumoResponse(OutputStream out){
        this.out = out;
    }

    public void write(String html) throws IOException {
           //拼装http响应的数据形式
           html = "http/1.1 200 ok \n\n "+html;
           BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(out);
           bufferedOutputStream.write(html.getBytes());
           bufferedOutputStream.close();
    }
}
