package com.example;

/**
 * Created by Android on 2017/7/31.
 */

public class MySingletonTest {
    private volatile static MySingletonTest mySingletonTest;
    private MySingletonTest (){}
    public static MySingletonTest getMySingletonTest() {
        if (mySingletonTest == null){
            synchronized (MySingletonTest.class)
            {
              mySingletonTest = new MySingletonTest();
            }
        }
        return mySingletonTest;
    }
}
