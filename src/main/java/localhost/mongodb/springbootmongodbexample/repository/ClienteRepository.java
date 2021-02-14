package localhost.mongodb.springbootmongodbexample.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import localhost.mongodb.springbootmongodbexample.document.Clientes;

public interface ClienteRepository extends MongoRepository<Clientes, Integer> {
}
