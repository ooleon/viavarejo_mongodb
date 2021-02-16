package localhost.mongodb.springbootmongodbexample.resource;

import localhost.mongodb.springbootmongodbexample.document.Apolices;
import localhost.mongodb.springbootmongodbexample.document.Clientes;
import localhost.mongodb.springbootmongodbexample.repository.ClienteRepository;
import localhost.mongodb.springbootmongodbexample.service.ClientesService;

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

@RestController
@RequestMapping("/rest/clientes")
public class ClientesResource {

	@Autowired
	private ClientesService clientesService;

	@RequestMapping(value = { "/salvar" }, method = { RequestMethod.POST })
	public ResponseEntity<Clientes> salvar(@RequestBody Clientes c) {
		return new ResponseEntity(this.clientesService.save(c), HttpStatus.OK);
	}

	@GetMapping("/all")
	public List<Clientes> getAll() {
		return clientesService.findAll();
	}

	@GetMapping("/id/{id}")
	public Clientes getClientesById(@PathVariable("id") String id) {

		return clientesService.findOne(id);
	}

}
