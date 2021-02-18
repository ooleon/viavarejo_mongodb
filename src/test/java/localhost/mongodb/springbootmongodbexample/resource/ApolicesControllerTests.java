package localhost.mongodb.springbootmongodbexample.resource;

import localhost.mongodb.springbootmongodbexample.document.Apolices;

import localhost.mongodb.springbootmongodbexample.document.Clientes;
import localhost.mongodb.springbootmongodbexample.repository.ApoliceRepository;
import localhost.mongodb.springbootmongodbexample.service.ApolicesService;

import org.junit.Assert;
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
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.*;
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
	@Autowired
	ApolicesService apolicesService;


	@Test
	public void getAll() {
		System.out.println();
		System.out.println("ApolicesControllerTests.getAll()");
		String url = "http://localhost:8095/rest/apolices/all";
		String msg = this.restTemplate.getForObject(url, String.class);
//		System.out.println(msg);
//		System.out.println(url);
		System.out.println();

		
		/*
		 System.out.println("ResponseEntity <Object[]>"); 
		 ResponseEntity<Object[]>
		  responseEntity = this.restTemplate.getForEntity(url, Object[].class);
		  
		  System.out.println(); System.out.println("responseEntity.getBody().length");
		  System.out.println(responseEntity.getBody().length);
		  
		  System.out.println("Object[] objs = rateResponse.getBody()"); Object[] objs=
		  responseEntity.getBody(); System.out.println(); List<Apolices> listApolices =
		  new ArrayList<Apolices>(); for (Object object : objs) {
		  listApolices.add((Apolices) object) ; }
		  System.out.println("for (Object object : objs)");
		  

		ResponseEntity<List<Apolices>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Apolices>>() {
				});
		 */
		

/*
 * 
		ResponseEntity<Apolices[]> responseEntity1 = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<Apolices[]>() {
				});
		List<Apolices> la1= Arrays.asList(responseEntity1.getBody());
		la1.toString();
		System.out.println("responseEntity1" + responseEntity1.getStatusCodeValue());
		Assert.assertTrue(responseEntity1.getStatusCodeValue()>=200 && responseEntity1.getStatusCodeValue()<=230);
		Apolices[] Apolices1 = responseEntity1.getBody();
*/

		/*
		ResponseEntity<Apolices[]> responseEntity2 =
				  restTemplate.getForEntity(
					url,
				  Apolices[].class);
		Apolices[] arrayApolices = responseEntity2.getBody();
		List<Apolices> listApolices = Arrays.asList(arrayApolices);
		listApolices.stream().forEach((apolices)->{
			System.out.println(apolices);
		});
		System.out.println("responseEntity2");
		*/
		
		Apolices[] responseEntity = this.restTemplate.getForObject(url, Apolices[].class);
//		Assert.assertTrue(responseEntity != null);
		assertThat(responseEntity).isNotNull();
		List<Apolices> la= Arrays.asList(responseEntity);
		System.out.println();
		la.stream().forEach((a)->{
			System.out.println(a);
		});

	}

	@Test
	public void getApolicesById() {
		System.out.println();
		System.out.println("ApolicesControllerTests.getApolicesById()");
		String id="44445678902"; 
		String url = "http://localhost:8095/rest/apolices/numero/"+id+"/";
		System.out.println(url);
		ResponseEntity<Apolices> responseEntity =
				  restTemplate.getForEntity(
					url,
				  Apolices.class);
		assertNotNull("no paso, esta responseEntity.getBody() esta nulo", responseEntity.getBody());
		
		Apolices apolices = responseEntity.getBody();
		System.out.println(apolices);
	}

	@Test
	public void salvar() {
		System.out.println();
		System.out.println("ApolicesControllerTests.getApolicesById()");
		Long numero=123321L;
		Apolices apolices = new Apolices( numero, new Date(),  new Date(), "POST00", 345.5, 12341234L);
		restTemplate.postForObject(
				  "http://localhost:8095/rest/apolices/salvarAleatorio",
				  apolices,
				  ResponseEntity.class);
		
		Apolices apoliceSalvada = apolicesService.findOne(numero);
		
		assertNotNull("no paso, esta apoliceSalvada esta nulo", apoliceSalvada);
		System.out.println("salvado: " + apoliceSalvada);
	}
	
	/*
	 * // @RequestMapping(value = { "/salvar" }, method = { RequestMethod.POST })
	 * public ResponseEntity<Apolices> salvar(@RequestBody Apolices a) { return new
	 * ResponseEntity(this.apolicesService.save(a), HttpStatus.OK); }
	 * 
	 */
}
