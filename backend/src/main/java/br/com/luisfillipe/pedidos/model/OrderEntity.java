package br.com.luisfillipe.pedidos.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity @Table(name="orders")
public class OrderEntity {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) private Customer customer;
 @Enumerated(EnumType.STRING) @Column(nullable=false) private OrderStatus status=OrderStatus.PENDING;
 @Column(nullable=false,precision=12,scale=2) private BigDecimal total=BigDecimal.ZERO;
 @OneToMany(mappedBy="order",cascade=CascadeType.ALL,orphanRemoval=true) private List<OrderItem> items=new ArrayList<>();
 public Long getId(){return id;} public Customer getCustomer(){return customer;} public OrderStatus getStatus(){return status;} public BigDecimal getTotal(){return total;} public List<OrderItem> getItems(){return items;}
 public void setCustomer(Customer customer){this.customer=customer;} public void setStatus(OrderStatus status){this.status=status;} public void setTotal(BigDecimal total){this.total=total;}
}
