package localhost.mongodb.springbootmongodbexample.resource;

import localhost.mongodb.springbootmongodbexample.document.Clientes;
import localhost.mongodb.springbootmongodbexample.repository.ClienteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/clientes")
public class ClientesResource {

    private ClienteRepository clienteRepository;

    public ClientesResource(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/all")
    public List<Clientes> getAll() {
        return clienteRepository.findAll();
    }
}
