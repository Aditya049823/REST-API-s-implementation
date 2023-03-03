package com.example.shoppingApp;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class OrderRepository {
    HashMap<String,Order>orderHashMap=new HashMap<>();
    HashMap<String,DeliveryPartner>deliveryPartnerHashMap=new HashMap<>();
    HashMap<String, List<String>>partnerOrderMap=new HashMap<>();
    HashMap<String,String>orderPartnerIDMap=new HashMap<>();


    public void addOrder(Order order) {
        orderHashMap.put(order.getId(), order);
    }

    public void addPartner(String partnerId) {
        deliveryPartnerHashMap.put(partnerId,new DeliveryPartner());
    }

    public void addPair(String orderId, String partnerId) {
        if(orderHashMap.containsKey(orderId) && deliveryPartnerHashMap.containsKey(partnerId))
        {
            orderPartnerIDMap.put(orderId,partnerId);
            List<String>orderList=new ArrayList<>();
            if(partnerOrderMap.containsKey(partnerId))
            {
                orderList=partnerOrderMap.get(partnerId);
            }
            orderList.add(orderId);
            partnerOrderMap.put(partnerId,orderList);
        }
    }

    public Order getOrderbyId(String orderId) {
        return orderHashMap.get(orderId);
    }

    public DeliveryPartner getPartner(String partnerId) {
        return deliveryPartnerHashMap.get(partnerId);
    }

    public Integer getCount(String partnerId) {
        return deliveryPartnerHashMap.get(partnerId).getNumberOfOrders();
    }

    public List<String> getOrdersbyPartnerid(String partnerId) {
        List<String>orders=new ArrayList<>();
        if(partnerOrderMap.containsKey(partnerId))
        {
            orders=partnerOrderMap.get(partnerId);
        }
        return orders;
    }

    public List<String> getAllOrders() {
        return new ArrayList<>(orderHashMap.keySet());
    }

    public Integer unassignedOrders() {
        return orderHashMap.size()-orderPartnerIDMap.size();
    }

    public Integer orderLeft(int tym, String partnerId) {
        int count=0;
        List<String>orderList=partnerOrderMap.get(partnerId);
        for(String order:orderList)
        {
            int time=orderHashMap.get(order).getDeliveryTime();
            if(time>tym)
            {
                count++;
            }
        }
        return count;
    }

    public int getLastTime(String partnerId) {
        int maxTime=0;
        List<String>orders=partnerOrderMap.get(partnerId);
        for(String order:orders)
        {
            int tym=orderHashMap.get(order).getDeliveryTime();
            maxTime=Math.max(tym,maxTime);
        }
        return maxTime;
    }

    public void delete(String partnerId) {
        deliveryPartnerHashMap.remove(partnerId);
        List<String>orderList=partnerOrderMap.get(partnerId);
        for (String order:orderList)
        {
            orderPartnerIDMap.remove(order,partnerId);
        }
        partnerOrderMap.remove(partnerId);
    }

    public void deleteById(String orderId) {
        orderHashMap.remove(orderId);
        String partnerId=orderPartnerIDMap.get(orderId);
        partnerOrderMap.get(partnerId).remove(orderId);
        orderPartnerIDMap.remove(orderId);
    }
}
