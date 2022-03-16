package com.meli.vehicle;

public class Car extends Vehicle{

    public Car() {
        super.setWheels(4);
        super.setWeight(1000.0);
    }

    public Car(double speed, double acceleration, double angle, String plate) {
        super.setWheels(4);
        super.setWeight(1000.0);
        super.setSpeed(speed);
        super.setAcceleration(acceleration);
        super.setAngle(angle);
        super.setPlate(plate);
    }

}
