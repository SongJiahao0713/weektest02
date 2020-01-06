package com.bawei.songjiahao.songjihao.base;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bawei.songjiahao.songjihao.presenter.Presenter;


public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        initView();
        initData();
    }



    protected abstract void initData();

    protected abstract void initView();

    protected abstract int layoutId();
}
