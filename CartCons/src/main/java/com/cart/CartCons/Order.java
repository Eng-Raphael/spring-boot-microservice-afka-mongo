package com.cart.CartCons;


import org.springframework.data.annotation.Id;

import java.util.List;


public class Order {
    @Id
    private String id;
    private String customerName;
    private double total;
    private List<OrderItem> items;
    private String actionType;

    public Order(String id, String customerName, double total, List<OrderItem> items, String actionType) {
        this.id = id;
        this.customerName = customerName;
        this.total = total;
        this.items = items;
        this.actionType = actionType;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public Order() {
    }

    public Order(String id, String customerName, double total) {
        this.id = id;
        this.customerName = customerName;
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
// Constructors, Getters, Setters...
}
