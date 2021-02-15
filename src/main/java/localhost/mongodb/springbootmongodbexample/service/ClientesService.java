package localhost.mongodb.springbootmongodbexample.service;

import localhost.mongodb.springbootmongodbexample.document.Apolices;
import localhost.mongodb.springbootmongodbexample.document.Clientes;
import localhost.mongodb.springbootmongodbexample.repository.ApoliceRepository;
import localhost.mongodb.springbootmongodbexample.repository.ClienteRepository;
import localhost.mongodb.springbootmongodbexample.resource.*;

import java.util.List;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
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

@Service
public class ClientesService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    
	@Autowired
	private ClienteRepository clienteRepository;

	public Clientes save(Clientes c) {
		Clientes clientes = clienteRepository.save(c);
		logger.info(clientes.toString());
		return clientes;
	}

	public List<Clientes> findAll() {
		return clienteRepository.findAll();
	}

	public Clientes findOne(Long numero){
		return clienteRepository.findOne(numero);
	}

	public Clientes findOne(String id) {
		Long numero = Long.valueOf(id);
		return clienteRepository.findOne(numero);
	}

}
