package com.bawei.songjiahao.songjihao.presenter;

import com.bawei.songjiahao.songjihao.base.BasePresenter;
import com.bawei.songjiahao.songjihao.contract.INewsContract;
import com.bawei.songjiahao.songjihao.model.Model;

import java.util.HashMap;

/**
 * 时间：2020/1/6 0006
 * 作者：Songjiahao
 * 类的作用：
 */
public class Presenter implements INewsContract.IPresenter {
    public Model model;
    public INewsContract.IView iView;

    public Presenter(INewsContract.IView iView) {
        this.iView = iView;
        this.model=new Model();
    }

    @Override
    public void getShop() {
        model.getShop(new INewsContract.IModel.ModelCallBack() {
            @Override
            public void success(Object obj) {
                iView.success(obj);
            }

            @Override
            public void failure(Throwable throwable) {
                iView.failure(throwable);
            }
        });
    }

    @Override
    public void getRight(HashMap<String, String> params) {
        model.getRight(params, new INewsContract.IModel.ModelCallBack() {
            @Override
            public void success(Object obj) {
                iView.success(obj);
            }

            @Override
            public void failure(Throwable throwable) {
                iView.failure(throwable);
            }
        });
    }
}
