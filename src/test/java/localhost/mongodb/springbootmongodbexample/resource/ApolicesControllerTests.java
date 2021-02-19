package localhost.mongodb.springbootmongodbexample.resource;

import localhost.mongodb.springbootmongodbexample.document.ApoliceDetalhe;
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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

		Apolices[] responseEntity = this.restTemplate.getForObject(url, Apolices[].class);
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
	public void salvar() throws Exception {
		System.out.println();
		System.out.println("ApolicesControllerTests.salvar()");
		Long numero=44445678902L;
		Apolices apolices = apolicesService.findOne(numero);
		Double valorOld = apolices.getValor();
		Double valorNew = 67000.5;
		Date dateI = new SimpleDateFormat("dd/mm/yyyy").parse("10/03/2021"); 
		Date dateF = new SimpleDateFormat("dd/mm/yyyy").parse("20/05/2021");
		apolices.setVigenciaInicio(dateI); 
		apolices.setVigenciaFim(dateF);
		apolices.setValor(valorNew);

		restTemplate.postForEntity(
				  "http://localhost:8095/rest/apolices/salvar",
				  apolices,
				  Apolices.class);
		
		Apolices apoliceSalvada = apolicesService.findOne(numero);
		
		assertNotNull("no paso, esta apoliceSalvada esta nulo", apoliceSalvada);
		System.out.println("salvado: " + apoliceSalvada);
		assertNotEquals(valorOld, valorNew);
		System.out.println();
	}
	
	@Test
	public void crear() {
		System.out.println();
		System.out.println("ApolicesControllerTests.crear()");
		Long numero=1111L;
		Apolices apolices = new Apolices( numero, new Date(),  new Date(), "POST00", 345.5, 12341234L);
		System.out.println("Apolices cadastrado: " + apolices);
		String url = "http://localhost:8095/rest/apolices/crear";
		System.out.println(url);
		ResponseEntity<Apolices> responseEntity = restTemplate.postForEntity(
				  url,
				  apolices,
				  Apolices.class);
		
		Apolices apoliceSalvada = responseEntity.getBody();
		
		System.out.println("salvaraleatorio: " + apoliceSalvada);
		System.out.println("numero: " +  numero + " diferente do aleatorio " + apoliceSalvada.getNumero());
		System.out.println();
	}
	
	@Test
	public void apoliceDetalhe() {
		Long numero=44445678902L;
		ApoliceDetalhe apoliceDetalhe1 = apolicesService.findOneDetalle(numero);
		System.out.println("\t ApoliceDetalhe: " + apoliceDetalhe1.toString());
	}

		
}
