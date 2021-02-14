package localhost.mongodb.springbootmongodbexample.repository;

import localhost.mongodb.springbootmongodbexample.document.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<Users, Integer> {
}
