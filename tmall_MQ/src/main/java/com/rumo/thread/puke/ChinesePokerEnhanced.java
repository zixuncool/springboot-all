package com.rumo.thread.puke;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *加强版的斗地主  EnhancedVersion
 *在version1.0的基础上加入扑克排序.
 * @author 虎虎
 * @version 2.0
 */
public class ChinesePokerEnhanced {

    public static void main(String[] args) {
        //0-53代表每个对应的扑克
        Map<Integer, String> map = new HashMap<Integer,String>();
        List<String> list = new ArrayList<String>();
        String[] color = {"♥","♠","♣","◆"};
        String[] num = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        for(String str:num) {
            for(String str1:color) {
                String poker = str1.concat(str);
                list.add(poker);
            }
        }
        list.add("♀");
        list.add("♂");
        for(int i=0;i<54;i++) {
                map.put(i, list.get(i));
            }
        Set<Integer> keyset = map.keySet();
        List<Integer> list1 = new ArrayList<Integer>();
        for(Integer count:keyset){
            list1.add(count);
            }
        //洗牌三次
        Collections.shuffle(list1);
        Collections.shuffle(list1);
        Collections.shuffle(list1);

        Set<Integer> player01 = new TreeSet<Integer>();
        Set<Integer> player02 = new TreeSet<Integer>();
        Set<Integer> player03 = new TreeSet<Integer>();
        Set<Integer> dipai = new TreeSet<Integer>();
        //发牌
        for(int i=0;i<list1.size();i++) {
            if(i<51&&i%3 == 0) {
                player01.add(list1.get(i));
            }
            if(i<51&&i%3 == 1) {
                player02.add(list1.get(i));
            }
            if(i<51&&i%3 == 2) {
                player03.add(list1.get(i));
            }if(i>=51)
                dipai.add(list1.get(i));


        }
        //玩家一的牌
        System.out.println("玩家一：");
        for(Integer i:player01) {
            System.out.print(map.get(i)+" ");
        }
        System.out.println("\n玩家二：");
        //玩家二的牌
        for(Integer i:player02) {
            System.out.print(map.get(i)+ " ");
        }

        System.out.println("\n玩家三：");
        //玩家三的牌
        for(Integer i:player03) {
            System.out.print(map.get(i)+ " ");
        }
        System.out.println("\n底牌：");
        //玩家一的牌
        for(Integer i:dipai) {
            System.out.print(map.get(i)+ " ");
        }
    }
}