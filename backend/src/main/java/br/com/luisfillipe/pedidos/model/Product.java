package br.com.luisfillipe.pedidos.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

@Entity @Table(name="products")
public class Product {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank @Column(nullable=false) private String name;
 @NotNull @DecimalMin("0.0") @Column(nullable=false,precision=12,scale=2) private BigDecimal price;
 @Min(0) @Column(nullable=false) private Integer stock=0;
 public Product(){}
 public Long getId(){return id;} public String getName(){return name;} public BigDecimal getPrice(){return price;} public Integer getStock(){return stock;}
 public void setName(String name){this.name=name;} public void setPrice(BigDecimal price){this.price=price;} public void setStock(Integer stock){this.stock=stock;}
}
