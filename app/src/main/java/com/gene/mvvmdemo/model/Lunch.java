package com.gene.mvvmdemo.model;

/**
 * Created by Administrator on 2016/11/1.
 */
public class Lunch {
    private int num;
    private float cast;
    private String address;
    private String type;


    public static  class Builder{
        private int num;
        private float cast;
        private String address;
        private String type;


           public Builder num(int mNum){
             num = mNum;
               return this;
           }

    }


}
