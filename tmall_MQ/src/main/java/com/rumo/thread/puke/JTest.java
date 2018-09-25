package com.rumo.thread.puke;

import java.util.*;
public class JTest {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int numHands=4;
        int cardsPerHand = 12;
        String[] suit={"♣","♦","♠","♥"};
        String[] rank = {"A","1","2","3","4","5","6","7","8","9","10","J","Q","K"};
        List deck = new ArrayList();
        for(int i=0;i<suit.length;i++){
            for(int j=0;j<rank.length;j++){
                deck.add(suit[i]+rank[j]);
            }
        }
         
        Collections.shuffle(deck);
         
        for(int i=0;i<numHands;i++){
            List p = dealCard(deck,cardsPerHand);
            Collections.sort(p);
            System.out.println(p);
        }
         
    }
     
    public static List dealCard(List deck,int n){
        int deckSize = deck.size();
        List handView = deck.subList(deckSize-n,deckSize);
        List hand = new ArrayList(handView);
        handView.clear();
        return hand;
    }
 
}