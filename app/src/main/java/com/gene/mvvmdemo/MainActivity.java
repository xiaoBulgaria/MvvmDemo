package com.gene.mvvmdemo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    Button btn_1,btn_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        TextView tv = (TextView) findViewById(R.id.tv_test);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        tv.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);

        btn_2 = (Button)findViewById(R.id.btn_2);
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WebActivity.enter(MainActivity.this);
            }
        });

    }

    public void openTv(View view){
       this.startActivity(new Intent(this,MtvActivity.class));
    }
    public void openBtn(View view){
        FeatureTagActivity.enter(this);
        //this.startActivity( new Intent(this,MbtnActivity.class));
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


