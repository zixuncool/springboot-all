package com.rumo.thread.puke;

import java.util.Arrays;
import java.util.Random;

public class PokerGame {

    //1.创建数组，用以存储扑克牌
    static String[] pokers = new String[54];
    
    public static void main(String[] args) {        
        //2.创建牌  所有的牌赋值到array数组中
        pokers = newPoker();
        //3.洗牌  这里的实参pokers是经过创建牌之后新生成的pokers
        String[] pokers2 = upsetPoker(pokers);
        //4.发牌　　　    
        sendPoker(pokers2);
}

    //创建牌的方法
    public static String[] newPoker() {
        //1.定义花色数组 4
        String[] colors = {"红桃","黑桃","梅花","方片"};
        //2.定义牌面数组 13
        String[] numbers = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        //3.定义王  2
        String[] kings = {"大王","小王"};
        
        //4.使用循环将牌存储到pokers数组
       
        int index = 0;
        for(int i = 0 ; i < numbers.length ; i ++) {
            for(int j = 0 ; j < colors.length ; j ++) {
                pokers[index ++] = colors[j] + numbers[i];
            }
        }
        
        //5.大小王拷贝入pokers数组
        System.arraycopy(kings, 0, pokers, index, 2);
        //6.输出牌
        System.out.println("现有一副扑克牌" + Arrays.toString(pokers) + "\n");
        
        return pokers;
    }
    
    //洗牌的方法
    public static String[] upsetPoker(String[] array) {
        //1.定义新的数组，用以存储洗好的牌
        String[] newpokers = new String[pokers.length];
        //2.定义数组，用以标识被随机取出的牌
        boolean[] mark = new boolean[pokers.length];
        
        //3.洗牌
        for(int i = 0 ; i < pokers.length ; i ++) {
            //a.创建随机数
            Random rd = new Random();
            //b.获取随机数的下标
            int index = rd.nextInt(pokers.length);
            //c.判断标识
            if(mark[index] == false) {
                //d.将未洗过的牌存储入newpokers
                newpokers[i] = pokers[index];
                //e.修改标识，被洗过的牌标记为true
            }else {
                i --; //该次取随机数取到的是洗过的牌，则重新再取一次
            }
        }
        
        //newpokers内的牌拷贝到数组pokers
        pokers = Arrays.copyOf(newpokers, newpokers.length);
        System.out.println("洗过的牌：" + Arrays.toString(newpokers)+"\n");
        return newpokers;
    }
    
    //发牌的方法
    public static void sendPoker(String[] array) {
        //1.定义玩家及底牌数组
        String[] one = new String[0];
        String[] two = new String[0];
        String[] three = new String[0];
        String[] underpoker = new String[3];
        
        //2.循环进行发牌
        for(int i = 0 ; i < pokers.length-3 ; i++) {
            if(i % 3 == 0) {
                one = Arrays.copyOf(one, one.length+1);
                one[one.length-1] = pokers[i];
            }else if(i % 3 == 1) {
                two = Arrays.copyOf(two, two.length+1);
                two[two.length-1] = pokers[i];
            }else if(i % 3 == 2) {
                three = Arrays.copyOf(three, three.length+1);
                three[three.length-1] = pokers[i];
            }
        }
        
        System.arraycopy(pokers, pokers.length-3, underpoker, 0, 3);
        Arrays.sort(one);
        Arrays.sort(two);
        Arrays.sort(three);
        System.out.println("玩家1:" + Arrays.toString(one));
        System.out.println("玩家2:" + Arrays.toString(two));
        System.out.println("玩家3:" + Arrays.toString(three));
        System.out.println("底牌:" + Arrays.toString(underpoker));
    }

}