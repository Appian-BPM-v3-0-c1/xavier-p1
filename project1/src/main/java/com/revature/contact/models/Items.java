package com.revature.contact.models;

public class Items {
    private int id;
    private String name;
    private float price;
    private int stock;
    private String brand;
    private int departmentsId;

    public Items() {
    }

    public Items(int id, String name, float price, int stock, String brand, int departmentsId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.brand = brand;
        this.departmentsId = departmentsId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getDepartmentsId() {
        return departmentsId;
    }

    public void setDepartmentsId(int departmentsId) {
        this.departmentsId = departmentsId;
    }

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", brand='" + brand + '\'' +
                ", departmentsId=" + departmentsId +
                '}';
    }
}
