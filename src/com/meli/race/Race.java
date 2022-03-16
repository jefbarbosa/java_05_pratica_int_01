package com.meli.race;

import com.meli.vehicle.*;

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
    private SafeCar safeCar;
    private SafeMotorcycle safeMotorcycle;

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

    private List<?> getVehicleByPlate(String plate) {
        return listVehicles.stream().filter(vehicle -> vehicle.getPlate().equals(plate)).collect(Collectors.toList());
    }

    public void rescueCar(String plate) {
        List<Car> vehicle = (List<Car>) getVehicleByPlate(plate);
        if (vehicle.size() > 0)
            safeCar.rescue(vehicle.get(0));
    }

    public void rescueMotorcycle(String plate) {
        List<Motorcycle> vehicle = (List<Motorcycle>) getVehicleByPlate(plate);
        if (vehicle.size() > 0)
            safeMotorcycle.rescue(vehicle.get(0));
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

    public SafeCar getSafeCar() {
        return safeCar;
    }

    public void setSafeCar(SafeCar safeCar) {
        this.safeCar = safeCar;
    }

    public SafeMotorcycle getSafeMotorcycle() {
        return safeMotorcycle;
    }

    public void setSafeMotorcycle(SafeMotorcycle safeMotorcycle) {
        this.safeMotorcycle = safeMotorcycle;
    }
}
