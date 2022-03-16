package com.meli.vehicle;

public class Motorcycle extends Vehicle{

    public Motorcycle() {
        super.setWheels(2);
        super.setWeight(300.0);
    }

    public Motorcycle(double speed, double acceleration, double angle, String plate) {
        super.setWheels(2);
        super.setWeight(300.0);
        super.setSpeed(speed);
        super.setAcceleration(acceleration);
        super.setAngle(angle);
        super.setPlate(plate);
    }
}
