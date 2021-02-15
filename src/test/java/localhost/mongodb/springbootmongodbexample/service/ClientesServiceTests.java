package localhost.mongodb.springbootmongodbexample.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import localhost.mongodb.springbootmongodbexample.resource.UsersResource;
import localhost.mongodb.springbootmongodbexample.resource.ClientesResource;
import localhost.mongodb.springbootmongodbexample.resource.ApolicesController;

import localhost.mongodb.springbootmongodbexample.document.Apolices;
import localhost.mongodb.springbootmongodbexample.document.Clientes;
import localhost.mongodb.springbootmongodbexample.repository.ApoliceRepository;
import localhost.mongodb.springbootmongodbexample.repository.ClienteRepository;
import localhost.mongodb.springbootmongodbexample.resource.*;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.runner.RunWith;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.MultiValueMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientesServiceTests {
	private final Logger logger = Logger.getLogger(this.getClass().getName());

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ClientesService clientesService;

	@Test
	public void contextLoads() {

	}

	@Test
	public void save() {
		logger.info("create_save");
		Clientes c = new Clientes(234L,"Nina","Curitiba","PR");
		Clientes clientes = clientesService.save(c);
		logger.info(clientes.toString());
	}

	@Test
	public void findAll() {
		logger.info("findAll");
		clientesService.findAll();
	}

	@Test
	public void findOneLong1() {
		logger.info("findOne_Long1");
		Long numero = 12345678901L;
		clientesService.findOne(numero);
	}

	@Test
	public void findOneLong2() {
		logger.info("findOne_Long2");
		Long numero = 12345678902L;
		clientesService.findOne(numero);
	}

	@Test
	public void findOneLong3() {
		logger.info("findOne_Long3");
		Long numero = 12345678903L;
		clientesService.findOne(numero);
	}

	@Test
	public void findOneString() {
		logger.info("findOne_String");
		String id="12345678903";
		clientesService.findOne(id);
	}
	
	@Test
	public void delete() {
		System.out.println("delete()");
		Long numero = 44445678904L;
		System.out.println(clientesService.findOne(numero)
				.toString());
		clientesService.delete(numero);
		if (clientesService.findOne(numero)==null) System.out.println("apagado: " + numero);
		assertEquals(clientesService.findOne(numero),null);
	}


}
