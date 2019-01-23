package com.florincernat.restaurant.model;


public class Table {
    private long id;
    private int seats;
    private int taken;

    public Table(){}

    public Table(long id, int seats, int taken) {
        this.id = id;
        this.seats = seats;
        this.taken = taken;
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

    public int getTaken() {
        return taken;
    }

    public void setTaken(int taken) {
        this.taken = taken;
    }
}
