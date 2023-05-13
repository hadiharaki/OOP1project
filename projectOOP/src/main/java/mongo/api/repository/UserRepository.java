package mongo.api.repository;



import org.springframework.data.mongodb.repository.MongoRepository;



import mongo.api.model.User;

public interface UserRepository extends MongoRepository<User, Integer>{
	
}
