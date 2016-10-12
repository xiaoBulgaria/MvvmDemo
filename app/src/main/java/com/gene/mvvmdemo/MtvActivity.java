package com.gene.mvvmdemo;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.gene.mvvmdemo.utils.CensusUtils;

public class MtvActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        com.gene.mvvmdemo.CensusBinding binding = DataBindingUtil.setContentView(this,
                R.layout.activity_mtv);

        CensusUtils censusUtils = new CensusUtils("13122802216", "HaiAn", "Yuan", "Lei");
        binding.setCensusutils(censusUtils);
    }
}
