package com.meli.vehicle;


public abstract class Vehicle {
    private double speed;
    private double acceleration;
    private double angle;
    private String plate;
    private double weight;
    private int wheels;

//    public Vehicle(double weight, int wheels) {
//        this.weight = weight;
//        this.wheels = wheels;
//    }


    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "speed=" + speed +
                ", acceleration=" + acceleration +
                ", angle=" + angle +
                ", plate='" + plate + '\'' +
                ", wheels=" + wheels +
                '}';
    }
}
