package com.gene.mvvmdemo;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.gene.mvvmdemo.databinding.ActivityMimageBinding;
import com.gene.mvvmdemo.swipe.SwipeBackActivity;
import com.gene.mvvmdemo.utils.ImageViewUtils;
import com.squareup.picasso.Picasso;


public class MimageActivity extends SwipeBackActivity {


    private com.gene.mvvmdemo.SwipeBackLayout mSwipeBackLayout;

    private ActivityMimageBinding binding;

    public View.OnClickListener avatarClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(MimageActivity.this, "小哥！", Toast.LENGTH_SHORT).show();
            binding.setImageUrl(ImageViewUtils.nextImgUrl());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //限制app截屏
        mSwipeBackLayout = getSwipeBackLayout();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_mimage);
        binding.setActivity(this);
        binding.setImageUrl(ImageViewUtils.nextImgUrl());
        mSwipeBackLayout.setFitsSystemWindows(true);
        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);

    }


    @BindingAdapter({"imageUrl", "error"})
    public static void loadImage(ImageView view, String url, Drawable error) {
        Picasso.with(view.getContext()).load(url).error(error).into(view);
    }



}
