package com.meli.race;

import com.meli.vehicle.Car;
import com.meli.vehicle.Motorcycle;
import com.meli.vehicle.Vehicle;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Race {
    private double distance;
    private BigDecimal prize;
    private String name;
    private Long allowedVehicles;
    private List<Vehicle> listVehicles = new ArrayList<>();

    private boolean checkLimitReached() {
        if (listVehicles.size() >= allowedVehicles) {
            System.out.println("Maximum limit reached!");
            return true;
        }
        return false;
    }

    public void addCarro(double speed, double acceleration, double angle, String plate) {
        if (checkLimitReached())
            return;
        listVehicles.add(new Car(speed, acceleration, angle, plate));
    }

    public void addMotorcycle(double speed, double acceleration, double angle, String plate) {
        if (checkLimitReached())
            return;
        listVehicles.add(new Motorcycle(speed, acceleration, angle, plate));
    }

    public void deleteVehicle(Vehicle vehicle) {
        listVehicles = listVehicles
                .stream()
                .filter(vehicle1 -> !vehicle.equals(vehicle1)).collect(Collectors.toList());
    }

    public void deleteVehicleWithPlate(String plate) {
        listVehicles = listVehicles
                .stream()
                .filter(vehicle -> !vehicle.getPlate().equals(plate)).collect(Collectors.toList());
    }

    public void printAllVehicles() {
        System.out.println();
        listVehicles.forEach(System.out::println);
    }

    public Optional<Vehicle> getWinner() {
        return listVehicles.stream()
                .max(Comparator.comparing(vehicle -> vehicle.getSpeed()*0.5*vehicle.getAcceleration()/
                        (vehicle.getAngle()*(vehicle.getWeight() - (vehicle.getWheels()*100) ))));
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public BigDecimal getPrize() {
        return prize;
    }

    public void setPrize(BigDecimal prize) {
        this.prize = prize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAllowedVehicles() {
        return allowedVehicles;
    }

    public void setAllowedVehicles(Long allowedVehicles) {
        this.allowedVehicles = allowedVehicles;
    }

    public List<Vehicle> getListVehicles() {
        return listVehicles;
    }

    public void setListVehicles(List<Vehicle> listVehicles) {
        this.listVehicles = listVehicles;
    }
}
