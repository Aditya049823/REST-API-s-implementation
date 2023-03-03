package com.example.shoppingApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    public void addOrder(Order order) {
        orderRepository.addOrder(order);
    }

    public void addPartner(String partnerId) {
        orderRepository.addPartner(partnerId);
    }

    public void addOrderPartnerPair(String orderId, String partnerId) {
        orderRepository.addPair(orderId,partnerId);
    }

    public Order getOrderById(String orderId) {
        return orderRepository.getOrderbyId(orderId);
    }

    public DeliveryPartner getPartnerById(String partnerId) {
        return orderRepository.getPartner(partnerId);
    }

    public Integer getOrderCountByPartnerId(String partnerId) {
        return orderRepository.getCount(partnerId);
    }

    public List<String> getOrdersByPartnerId(String partnerId) {
        return orderRepository.getOrdersbyPartnerid(partnerId);
    }

    public List<String> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    public Integer unassignedCount() {
        return orderRepository.unassignedOrders();
    }

    public Integer orderLeft(String time, String partnerId) {
        String t[]=time.split(":");
        int tym=(Integer.parseInt(t[0])*60)+Integer.parseInt(t[1]);
        return orderRepository.orderLeft(tym,partnerId);
    }

    public String getDeliveryTime(String partnerId) {
        return orderRepository.getLastTime(partnerId);
    }

    public void delete(String partnerId) {
        orderRepository.delete(partnerId);
    }

    public void deleteById(String orderId) {
        orderRepository.deleteById(orderId);
    }
}
