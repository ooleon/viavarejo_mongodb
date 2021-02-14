package localhost.mongodb.springbootmongodbexample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import localhost.mongodb.springbootmongodbexample.resource.UsersResource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMongodbExampleApplicationTests {
	@Autowired
	private UsersResource usersResource;
	@Test
	public void contextLoads() {
		
		System.out.println();
		System.out.println("numero de users: " + usersResource.getAll().size());
		
		System.out.println("***** mongo <-> SpringBootMongodbExample *****");
		System.out.println();
	}

}
