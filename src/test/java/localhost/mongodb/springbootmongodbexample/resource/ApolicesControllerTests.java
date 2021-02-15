package localhost.mongodb.springbootmongodbexample.resource;

import localhost.mongodb.springbootmongodbexample.document.Apolices;
import localhost.mongodb.springbootmongodbexample.document.Clientes;
import localhost.mongodb.springbootmongodbexample.repository.ApoliceRepository;
import localhost.mongodb.springbootmongodbexample.service.ApolicesService;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
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

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApolicesControllerTests {
//	public class ApolicesResource {
    private final Logger logger = Logger.getLogger(this.getClass().getName());

	@LocalServerPort
	private int port;
	@Autowired
	private TestRestTemplate restTemplate;
	
    @Autowired
    private ApolicesService apolicesService;
    
//    @GetMapping("/rest/apolices/all")
    @Test
    public void getAll() {
    	String url = "http://localhost:" + port + "/rest/apolices/all";
    	System.out.println(url);
    	String msg = this.restTemplate.getForObject(url,
				String.class);
    	
    	System.out.println(msg);
//        this.apolicesService.findAll();
    }
    /*
//	@RequestMapping(value = { "/salvar" }, method = { RequestMethod.POST })
	public ResponseEntity<Apolices> salvar(@RequestBody Apolices a) {
		return new ResponseEntity(this.apolicesService.save(a), HttpStatus.OK);
	}

//    @GetMapping("/apolices/{id}")
    public Apolices getApolicesById(@PathVariable("id") String id) {
    	
        return apolicesService.findOne(id);
    }
    */
}
