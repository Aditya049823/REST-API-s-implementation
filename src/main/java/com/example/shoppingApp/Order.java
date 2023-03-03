package com.example.shoppingApp;

public class Order {
    private String id;
    private int deliveryTime;

    public Order() {

    }
    public Order(String id,String deliveryTime)
    {
        this.id=id;
        String time[]=deliveryTime.split(":");
        this.deliveryTime=(Integer.parseInt(time[0])*60)+(Integer.parseInt(time[1]));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
}
