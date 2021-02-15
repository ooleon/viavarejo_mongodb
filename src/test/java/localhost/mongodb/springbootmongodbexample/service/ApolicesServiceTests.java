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

import localhost.mongodb.springbootmongodbexample.resource.*;

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
		Apolices a = new Apolices(44445678905L, new Date(), new Date(), "RRR555", 55500.5D, 12345678903L );
		Apolices apolices = apolicesService.save(a);
		System.out.println(apolices.toString());
	}

	@Test
	public void findAll() {
		
		System.out.println(apolicesService.findAll());
	}

	@Test
	public void findOne() {
		System.out.println(apolicesService.findOne(44445678905L)
				.toString());
	}

	@Test
	public void delete() {
		Long numero = 44445678904L;
		System.out.println(apolicesService.findOne(numero)
				.toString());
		apolicesService.delete(numero);
		if (apolicesService.findOne(numero)==null) System.out.println("apagado: " + numero);
	}


}
