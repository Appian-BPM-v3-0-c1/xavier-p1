package com.revature.contact.models;

public class Department {
    private int id;
    private String name;
    private int locationId;

    public Department() {
    }

    public Department(int id, String name, int locationId) {
        this.id = id;
        this.name = name;
        this.locationId = locationId;
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

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", locationId=" + locationId +
                '}';
    }
}
