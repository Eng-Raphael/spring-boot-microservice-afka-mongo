package com.test_two.microserviceTwo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {

    @Autowired
    private NotificationRepo notificationRepo;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;


    @KafkaListener(topics = "orders_topic", groupId = "notification-group")
    public void handelOrderNotification(Order order) {

        System.out.println("Received Order: " + order);

        String message;
        if ("DELETE".equalsIgnoreCase(order.getActionType())) {
            message = "Order " + order.getId() + " has been deleted.";
        } else {
            message = "Order " + order.getId() + " created with total $" + order.getTotal();
        }

        Notification notification = new Notification(message);
        notificationRepo.save(notification);
        kafkaTemplate.send("notifications_topic", notification);

        System.out.println("Notification published: " + notification);


    }
}
