package com.test_one.microserviceOne;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

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




}
