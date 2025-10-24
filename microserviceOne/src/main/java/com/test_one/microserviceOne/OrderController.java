package com.test_one.microserviceOne;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private KafkaTemplate<String , Order> kafkaTemplate;

    private static final String TOPIC = "orders_topic";

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        Order savedOrder = orderRepository.save(order);
        kafkaTemplate.send(TOPIC, savedOrder.getId(),savedOrder);
        System.out.println("Order created and sent to Kafka: " + savedOrder);
        return savedOrder;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable String id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent()) {
            Order orderToDelete = order.get();
            orderToDelete.setActionType("DELETE");
            orderRepository.deleteById(orderToDelete.getId());
            kafkaTemplate.send(TOPIC, orderToDelete);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }




}
