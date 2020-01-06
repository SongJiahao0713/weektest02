package com.bawei.songjiahao.songjihao.model;

import com.bawei.songjiahao.songjihao.api.ApiService;
import com.bawei.songjiahao.songjihao.contract.INewsContract;
import com.bawei.songjiahao.songjihao.utils.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 时间：2020/1/6 0006
 * 作者：Songjiahao
 * 类的作用：
 */
public class Model implements INewsContract.IModel {

    @Override
    public void getShop(ModelCallBack modelCallBack) {
        RetrofitUtils.getInstance().getClass(ApiService.class)
                .getCategory()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Object o) {
                        modelCallBack.success(o);
                    }

                    @Override
                    public void onError(Throwable e) {
                        modelCallBack.failure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getRight(HashMap<String, String> params, ModelCallBack modelCallBack) {
        RetrofitUtils.getInstance().getClass(ApiService.class)
                .getData(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Object o) {
                        modelCallBack.success(o);
                    }

                    @Override
                    public void onError(Throwable e) {
                        modelCallBack.failure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
