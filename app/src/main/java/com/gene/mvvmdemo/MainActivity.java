package com.gene.mvvmdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

}


