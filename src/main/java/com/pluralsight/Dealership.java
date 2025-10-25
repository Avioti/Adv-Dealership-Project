package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dealership {
    private String name,address,phone;
    private ArrayList<Vehicle> inventory;
    private ArrayList<Vehicle> matches;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max){

        matches = new ArrayList<>();


        for(Vehicle car : inventory){
            double carPrice = car.getPrice();

            if (carPrice <= max && carPrice >= min) {
                matches.add(car);
            }

        }
        return matches;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model){
       matches = new ArrayList<>();


        for(Vehicle car : inventory){
            String carMake = car.getMake().trim().replaceAll("\\s", "");

            String carModel = car.getModel().trim().replaceAll("\\s", "");

            if (carMake.equalsIgnoreCase(make) && carModel.equalsIgnoreCase(model)) {
                matches.add(car);
            }

        }
        return matches;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int min, int max){

        matches = new ArrayList<>();


        for(Vehicle car : inventory){
            int carYear = car.getYear();

            if (carYear <= max && carYear >= min) {
                matches.add(car);
            }

        }
        return matches;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color){
        matches = new ArrayList<>();


        for(Vehicle car : inventory){
            String carColor = car.getColor().trim().replaceAll("\\s", "");



            if (carColor.equalsIgnoreCase(color)) {
                matches.add(car);
            }

        }
        return matches;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max){
        matches = new ArrayList<>();


        for(Vehicle car : inventory){
            int carMiles = car.getOdometer();

            if (carMiles <= max && carMiles >= min) {
                matches.add(car);
            }

        }
        return matches;
    }

    public ArrayList<Vehicle> getVehiclesByType(String vehicleType){

        matches = new ArrayList<>();


        for(Vehicle car : inventory){
            String carVehicleType = car.getVehicleType().trim().replaceAll("\\s", "");

            if (carVehicleType.equalsIgnoreCase(vehicleType)) {
                matches.add(car);
            }

        }
        return matches;
    }

    public ArrayList<Vehicle> getAllVehicle(){

        return inventory;
    }



    public boolean addVehicle(Vehicle vehicle){

        return inventory.add(vehicle);

    }

    public void addVehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer, double price){
        try{

            BufferedWriter writer  = new BufferedWriter(new FileWriter(DealershipFileManager.filePath, true));
            if(DealershipFileManager.filePath.isBlank()){
                String dealershipInfo = String.format("%s|%s|%s",this.name,this.address,this.phone);
                writer.write(dealershipInfo);
                writer.newLine();
            }else{
                String format = String.format("%d|%d|%s|%s|%s|%s|%d|%.2f", vin, year, make, model, vehicleType, color,odometer,price);
                writer.write(format);
                writer.close();

                Vehicle car = new Vehicle(vin,year,make,model,vehicleType,color,odometer,price);

                inventory.add(car);
            }

        }catch (Exception e){
            e.printStackTrace();


        }

    }

    public void removeVehicle(Vehicle vehicle){


        inventory.remove(vehicle);
        DealershipFileManager.saveDealership(DealershipFileManager.getDealership());
        try {
            BufferedWriter bufWriter = new BufferedWriter(new FileWriter(DealershipFileManager.filePath, false));


                String dealershipInfo = String.format("%s|%s|%s",this.name,this.address,this.phone);
                bufWriter.write(dealershipInfo);


            for (Vehicle car : inventory) {
                bufWriter.newLine();
                String format = String.format("%d|%d|%s|%s|%s|%s|%d|%.2f", car.getVin(), car.getYear(), car.getMake(), car.getModel(), car.getVehicleType(),
                        car.getColor(),car.getOdometer(),car.getPrice());
                bufWriter.write(format);
            }

            bufWriter.close();

            System.out.println("Updated");
        } catch (Exception e) {
            e.printStackTrace();

        }


    }

    @Override
    public String toString() {
        return String.format("%s|%s|%s",this.name,this.address,this.phone);
    }
}
