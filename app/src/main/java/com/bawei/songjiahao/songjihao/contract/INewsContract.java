package com.bawei.songjiahao.songjihao.contract;

import java.util.HashMap;

/**
 * 时间：2020/1/6 0006
 * 作者：Songjiahao
 * 类的作用：
 */
public interface INewsContract {
    interface IModel{
        interface ModelCallBack{
            void success(Object obj);
            void failure(Throwable throwable);
        }
        void getShop(ModelCallBack modelCallBack);
        void getRight(HashMap<String,String> params,ModelCallBack modelCallBack);
    }
    interface IView{
        void success(Object obj);
        void failure(Throwable throwable);
    }
    interface IPresenter{
        void getShop();
        void getRight(HashMap<String,String> params);
    }

}
