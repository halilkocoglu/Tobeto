package org.example.entities;

public class Car {
    private int id;
    private String brand;
    private String model;
    private int price;
    private int inStock;



    public Car() {
    }

    public Car(int id, String brand, String model, int price, int inStock) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.inStock = inStock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }
}
