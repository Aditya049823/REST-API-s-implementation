package com.example.shoppingApp;

public class DeliveryPartner {
    private String id;
    private int numberOfOrders;

    public DeliveryPartner(){

    }

    public DeliveryPartner(String id, int numberOfOrders) {
        this.id = id;
        this.numberOfOrders = numberOfOrders;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumberOfOrders() {
        return numberOfOrders;
    }

    public void setNumberOfOrders(int numberOfOrders) {
        this.numberOfOrders = numberOfOrders;
    }
}
