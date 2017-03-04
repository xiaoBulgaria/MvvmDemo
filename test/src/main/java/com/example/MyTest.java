package com.example;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

public class MyTest {

    public static void main(String[] args) {
        HashMap hashMap = new HashMap();

        hashMap.put("1","one");
        hashMap.put("2","two");
        hashMap.put("3","three");
        hashMap.put("4","four");

        System.out.print("--------->"+hashMap.containsKey("2"));
        hashMap.remove("2");
        System.out.print("------------------>"+hashMap.containsKey("2"));

    }

}
