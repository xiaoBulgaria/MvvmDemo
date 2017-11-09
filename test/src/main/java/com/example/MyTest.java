package com.example;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

import javax.xml.crypto.Data;

public class MyTest {

    public static void main(String[] args) {
       /* HashMap hashMap = new HashMap();

        hashMap.put("1","one");
        hashMap.put("2","two");
        hashMap.put("3","three");
        hashMap.put("4","four");

        System.out.print("--------->"+hashMap.containsKey("2"));
        hashMap.remove("2");
        System.out.print("------------------>"+hashMap.containsKey("2"));*/
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmssSSS"); //精确到毫秒
        System.out.print("------------------>"+ fmt.format(1502337929556L));

    }

}
