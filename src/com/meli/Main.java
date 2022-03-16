package com.meli;

import com.meli.race.Race;
import com.meli.vehicle.Motorcycle;
import com.meli.vehicle.SafeCar;
import com.meli.vehicle.SafeMotorcycle;
import com.meli.vehicle.Vehicle;

import java.math.BigDecimal;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Race race = new Race();
        race.setDistance(800.0);
        race.setAllowedVehicles(7L);
        race.setName("Rally Dacar!");
        race.setPrize(BigDecimal.valueOf(200000.0));

        race.addCarro(65.1, 1.7, 33.0, "ABC1234");
        race.addCarro(72.1, 0.9, 17.0, "XYZ2234");
        race.addCarro(59.1, 2.1, 23.0, "RTC3421");
        race.addCarro(55.0, 0.5, 11.3, "PRF7455");
        race.addCarro(44.7, 2.9, 17.2, "VCT4322");

        race.addMotorcycle(32.1, 3.9, 17.2, "ABB2321");
        race.addMotorcycle(37.1, 3.1, 16.0, "CVR4333");
        race.addMotorcycle(31.1, 3.4, 19.2, "CVV2322");

        race.printAllVehicles();
        race.deleteVehicleWithPlate("PRF7455");
        race.printAllVehicles();

        Optional<Vehicle> vehicleWinnerOpt = race.getWinner();
        System.out.print("Winner is!!: ");
        vehicleWinnerOpt.ifPresent(System.out::println);


        race.setSafeCar(new SafeCar());
        race.setSafeMotorcycle(new SafeMotorcycle());

        race.rescueCar("ABC1234");
        race.rescueMotorcycle("CVR4333");
    }
}
