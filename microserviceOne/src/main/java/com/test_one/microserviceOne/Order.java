package com.test_one.microserviceOne;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("orders")
public class Order {
    @Id
    private String id;
    private String customerName;
    private double total;

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
