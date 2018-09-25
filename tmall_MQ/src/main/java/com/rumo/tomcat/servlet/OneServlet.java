package com.rumo.tomcat.servlet;
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

import com.rumo.tomcat.RumServlet;
import com.rumo.tomcat.RumoRequest;
import com.rumo.tomcat.RumoResponse;

import java.io.IOException;

/**
 * @ClassName : com.rumo.tomcat.servlet.OneServlet
 * @Description: todo
 * @Author:mofeng
 * @Date 2018/7/28 17:01
 * @Version 1.0
 */
public class OneServlet extends RumServlet {

    @Override
    public void doGet(RumoRequest request, RumoResponse response) {
        this.doPost(request,response);
    }

    @Override
    public void doPost(RumoRequest request, RumoResponse response) {
        System.out.println("请求进来了...OneServlet");
        try {
            String id = request.getParmeter("id");
            String name = request.getParmeter("name");
            response.write("One Servlet Hello World id= "+id+" name : "+ name);
        }catch (IOException ex){
           ex.printStackTrace();
        }
    }
}
