package localhost.mongodb.springbootmongodbexample.resource;

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

import java.util.List;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientesResourceTests {
	private final Logger logger = Logger.getLogger(this.getClass().getName());

	@Autowired
	private ClientesService clientesService;
	@Autowired
	private ClientesResource clientesResource;

	
//	@GetMapping("/all")
	@Test
    public void findAllTest() {
		logger.info("findAllTest");
		
		clientesResource.getAll();
    }

/*	
	@RequestMapping(value = { "/salvar" }, method = { RequestMethod.POST })
	public ResponseEntity<Clientes> salvar(@RequestBody Clientes c) {
		return new ResponseEntity(this.clientesService.save(c), HttpStatus.OK);
	}

    
    @GetMapping("/cliente/{id}")
    public Clientes getClientesById(@PathVariable("id") String id) {
    	
        return clientesService.findOne(id);
    }
*/    
}
