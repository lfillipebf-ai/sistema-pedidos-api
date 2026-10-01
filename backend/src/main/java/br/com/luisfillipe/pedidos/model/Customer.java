package br.com.luisfillipe.pedidos.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity @Table(name="customers")
public class Customer {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank @Column(nullable=false) private String name;
 @Email private String email;
 public Customer(){}
 public Long getId(){return id;} public String getName(){return name;} public String getEmail(){return email;}
 public void setName(String name){this.name=name;} public void setEmail(String email){this.email=email;}
}
