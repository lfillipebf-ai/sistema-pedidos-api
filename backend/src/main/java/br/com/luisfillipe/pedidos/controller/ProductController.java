package br.com.luisfillipe.pedidos.controller;
import br.com.luisfillipe.pedidos.model.Product;
import br.com.luisfillipe.pedidos.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController @RequestMapping("/api/products")
public class ProductController {
 private final ProductRepository repository;
 public ProductController(ProductRepository repository){this.repository=repository;}
 @GetMapping public List<Product> list(){return repository.findAll();}
 @GetMapping("/{id}") public Product get(@PathVariable Long id){return repository.findById(id).orElseThrow();}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Product create(@Valid @RequestBody Product p){return repository.save(p);}
 @PutMapping("/{id}") public Product update(@PathVariable Long id,@Valid @RequestBody Product d){
  Product p=get(id); p.setName(d.getName()); p.setPrice(d.getPrice()); p.setStock(d.getStock()); return repository.save(p);
 }
}
