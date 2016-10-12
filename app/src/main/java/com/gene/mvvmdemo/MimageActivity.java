package com.gene.mvvmdemo;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.gene.mvvmdemo.databinding.ActivityMimageBinding;
import com.gene.mvvmdemo.utils.ImageViewUtils;
import com.squareup.picasso.Picasso;

public class MimageActivity extends BaseActivity {

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

        binding = DataBindingUtil.setContentView(this, R.layout.activity_mimage);
        binding.setActivity(this);
        binding.setImageUrl(ImageViewUtils.nextImgUrl());
    }


    @BindingAdapter({"imageUrl", "error"})
    public static void loadImage(ImageView view, String url, Drawable error) {
        Picasso.with(view.getContext()).load(url).error(error).into(view);
    }
}
