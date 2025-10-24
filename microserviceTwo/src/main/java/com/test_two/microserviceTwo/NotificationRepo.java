package com.test_two.microserviceTwo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepo extends MongoRepository<Notification, String> {
}
