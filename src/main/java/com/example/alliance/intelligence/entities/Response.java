package com.example.alliance.intelligence.entities;

public class Response {

    private Position position;
    private String message;

    public Response(Position position, String message) {
        this.setPosition(position);
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    private void setPosition(Position position) {
        this.position = position;
        this.position.setX(Math.round(position.getX() * 100.0) / 100.0);
        this.position.setY(Math.round(position.getY() * 100.0) / 100.0);

    }

    public Position getPosition() {
        return position;
    }
}
