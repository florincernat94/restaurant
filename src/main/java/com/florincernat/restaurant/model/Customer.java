package com.florincernat.restaurant.model;

public class Customer {

    private long id;
    private String email;
    private String password;
    private String address;

    public Customer(){}

    public Customer(String email, String password, String address) {
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
