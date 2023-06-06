package com.gumisoqinae.haruka.entity.test;

public class Bus extends Vehicle {

    private int seat;       //  座位数

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public Bus(String typename, int singlePrice, int seat) {
        super(typename, singlePrice);
        this.seat = seat;
    }
}
