package com.gene.mvvmdemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;

import com.gene.mvvmdemo.views.ButtonFeatureTagSelect;

import java.util.ArrayList;
import java.util.List;

public class FeatureTagActivity extends BaseActivity implements View.OnClickListener {
    private EditText etTag;
    private Button btnAdd;
    private GridLayout gridLayout;

    public static void enter(Context context){
        Intent intent = new Intent(context,FeatureTagActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feature_tag);
        initView();
    }

    private void initView() {
        etTag = (EditText) findViewById(R.id.et_tag);
        btnAdd = (Button) findViewById(R.id.btn_add);
        gridLayout = (GridLayout) findViewById(R.id.gl_layout);

        btnAdd.setOnClickListener(this);

    }

    public void addView(){
        if(etTag.getText().toString().isEmpty())
            return;
        String tag = etTag.getText().toString();
        etTag.setText("");
        final ButtonFeatureTagSelect bfts = new ButtonFeatureTagSelect(this);

        bfts.setFeatureTag(tag);
        bfts.setTag(tag);
        gridLayout.addView(bfts);
        gridLayout.postInvalidate();

        bfts.setOnDeleteListener(new ButtonFeatureTagSelect.OnDeleteListener() {
            @Override
            public void onDeletePressed(View view) {
                gridLayout.removeView(bfts);
                Log.e("TAG","-------------------"+bfts.getTag());
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_add:
                addView();
                break;
        }
    }
}
