package com.gene.mvvmdemo.utils;

/**
 * Created by Administrator on 2016/9/29.
 */
public class CensusUtils {
    String mTel;
    String mAddress;
    String mFirstName;
    String mLastName;

    public CensusUtils(String mTel, String mAddress, String mFirstName, String mLastName) {
        this.mTel = mTel;
        this.mAddress = mAddress;
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getTel() {
        return mTel;
    }

    public void setTel(String mTel) {
        this.mTel = mTel;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String mLastName) {
        this.mLastName = mLastName;
    }
}
