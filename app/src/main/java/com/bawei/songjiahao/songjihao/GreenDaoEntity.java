package com.bawei.songjiahao.songjihao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 时间：2020/1/6 0006
 * 作者：Songjiahao
 * 类的作用：
 */
@Entity
public class GreenDaoEntity {
    private String url;
    private String name;
    @Generated(hash = 1960188420)
    public GreenDaoEntity(String url, String name) {
        this.url = url;
        this.name = name;
    }
    @Generated(hash = 1963997359)
    public GreenDaoEntity() {
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
