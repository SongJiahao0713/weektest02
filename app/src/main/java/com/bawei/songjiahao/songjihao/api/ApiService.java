package com.bawei.songjiahao.songjihao.api;

import com.bawei.songjiahao.songjihao.entity.RightEntity;
import com.bawei.songjiahao.songjihao.entity.ShopEntity;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * 时间：2020/1/6 0006
 * 作者：Songjiahao
 * 类的作用：
 */
public interface ApiService {
    @GET("baweiapi/category/")
    Observable getCategory();

    @GET("baweiapi/shopByCategory/")
    Observable getData(@QueryMap HashMap<String,String> params);
}
