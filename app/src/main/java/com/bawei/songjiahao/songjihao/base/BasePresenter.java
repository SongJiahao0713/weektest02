package com.bawei.songjiahao.songjihao.base;

import com.bawei.songjiahao.songjihao.contract.INewsContract;
import com.bawei.songjiahao.songjihao.model.Model;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/**
 * 时间：2020/1/6 0006
 * 作者：Songjiahao
 * 类的作用：
 */
public abstract class BasePresenter<M extends Model,V extends INewsContract.IView> {
    public M model;
    private WeakReference<V> weakReference;



    protected abstract M initModel();

    public void attach(V v){
        weakReference = new WeakReference<>(v);
    }

    public void deatch(){
        if (weakReference!=null){
        weakReference.clear();
        weakReference=null;
        }
    }
}
