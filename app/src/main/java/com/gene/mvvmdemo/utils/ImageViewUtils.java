package com.gene.mvvmdemo.utils;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Administrator on 2016/9/29.
 */
public class ImageViewUtils {
    private static final Random sRandom = new Random();

    private static final String[] IMG_URLS= new String[]{
            "http://a.hiphotos.baidu.com/image/pic/item/5d6034a85edf8db1ab6b738c0d23dd54574e7494.jpg"
            ,"http://pic11.nipic.com/20101119/3320946_221711832717_2.jpg"
            ,"http://www.chinagirlol.cc/data/attachment/forum/201412/03/233758hw7o7h08kkozkcwi.jpg"
            ,"http://i2.cqnews.net/car/attachement/jpg/site82/20120817/5404a6b61e3c1197fb211d.jpg"
            ,"http://h.hiphotos.baidu.com/image/pic/item/f9dcd100baa1cd11dd1855cebd12c8fcc2ce2db5.jpg"
            ,"http://h.hiphotos.baidu.com/image/pic/item/c995d143ad4bd113a46490dc5eafa40f4afb05b6.jpg"
            ,"http://f.hiphotos.baidu.com/image/pic/item/0df3d7ca7bcb0a46dfd3acd76f63f6246a60af6e.jpg"
            ,"http://f.hiphotos.baidu.com/image/pic/item/060828381f30e924bd73bbdf48086e061c95f70c.jpg"};

    public static String nextImgUrl() {
        return IMG_URLS[sRandom.nextInt(IMG_URLS.length)];
    }
}
