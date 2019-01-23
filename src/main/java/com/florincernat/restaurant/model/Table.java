package com.florincernat.restaurant.model;


public class Table {
    private long id;
    private int seats;
    private int available;

    public Table(){}

    public Table(long id, int seats, int available) {
        this.id = id;
        this.seats = seats;
        this.available = available;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int isAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }
}
