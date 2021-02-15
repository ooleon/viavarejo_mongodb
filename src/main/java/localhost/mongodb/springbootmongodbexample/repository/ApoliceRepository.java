package localhost.mongodb.springbootmongodbexample.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import localhost.mongodb.springbootmongodbexample.document.Apolices;

public interface ApoliceRepository extends MongoRepository<Apolices, Long> {
}
