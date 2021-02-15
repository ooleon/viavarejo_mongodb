package localhost.mongodb.springbootmongodbexample.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import localhost.mongodb.springbootmongodbexample.document.Apolices;

public interface ApoliceRepository extends MongoRepository<Apolices, Long> {
	public List<Apolices> findByCpfCliente(Long cpfCliente);
	
}
