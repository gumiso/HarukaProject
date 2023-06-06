package com.gumisoqinae.haruka.entity.test;

public class Car extends Vehicle {

    private String model;       //  型号

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Car(String typename, int singlePrice, String model) {
        super(typename, singlePrice);
        this.model = model;
    }

    @Override
    public int fullPriceCal() {

        return super.fullPriceCal();
    }
}
