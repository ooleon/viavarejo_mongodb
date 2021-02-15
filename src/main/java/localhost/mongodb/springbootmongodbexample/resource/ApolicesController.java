package localhost.mongodb.springbootmongodbexample.resource;

import localhost.mongodb.springbootmongodbexample.document.Apolices;
import localhost.mongodb.springbootmongodbexample.document.Clientes;
import localhost.mongodb.springbootmongodbexample.repository.ApoliceRepository;
import localhost.mongodb.springbootmongodbexample.service.ApolicesService;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/rest/apolices")

public class ApolicesController {
//	public class ApolicesResource {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    
    @Autowired
    private ApolicesService apolicesService;
    

//    public ApolicesController(ApoliceRepository apoliceRepository) {
//        this.apoliceRepository = apoliceRepository;
//    }

    @GetMapping("/all")
    public List<Apolices> getAll() {
        return this.apolicesService.findAll();
    }
    
	@RequestMapping(value = { "/salvar" }, method = { RequestMethod.POST })
	public ResponseEntity<Apolices> salvar(@RequestBody Apolices a) {
		return new ResponseEntity(this.apolicesService.save(a), HttpStatus.OK);
	}

    @GetMapping("/apolices/{id}")
    public Apolices getApolicesById(@PathVariable("id") String id) {
    	
        return apolicesService.findOne(id);
    }
    
}
