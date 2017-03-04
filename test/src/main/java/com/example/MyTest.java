package com.example;

import java.util.Arrays;
import java.util.Collection;

public class MyTest {

    static int[] b=new int[]{0,1,2,3,4};

    public static void main(String[] args) {
        chufa(1,0);
        shuzu(6);
    }

    private  static void chufa(int a ,int b) {
        System.out.print(a/b);
    }

    private  static void shuzu(int index) {
        System.out.print(b[index]);
    }

}
