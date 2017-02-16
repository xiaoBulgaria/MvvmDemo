package com.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.smartcardio.Card;

public class MyClass {
    enum Suit {CLUB,DIAMOND,HEART,SPADE}
    enum Rank {ACE ,DEUCE,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,JACY,QUEEN,KING}


    static Collection<Suit> suits = Arrays.asList(Suit.values());
    static Collection<Rank> ranks = Arrays.asList(Rank.values());

    public static void main(String[] args) {
        sortPoker();
    }

    private static void sortPoker() {
        for(Suit suit : suits){
            for(Rank rank : ranks){
                System.out.print(suit + "---" + rank + "    ");
            }
        }
    }
}
