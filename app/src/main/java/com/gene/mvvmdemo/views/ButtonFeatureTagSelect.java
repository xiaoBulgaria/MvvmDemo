package com.gene.mvvmdemo.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.gene.mvvmdemo.R;

/**
 * Created by Android on 2017/5/16.
 */

public class ButtonFeatureTagSelect extends FrameLayout {
    private CharSequence mFeatureTag;
    private Drawable mDeleteIcon;

    private TextView tvFeatureTag;
    private ImageView ivDeleteIcon;

    public interface OnDeleteListener {
        void onDeletePressed(View view);
    }
    OnDeleteListener mOnDeleteListener;

    public ButtonFeatureTagSelect(Context context) {
        super(context);
        init(context);
    }

    public ButtonFeatureTagSelect(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
        parseAttributes(context, attrs);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_button_feature_tag_select, this, true);
        tvFeatureTag = (TextView) findViewById(R.id.tv_feature);
        ivDeleteIcon = (ImageView) findViewById(R.id.iv_delete);
        ivDeleteIcon.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnDeleteListener != null){
                    mOnDeleteListener.onDeletePressed(view);
                }
            }
        });
    }

    private void parseAttributes(Context context, AttributeSet attrs) {
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.ButtonFeatureTagSelect);
        mFeatureTag = attributes.getString(R.styleable.ButtonFeatureTagSelect_featuretag);
        mDeleteIcon = attributes.getDrawable(R.styleable.ButtonFeatureTagSelect_deleteimage);
        attributes.recycle();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        if (mFeatureTag != null) {
            tvFeatureTag.setText(mFeatureTag);
        }
    }

    public void setFeatureTag(String tag){
        if(tag != null)
            tvFeatureTag.setText(tag);
    }

    public void setOnDeleteListener(OnDeleteListener listener) {
        this.mOnDeleteListener = listener;
    }

}
