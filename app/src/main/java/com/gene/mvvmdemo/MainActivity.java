package com.gene.mvvmdemo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        TextView tv = (TextView) findViewById(R.id.tv_test);
        tv.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
    }

    public void openTv(View view){
        this.startActivity(new Intent(this,MtvActivity.class));
    }
    public void openBtn(View view){
        this.startActivity( new Intent(this,MbtnActivity.class));
    }
    public void openSetBackground(View view){
        this.startActivity(new Intent(this,MbackActivity.class));
    }
    public void openImageView(View view){
        this.startActivity(new Intent(this,MimageActivity.class));
    }
    public void openListview(View view){
        this.startActivity(new Intent(this,MlistviewActivity.class));
    }

}


