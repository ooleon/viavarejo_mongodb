package localhost.mongodb.springbootmongodbexample.resource;

import localhost.mongodb.springbootmongodbexample.document.Apolices;
import localhost.mongodb.springbootmongodbexample.repository.ApoliceRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/apolices")
public class ApolicesResource {

    private ApoliceRepository apoliceRepository;

    public ApolicesResource(ApoliceRepository apoliceRepository) {
        this.apoliceRepository = apoliceRepository;
    }

    @GetMapping("/all")
    public List<Apolices> getAll() {
        return apoliceRepository.findAll();
    }
}
