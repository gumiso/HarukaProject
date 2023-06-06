package com.gumisoqinae.haruka.entity.test;

public class Vehicle {

    private String typename;        //  汽车类型
    private int singlePrice;        //  汽车单价

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public int getSinglePrice() {
        return singlePrice;
    }

    public void setSinglePrice(int singlePrice) {
        this.singlePrice = singlePrice;
    }

    public Vehicle(String typename, int singlePrice) {
        this.typename = typename;
        this.singlePrice = singlePrice;
    }

    public int fullPriceCal() {
        System.out.println("未使用Override，即将返回0");
        return 0;
    }
}
