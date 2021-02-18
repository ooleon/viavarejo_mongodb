package localhost.mongodb.springbootmongodbexample.resource;

import localhost.mongodb.springbootmongodbexample.document.Apolices;
import localhost.mongodb.springbootmongodbexample.document.Clientes;
import localhost.mongodb.springbootmongodbexample.repository.ApoliceRepository;
import localhost.mongodb.springbootmongodbexample.service.ApolicesService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApolicesControllerTests {
	private final Logger logger = Logger.getLogger(this.getClass().getName());

	@LocalServerPort
	private int port;
	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	ApolicesController apolicesController;

	@Test
	public void getAll() {
		System.out.println();
		System.out.println("ApolicesControllerTests.getAll()");
		String url = "http://localhost:8095/rest/apolices/all";
		System.out.println(url);
		// ResponseEntity rEntity = apolicesController.getAll();
		// assertThat().isNotNull();

		// System.out.println(apolicesController.getAll());
		// System.out.println(rEntity.getBody());
		// String msg = this.restTemplate.getForObject(url, String.class);
		System.out.println();
		System.out.println("ResponseEntity <Object[]>");
		ResponseEntity<Object[]> responseEntity = 
				this.restTemplate.getForEntity(url, Object[].class);

		System.out.println();
		System.out.println("responseEntity.getBody().length");
		System.out.println(responseEntity.getBody().length);
		
		ResponseEntity<List<Apolices>> rateResponse = 
				restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Apolices>>() {
				});
		System.out.println();
		System.out.println("rateResponse.getBody().size()");
		System.out.println(rateResponse.getBody().size());
		System.out.println();
		System.out.println("List<Apolices> listApolices = rateResponse.getBody()");
		List<Apolices> listApolices = rateResponse.getBody();
		System.out.println();
		System.out.println("listApolices");
		System.out.println("apolices[0]: " + listApolices.size());
		System.out.println("listApolices");
		System.out.println("apolices[0]: " + listApolices.get(0).getNumero());

		Object[] objects = responseEntity.getBody();
		// MediaType contentType = responseEntity.getHeaders().getContentType();
		// HttpStatus statusCode = responseEntity.getStatusCode();

		System.out.println("Apolices a = msg.get(0);");
		Apolices a = (Apolices) objects[0];
		// Apolices a = msg.get(0);
		System.out.println("a.getNumero()");
		System.out.println(a.getNumero());

		System.out.println();
		// System.out.println(msg);
		System.out.println();
	}

	/*
	 * // @RequestMapping(value = { "/salvar" }, method = { RequestMethod.POST })
	 * public ResponseEntity<Apolices> salvar(@RequestBody Apolices a) { return new
	 * ResponseEntity(this.apolicesService.save(a), HttpStatus.OK); }
	 * 
	 * // @GetMapping("/apolices/{id}") public Apolices
	 * getApolicesById(@PathVariable("id") String id) {
	 * 
	 * return apolicesService.findOne(id); }
	 */
}
