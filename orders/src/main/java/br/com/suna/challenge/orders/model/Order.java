package br.com.suna.challenge.orders.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "t_cll_orders")
public class Order {

    //Class Atributtes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "regist_date")
    private LocalDate date;

    //Class ToString


    @Override
    public String toString() {
        return "Registrated on: " + date;
    }

    //Class Constructors
    public Order() {}

    public Order(LocalDate date) {
        this.date = date;
    }

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
