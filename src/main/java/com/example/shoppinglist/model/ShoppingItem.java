package com.example.shoppinglist.model;

import jakarta.persistence.*;

@Entity
public class ShoppingItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private boolean purchased;

    // Конструкторы
    public ShoppingItem() {
    }

    public ShoppingItem(String name) {
        this.name = name;
        this.purchased = false;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }
}
