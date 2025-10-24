package com.cart.CartCons;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartRepo extends MongoRepository<Cart,String> {
    void deleteByUserId(String userId);
}
