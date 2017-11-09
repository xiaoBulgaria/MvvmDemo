package com.gene.android.arrlib;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button backl;

    public static void enter(Context context){
        Intent i = new Intent(context,MainActivity.class);
        context.startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        backl =(Button) findViewById(R.id.btn);
        backl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back ();
            }
        });
    }


    public  void back (){
        MainActivity.this.finish();
    }
}
