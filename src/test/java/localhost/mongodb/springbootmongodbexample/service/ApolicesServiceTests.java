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


import static org.junit.Assert.assertEquals;

import java.util.Date;
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
public class ApolicesServiceTests {
	private final Logger logger = Logger.getLogger(this.getClass().getName());

	@Autowired
	private ApoliceRepository apoliceRepository;
	@Autowired
	private ApolicesService apolicesService;

	public void contextLoads() {
		
	}

	@Test
	public void create_save() {
		logger.info("create_save()");
		System.out.println("create_save()");
		Apolices a = new Apolices(44445678905L, new Date(), new Date(), "RRR555", 55500.5D, 12345678903L );
		Apolices apolices = apolicesService.save(a);
		System.out.println(apolices.toString());
	}

	@Test
	public void salvarApoliceNumeroRandom() {
		logger.info("salvarApoliceNumeroRandom()");
		System.out.println("salvarApoliceNumeroRandom()");
		
		Apolices a = new Apolices(1L, new Date(), new Date(), "RRR555", 55500.5D, 12345678903L );
		Apolices apolices = apolicesService.saveNumeroRandom(a);
		System.out.println(apolices.toString());
	}

	@Test
	public void findOne() {
		logger.info("findOne()");
		System.out.println("findOne()");
		System.out.println(apolicesService.findOne(44445678902L)
				.toString());
	}

	@Test
	public void delete() {
		logger.info("delete()");
		System.out.println("delete()");
		Long numero = 44445678904L;
		System.out.println(apolicesService.findOne(numero)
				.toString());
		apolicesService.delete(numero);
		if (apolicesService.findOne(numero)==null) System.out.println("apagado: " + numero);
		assertEquals(apolicesService.findOne(numero),null);
	}

	@Test
	public void findAll() {
		logger.info("findAll()");
		System.out.println("findAll()");
		System.out.println(apolicesService.findAll());
	}

	@Test
	public void conseguirApoliceDeCliente() {
		logger.info("conseguirApoliceDeCliente()");
		System.out.println("conseguirApoliceDeCliente");
		Long id = 12345678902L;
		
		System.out.println("apolices do cliente: " + apolicesService.findByIdCliente(id).size());
		List<Apolices> la=apolicesService.findByIdCliente(id);
		System.out.println(la);
		System.out.println("apolice do cliente com CPF: " + id);
		for (Apolices apolice : la) {
			System.out.println();
			System.out.println(apolice);
		}
		
	}


}
