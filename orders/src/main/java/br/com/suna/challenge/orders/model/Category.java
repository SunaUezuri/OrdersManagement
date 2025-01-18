package br.com.suna.challenge.orders.model;

import jakarta.persistence.*;

@Entity
@Table(name = "t_cll_categories")
public class Category {

    //Class attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    //Class constructors
    public Category() {}

    public Category(String name) {
        this.name = name;
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
}
