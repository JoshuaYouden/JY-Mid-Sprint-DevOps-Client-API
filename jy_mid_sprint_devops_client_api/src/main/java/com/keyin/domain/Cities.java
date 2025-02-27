package com.keyin.domain;

import java.util.Objects;

public class Cities {
    private long id;
    private String name;
    private String state;
    private int population;

    public Cities() {}

    public Cities(String name) {
        this.name = name;
    }

    public Cities(long id, String name, String state, int population) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.population = population;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cities cities = (Cities) o;
        return Objects.equals(name, cities.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}