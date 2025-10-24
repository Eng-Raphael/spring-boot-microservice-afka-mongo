package com.cart.CartCons;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document("cart")
public class Cart {
    @Id
    private String id;
    private String userId;
    private List<OrderItem> items = new ArrayList<>();
    private double total;

    @Override
    public String toString() {
        return "Cart{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", items=" + items +
                ", total=" + total +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Cart() {
    }

    public Cart(String id, String userId, List<OrderItem> items, double total) {
        this.id = id;
        this.userId = userId;
        this.items = items;
        this.total = total;
    }
// getters/setters
}
