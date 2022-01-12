package com.example.alliance.intelligence.entities;

import java.util.List;

public class Satellite {

    private double distance;

    private String name;

    private List<String> message;

    private Position position;

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public double getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }
}
