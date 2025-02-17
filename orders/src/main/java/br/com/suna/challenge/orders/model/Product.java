package br.com.suna.challenge.orders.model;

import jakarta.persistence.*;

@Entity
@Table(name = "t_cll_products")
public class Product {

    //Class attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,
            nullable = false
    )
    private String name;

    @Column(nullable = false)
    private Double price;

    //Class ToString


    @Override
    public String toString() {
        return "Name: " + name +
                "\nPrice: " + price;
    }

    //Class constructors
    public Product() {}

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
