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
    }

    public ButtonFeatureTagSelect(Context context, AttributeSet attrs) {
        super(context, attrs);
        parseAttributes(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_button_feature_tag_select, this, true);

    }

    private void parseAttributes(Context context, AttributeSet attrs) {
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.ButtonFeatureTagSelect);
        mFeatureTag = attributes.getString(R.styleable.ButtonFeatureTagSelect_featuretag);
        mDeleteIcon = attributes.getDrawable(R.styleable.ButtonFeatureTagSelect_deleteimage);

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        tvFeatureTag = (TextView) findViewById(R.id.tv_feature);
        ivDeleteIcon = (ImageView) findViewById(R.id.iv_delete);

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
