package com.cart.CartCons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CartListner {

    @Autowired
    private CartRepo cartRepo;


    @KafkaListener(topics = "orders_topic", groupId = "cart-group")
    public void handleOrder(Order order) {
        System.out.println("Cart service received order: " + order.getId() + " | Action: " + order.getActionType());

        if ("CREATE".equalsIgnoreCase(order.getActionType())) {
            Cart cart = new Cart();
            cart.setUserId(order.getId());
            cart.setItems(order.getItems());
            cart.setTotal(order.getTotal());
            cartRepo.save(cart);
            System.out.println("cart saved for user: " + order.getId());
        }
        else if ("DELETE".equalsIgnoreCase(order.getActionType())) {
            cartRepo.deleteByUserId(order.getId());
            System.out.println("Cart deleted for user: " + order.getId());
        }
    }
}
