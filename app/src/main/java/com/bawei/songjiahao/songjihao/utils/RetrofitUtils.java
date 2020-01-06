package com.bawei.songjiahao.songjihao.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 时间：2020/1/6 0006
 * 作者：Songjiahao
 * 类的作用：
 */
public class RetrofitUtils {
    private static RetrofitUtils retrofit;
    private final OkHttpClient okHttpClient;
    private final Retrofit build;

    private RetrofitUtils() {
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        build = new Retrofit.Builder()
                .baseUrl("http://blog.zhaoliang5156.cn/")
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static RetrofitUtils getInstance() {
        if (retrofit==null){
            synchronized (RetrofitUtils.class){
                if (retrofit==null){
                    retrofit=new RetrofitUtils();
                }
            }
        }
        return retrofit;
    }


    public <T>T getClass(Class<T> tClass){
        T t=build.create(tClass);
        return t;
    }


    public Boolean HasNet(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo!=null&&activeNetworkInfo.isAvailable()){
            return true;
        }else{
            return false;
        }
    }
}
