package com.jpmc.theater;

import java.util.Objects;

public class Customer {

    private String name;

    private String id;

    /**
     * @param name customer name
     */
    public Customer(String name) {
        this.name = name;
    }

    /**
     * @param name customer name
     * @param id   customer id
     */
    public Customer(String name, String id) {
        this.id = id; // NOTE - id is not used anywhere at the moment
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        if (this.id != "") {
            return Objects.equals(name, customer.name) && Objects.equals(id, customer.id);
        } else {
            return Objects.equals(name, customer.name);
        }
    }

    @Override
    public int hashCode() {
        if (this.id != "") {
            return Objects.hash(name, id);
        } else {
            return Objects.hash(name);
        }
    }

    @Override
    public String toString() {
        if (this.id != "") {
            return "id: " + id + ", name: " + name;
        }
        return "name: " + name;
    }
}