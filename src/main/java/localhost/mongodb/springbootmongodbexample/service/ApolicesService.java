package localhost.mongodb.springbootmongodbexample.service;

import localhost.mongodb.springbootmongodbexample.document.Apolices;
import localhost.mongodb.springbootmongodbexample.document.Clientes;
import localhost.mongodb.springbootmongodbexample.repository.ApoliceRepository;

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
public class ApolicesService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    
	@Autowired
	private ApoliceRepository apoliceRepository;

	public Apolices save(Apolices a) {
		Apolices apolices = apoliceRepository.save(a);
		logger.info(apolices.toString());
		return apolices;
	}

	public List<Apolices> findByIdCliente(Long cpfCliente) {
		return apoliceRepository.findByCpfCliente(cpfCliente);
	}

	public List<Apolices> findAll() {
		return apoliceRepository.findAll();
	}

	public Apolices findOne(Long numero){
		return apoliceRepository.findOne(numero);
	}
	
	public Apolices findOne(String id) {
		Long numero = Long.valueOf(id);
		return apoliceRepository.findOne(numero);
	}

	public void delete(Long numero) {
		apoliceRepository.delete(numero);
		
	}


}
