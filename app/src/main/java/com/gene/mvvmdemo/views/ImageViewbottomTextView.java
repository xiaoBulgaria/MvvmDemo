package com.gene.mvvmdemo.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.gene.mvvmdemo.R;

/**
 * Created by Android on 2017/5/16.
 */

public class ImageViewbottomTextView extends LinearLayout {
    private CharSequence mBottomText;
    private Drawable mImageUp;

    private TextView tvBottomText;
    private ImageView ivImageUp;

    public interface OnPostPicListener {
        void mPostPicListener(View view);
    }
    OnPostPicListener mOnPostPicListener;

    public ImageViewbottomTextView(Context context) {
        super(context);
        init(context);
    }

    public ImageViewbottomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
        parseAttributes(context, attrs);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_imageview_bottom_textview, this, true);
        tvBottomText = (TextView) findViewById(R.id.bottom_image);
        ivImageUp = (ImageView) findViewById(R.id.up_image);
        ivImageUp.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnPostPicListener != null){
                    mOnPostPicListener.mPostPicListener(view);
                }
            }
        });
    }

    private void parseAttributes(Context context, AttributeSet attrs) {
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.ImageViewbottomTextView);
        mBottomText = attributes.getString(R.styleable.ImageViewbottomTextView_text_bottom);
        mImageUp = attributes.getDrawable(R.styleable.ImageViewbottomTextView_image_up);
        attributes.recycle();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        if (mBottomText != null) {
            tvBottomText.setText(mBottomText);
        }
    }

    public void setOnDeleteListener(OnPostPicListener listener) {
        this.mOnPostPicListener = listener;
    }

}
