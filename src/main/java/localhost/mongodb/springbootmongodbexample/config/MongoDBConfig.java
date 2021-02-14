package localhost.mongodb.springbootmongodbexample.config;

import localhost.mongodb.springbootmongodbexample.document.Users;
import localhost.mongodb.springbootmongodbexample.document.Clientes;
import localhost.mongodb.springbootmongodbexample.document.Apolices;
import localhost.mongodb.springbootmongodbexample.repository.ApoliceRepository;
import localhost.mongodb.springbootmongodbexample.repository.ClienteRepository;
import localhost.mongodb.springbootmongodbexample.repository.UserRepository;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class MongoDBConfig {
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	ApoliceRepository apoliceRepository;
	
	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository) {
		return strings -> {
			userRepository.save(new Users(1, "Peter", "Development", 3000L));
			userRepository.save(new Users(2, "Sam", "Operations", 2000L));


			clienteRepository.save(new Clientes(12345678901L, "Joao", "Curitiba", "PR"));
			clienteRepository.save(new Clientes(12345678902L, "Maria", "Sao Paulo", "SP"));
			clienteRepository.save(new Clientes(12345678903L, "Ana", "Rio de Janeiro", "RJ"));


			apoliceRepository.save(new Apolices(44445678901L, new Date(), new Date(), "ERT345", 123400.1D));
			apoliceRepository.save(new Apolices(44445678901L, new Date(), new Date(), "SER678", 123400.2D));
			apoliceRepository.save(new Apolices(44445678901L, new Date(), new Date(), "CVB456", 123400.3D));
			apoliceRepository.save(new Apolices(44445678901L, new Date(), new Date(), "VFR765", 123400.4D));

		};
	}

}
