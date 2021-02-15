package localhost.mongodb.springbootmongodbexample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import localhost.mongodb.springbootmongodbexample.resource.UsersResource;
import localhost.mongodb.springbootmongodbexample.resource.ClientesResource;
import localhost.mongodb.springbootmongodbexample.resource.ApolicesController;
//import localhost.mongodb.springbootmongodbexample.resource.ApolicesResource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMongodbExampleApplicationTests {
	@Autowired
	private UsersResource usersResource;
	@Autowired
	private ClientesResource clientesResource;
	@Autowired
	private ApolicesController apolicesController;

	@Test
	public void contextLoads() {
		
		salida();
		
	}
	
	public void salida() {
		System.out.println();
		System.out.println("numero de users: " + usersResource.getAll().size());
		System.out.println("numero de clientes: " + clientesResource.getAll().size());
		System.out.println("numero de apolices: " + apolicesController.getAll().size());
		
		System.out.println("***** mongo <-> SpringBootMongodbExample *****");
		System.out.println();

	}

}
