package br.com.luisfillipe.pedidos.controller;
import br.com.luisfillipe.pedidos.model.Customer;
import br.com.luisfillipe.pedidos.repository.CustomerRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController @RequestMapping("/api/customers")
public class CustomerController {
 private final CustomerRepository repository;
 public CustomerController(CustomerRepository repository){this.repository=repository;}
 @GetMapping public List<Customer> list(){return repository.findAll();}
 @PostMapping @ResponseStatus(HttpStatus.CREATED)
 public Customer create(@Valid @RequestBody Customer c){return repository.save(c);}
}
