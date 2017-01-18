package com.gene.mvvmdemo;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.gene.mvvmdemo.swipe.SwipeBackActivity;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MbackActivity extends SwipeBackActivity {
    private com.gene.mvvmdemo.SwipeBackLayout mSwipeBackLayout;
    public String[] s = {"航哥", "小宇宇", "大据", "宝宝", "小哥", "火火", "粒粒", "肥皂", "小桑"};
    public  TextView myTextView;
    Looper looper = Looper.myLooper();
    MyHandler myHandler = new MyHandler(looper);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mback);
        mSwipeBackLayout = getSwipeBackLayout();
        mSwipeBackLayout.setFitsSystemWindows(true);
        mSwipeBackLayout.setEdgeTrackingEnabled(com.gene.mvvmdemo.SwipeBackLayout.EDGE_LEFT);

        myTextView = (TextView) findViewById(R.id.tv_1);

        findViewById(R.id.btn_1).setOnClickListener(new MyButtonListener());


        findViewById(R.id.btn_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView t = (TextView) findViewById(R.id.tv_2);
                Random r = new Random();
                int[] ret = new int[9];
                for (int i = 0; i < 8; i++) {
                    int temp = r.nextInt(33);
                    ret[i] = temp;
                }
                t.setText("数字是：" + ret[0] + "--"
                        + ret[1] + "--"
                        + ret[2] + "--"
                        + ret[3] + "--"
                        + ret[4] + "--"
                        + ret[5] + "--"
                        + ret[6] + "--"
                        + ret[7] + "--"
                        + ret[8]
                );
            }
        });
    }

    class MyButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
                    Runnable r = new Runnable() {
                        public void run() {
                            Message message = myHandler.obtainMessage();
                            message.arg1 = 1;
                            String[] result = doSort(s);
                            String[] ret = new String[9];
                            for (int i = 0; i < result.length; i++) {
                                ret[i] = result[i];
                                Log.e("TAG","--------->"+ret[i]);
                            }
                            message.obj = ret;
                            message.sendToTarget();
                        }
                    };
                    Thread thread = new Thread(r);
                    thread.start();
                }
    }

    public static String[] doSort(String[] sArr) {
        String[] tempArr = new String[sArr.length];
        Random random = new Random();

        int randomIndex = -1;
        for (int i = 0; i < tempArr.length; i++) {
            while (tempArr[i] == null) {
                randomIndex = random.nextInt(sArr.length);
                if (sArr[randomIndex] != null) {
                    tempArr[i] = sArr[randomIndex];
                    sArr[randomIndex] = null;
                }
            }
        }
        return tempArr;
    }

    class MyHandler extends Handler {
        public MyHandler() {}
        public MyHandler(Looper looper) {
            super(looper);
        }
        @Override
        public void handleMessage(Message msg) {
            if (msg.arg1 == 1) {
                String[] ret =(String[]) msg.obj;
                    myTextView.setText("人次顺序是：" + ret[0] + "--"
                            + ret[1] + "--"
                            + ret[2] + "--"
                            + ret[3] + "--"
                            + ret[4] + "--"
                            + ret[5] + "--"
                            + ret[6] + "--"
                            + ret[7] + "--"
                            + ret[8]
                );
            }
        }
    }
}
