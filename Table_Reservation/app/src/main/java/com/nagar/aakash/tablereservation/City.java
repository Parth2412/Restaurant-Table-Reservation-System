package com.nagar.aakash.tablereservation;

/**
 * Created by Aakash on 15-Nov-18.
 */

public class City {
    private String id;
    private String name;

    public City(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }
}
