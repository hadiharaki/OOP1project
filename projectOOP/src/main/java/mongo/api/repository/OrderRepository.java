package mongo.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import mongo.api.model.Order;

public interface OrderRepository extends MongoRepository<Order, Integer> {

}
