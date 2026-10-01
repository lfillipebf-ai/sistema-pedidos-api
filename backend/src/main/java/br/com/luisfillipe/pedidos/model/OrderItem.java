package br.com.luisfillipe.pedidos.model;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity @Table(name="order_items")
public class OrderItem {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) private OrderEntity order;
 @ManyToOne(optional=false) private Product product;
 @Column(nullable=false) private Integer quantity;
 @Column(nullable=false,precision=12,scale=2) private BigDecimal unitPrice;
 public Long getId(){return id;} public OrderEntity getOrder(){return order;} public Product getProduct(){return product;} public Integer getQuantity(){return quantity;} public BigDecimal getUnitPrice(){return unitPrice;}
 public void setOrder(OrderEntity order){this.order=order;} public void setProduct(Product product){this.product=product;} public void setQuantity(Integer quantity){this.quantity=quantity;} public void setUnitPrice(BigDecimal unitPrice){this.unitPrice=unitPrice;}
}
