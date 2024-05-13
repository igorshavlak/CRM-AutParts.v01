package org.example.kyrsova.model;

import org.springframework.stereotype.Component;


public class Client {
    private int id;
    private String name;
    private String surname;
    private String address;
    private String phone;
    private String email;
    private int order_quantity;

    public Client(int id, String name, String surname, String address, String phone, String email, int order_quantity) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.order_quantity = order_quantity;
    }
    public Client(String name, String surname, String address,  String email,String phone) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.order_quantity = order_quantity;
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
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getOrder_quantity() {
        return order_quantity;
    }
    public void increaseOrder_quantity() {
        order_quantity++;
    }
    public void setOrder_quantity(int order_quantity) {
        this.order_quantity = order_quantity;
    }

}
