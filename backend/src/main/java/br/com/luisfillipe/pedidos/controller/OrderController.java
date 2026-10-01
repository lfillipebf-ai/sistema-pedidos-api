package br.com.luisfillipe.pedidos.controller;
import br.com.luisfillipe.pedidos.model.*;
import br.com.luisfillipe.pedidos.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@RestController @RequestMapping("/api/orders")
public class OrderController {
 private final OrderRepository orders; private final CustomerRepository customers; private final ProductRepository products;
 public OrderController(OrderRepository o,CustomerRepository c,ProductRepository p){orders=o;customers=c;products=p;}
 @GetMapping public List<OrderEntity> list(){return orders.findAll();}
 @GetMapping("/{id}") public OrderEntity get(@PathVariable Long id){return orders.findById(id).orElseThrow();}
 @GetMapping("/customer/{customerId}") public List<OrderEntity> byCustomer(@PathVariable Long customerId){return orders.findByCustomerId(customerId);}

 @PostMapping @ResponseStatus(HttpStatus.CREATED) @Transactional
 public OrderEntity create(@RequestBody OrderEntity input){
  if(input.getCustomer()==null||input.getCustomer().getId()==null) throw new IllegalArgumentException("Informe o cliente");
  Customer customer=customers.findById(input.getCustomer().getId()).orElseThrow(()->new IllegalArgumentException("Cliente não encontrado"));
  if(input.getItems()==null||input.getItems().isEmpty()) throw new IllegalArgumentException("Pedido sem itens");
  OrderEntity order=new OrderEntity(); order.setCustomer(customer);
  BigDecimal total=BigDecimal.ZERO;
  for(OrderItem requested:input.getItems()){
   if(requested.getProduct()==null||requested.getProduct().getId()==null) throw new IllegalArgumentException("Produto inválido");
   Product product=products.findById(requested.getProduct().getId()).orElseThrow(()->new IllegalArgumentException("Produto não encontrado"));
   int qty=requested.getQuantity()==null?0:requested.getQuantity();
   if(qty<=0) throw new IllegalArgumentException("Quantidade inválida");
   if(product.getStock()<qty) throw new IllegalArgumentException("Estoque insuficiente para "+product.getName());
   product.setStock(product.getStock()-qty); products.save(product);
   OrderItem item=new OrderItem(); item.setOrder(order); item.setProduct(product); item.setQuantity(qty); item.setUnitPrice(product.getPrice());
   order.getItems().add(item); total=total.add(product.getPrice().multiply(BigDecimal.valueOf(qty)));
  }
  order.setTotal(total); return orders.save(order);
 }
 @PatchMapping("/{id}/status") @Transactional
 public OrderEntity status(@PathVariable Long id,@RequestParam OrderStatus value){OrderEntity o=get(id);o.setStatus(value);return orders.save(o);}
}
