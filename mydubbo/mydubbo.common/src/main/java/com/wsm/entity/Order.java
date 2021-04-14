package com.wsm.entity;

import java.io.Serializable;
public class Order implements Serializable {        //因为要进行网络传输,对实体类进行序列化操作

    private Integer id;
    private String title;
    private Integer price;
    private Integer uid;
    //省略 get/set..

    public Order() {
    }
    public Order(Integer id, String title, Integer price, Integer uid) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.uid = uid;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}
