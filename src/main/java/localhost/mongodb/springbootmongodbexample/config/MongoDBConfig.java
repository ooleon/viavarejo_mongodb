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
			clienteRepository.save(new Clientes(12345678904L, "Ana", "Rio de Janeiro", "RJ"));

			apoliceRepository.save(new Apolices(44445678901L, new Date(), new Date(), "ERT344", 123400.1D, 12345678901L ));
			apoliceRepository.save(new Apolices(44445678902L, new Date(), new Date(), "SER678", 123400.2D, 12345678901L ));
			apoliceRepository.save(new Apolices(44445678903L, new Date(), new Date(), "CVB456", 123400.3D, 12345678902L ));
			apoliceRepository.save(new Apolices(44445678904L, new Date(), new Date(), "VFR765", 123400.4D, 12345678903L ));

			apoliceRepository.save(new Apolices(5555678901L, new Date(), new Date(), "ERT345", 123400.1D, 12345678901L ));
			apoliceRepository.save(new Apolices(5555678902L, new Date(), new Date(), "RRT346", 123400.1D, 12345678901L ));
			apoliceRepository.save(new Apolices(5555678903L, new Date(), new Date(), "CVB457", 123400.1D, 12345678902L ));
			apoliceRepository.save(new Apolices(5555678904L, new Date(), new Date(), "WVB458", 123400.1D, 12345678902L ));
			
		};
	}

}
