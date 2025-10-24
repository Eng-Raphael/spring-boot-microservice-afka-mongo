package com.test_two.microserviceTwo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {

    @Autowired
    private NotificationRepo notificationRepo;

    @KafkaListener(topics = "orders_topic", groupId = "notification-group")
    public void handelOrderNotification(Order order) {

        System.out.println("Received Order: " + order);

        String Message = "Order for " + order.getId() + " with total $" + order.getTotal() + " has been received.";

        Notification notification = new Notification();
        notification.setMessage(Message);
        notificationRepo.save(notification);

        System.out.println("Notification saved: " + notification);


    }
}
