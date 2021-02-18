package localhost.mongodb.springbootmongodbexample.resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import localhost.mongodb.springbootmongodbexample.resource.UsersResource;
import localhost.mongodb.springbootmongodbexample.resource.ClientesResource;
import localhost.mongodb.springbootmongodbexample.resource.ApolicesController;
import localhost.mongodb.springbootmongodbexample.document.Apolices;
import localhost.mongodb.springbootmongodbexample.document.Clientes;
import localhost.mongodb.springbootmongodbexample.repository.ApoliceRepository;

import localhost.mongodb.springbootmongodbexample.document.Apolices;
import localhost.mongodb.springbootmongodbexample.document.Clientes;
import localhost.mongodb.springbootmongodbexample.repository.ClienteRepository;
import localhost.mongodb.springbootmongodbexample.service.ClientesService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ClientesResourceTests {
	private final Logger logger = Logger.getLogger(this.getClass().getName());

	@LocalServerPort
	private int port;
	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private ClientesService clientesService;
	@Autowired
	private ClientesResource clientesResource;
	
	private Clientes clientes;
	
	@Test
	public void getAll() {
		System.out.println("\nClientesResourceTests.getAll()");
		String url = "http://localhost:8095/rest/clientes/all";
		String msg = this.restTemplate.getForObject(url, String.class);
		
		Clientes[] responseEntity = this.restTemplate.getForObject(url, Clientes[].class);

		assertThat(responseEntity).isNotNull();
		List<Clientes> la= Arrays.asList(responseEntity);
		System.out.println();
		la.stream().forEach((a)->{
			System.out.println(a);
		});

	}

	@Test
	public void getClientesById() {
		System.out.println();
		System.out.println("ClientesResourceTests.getClientesById()");
		String id="44445678902"; 
		String url = "http://localhost:8095/rest/clientes/id/"+id+"/";
		System.out.println(url);
		ResponseEntity<Clientes> responseEntity =
				  restTemplate.getForEntity(
					url,
					Clientes.class);
		assertNotNull("no paso, esta responseEntity.getBody() esta nulo", responseEntity.getBody());
		
		Clientes clientes = responseEntity.getBody();
		System.out.println(clientes);
	}

	@Test
	public void salvar() {
		System.out.println();
		System.out.println("ClientesResourceTests.salvar()");
		Long numero=12345678955L;
		Clientes clientes  = new Clientes( numero, "Lisbeth", "Mato Groso", "MG");

		restTemplate.postForEntity(
				  "http://localhost:8095/rest/clientes/salvar",
				  clientes,
				  Clientes.class);
		
		Clientes clientesSalvada = clientesService.findOne(numero);
		
		assertNotNull("no paso, esta clientesSalvada esta nulo", clientesSalvada);
		System.out.println("salvado: " + clientesSalvada);
		System.out.println();
	}



}
