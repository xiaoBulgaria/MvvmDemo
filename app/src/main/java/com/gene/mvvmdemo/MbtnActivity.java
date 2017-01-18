package com.gene.mvvmdemo;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MbtnActivity extends BaseActivity implements OnLayoutChangeListener {

    private LinearLayout layout;
    private ScrollView namescroll;
    private String sName = "doubi";
    private final Handler mHandler = new Handler();
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mbtn);
        layout =  (LinearLayout) findViewById(R.id.layout);
        namescroll =  (ScrollView) findViewById(R.id.nameScroll);
        Log.d("...........",""+layout.getHeight());
        namescroll.addOnLayoutChangeListener(this);
        System.out.println("开始");
        for(int i = 0;i<10;i++){
            searchResultShow();
            System.out.println(i+"结束");
        }
        Log.d("...........",""+layout.getHeight());

        for(int i = 0;i<20;i++){
            searchResultShow();
            System.out.println(i+"结束");
        }
        System.out.println(namescroll.getScrollY());
//		System.out.println(namescroll.getChildAt(0).getMeasuredHeight());
//		System.out.println(layout.getMeasuredHeight());
        //	mHandler.post(ScrollRunnable);
        System.out.println("真正结束");
    }

    private void searchResultShow() {

        TextView textView = new TextView(MbtnActivity.this);
        textView.setText("自己动 ");
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        textView.setPadding(30, 15, 0, 15);
        textView.setTextSize(30);
        textView.setTextColor(Color.BLUE);
        //增加一个TextView到线性布局中
        layout.addView(textView, p);

        ImageView imageView = new ImageView(MbtnActivity.this);
        imageView.setImageResource(R.mipmap.ic_launcher);
        //增加一个ImageView到线性布局中
        layout.addView(imageView, p);
        //  namescroll.addOnLayoutChangeListener(this);

    }
    private Runnable mScrollToBottom = new Runnable()
    {
        @Override
        public void run()
        {
            int off =layout.getMeasuredHeight()-namescroll.getHeight() ;
            //         System.out.println(layout.getMeasuredHeight()+".........."+namescroll.getHeight() );
            if (off > 0)
            {
                namescroll.scrollBy(0, off);
                //	System.out.println("		 .......namescroll");
            }
        }
    };
    private Runnable ScrollRunnable= new Runnable() {
        @Override
        public void run() {
            int off = layout.getMeasuredHeight() - namescroll.getHeight();//判断高度

            System.out.println(layout.getMeasuredHeight()+".........."+namescroll.getHeight() );

            if (off > 0) {
                namescroll.scrollBy(0, 30);
                if (namescroll.getScrollY() == off) {
                    Thread.currentThread().interrupt();
                } else {
                    mHandler.postDelayed(this, 100);
                }
            }
        }
    };
    @Override
    public void onLayoutChange(View v, int left, int top, int right,
                               int bottom, int oldLeft, int oldTop, int oldRight,
                               int oldBottom) {
        mHandler.post(ScrollRunnable);
        //mHandler.post(mScrollToBottom);
        //namescroll.smoothScrollBy(0, bottom);
        System.out.println(bottom);

    }

}
