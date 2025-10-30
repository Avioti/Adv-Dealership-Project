package com.pluralsight.ui;

import com.pluralsight.models.Dealership;
import com.pluralsight.models.Vehicle;
import com.pluralsight.data.DealershipFileManager;

import java.util.ArrayList;

import static com.pluralsight.Program.scanner;
import static com.pluralsight.utility.Utility.ifNumber;

public class UserInterface {
    private Dealership dealership;
    private boolean running = true;


    public UserInterface() {

    }

    public void display() {
        init();


        while (running) {

            displayMenu();

            userInput();


        }

    }

    public void displayMenu() {
        System.out.println("1 - Find vehicles within a price range");
        System.out.println("2 - Find vehicles by make / model");
        System.out.println("3 - Find vehicles by year range");
        System.out.println("4 - Find vehicles by color");
        System.out.println("5 - Find vehicles by mileage range");
        System.out.println("6 - Find vehicles by type (car, truck, SUV, van)");
        System.out.println("7 - List ALL vehicles");
        System.out.println("8 - Add a vehicle");
        System.out.println("9 - Remove a vehicle");
        System.out.println("99 - Quit");
    }

    public void userInput() {

        String option = scanner.nextLine().trim();

        if (ifNumber(option)) {
            int choice = Integer.parseInt(option);
            switch (choice) {
                case 1:
                    processGetByPriceRequest();


                    break;

                case 2:

                    processGetByMakeModelRequest();

                    break;

                case 3:

                    processGetByYearRequest();

                    break;

                case 4:

                    processGetByColorRequest();

                    break;

                case 5:

                    processGetByMileageRequest();

                    break;

                case 6:

                    processGetByVehicleTypeRequest();

                    break;

                case 7:

                    processGetAllVehiclesRequest();

                    break;

                case 8:

                    processAddVehicleRequest();

                    break;

                case 9:

                    processRemoveVehicleRequest();

                    break;

                case 99:

                    running = false;


                    break;

                default:

                    System.out.println("Enter valid option");
                    break;


            }
        } else {
            System.out.println();
            System.out.println("Enter valid option");
        }
    }

    private void init() {
        dealership = DealershipFileManager.getDealership();
        System.out.println(DealershipFileManager.getDealership());
    }

    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        for (Vehicle car : vehicles) {

            System.out.println(car);

        }

    }

    public void processGetByPriceRequest() {

        System.out.print("Min: ");
        double min = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Max: ");
        double max = scanner.nextDouble();
        scanner.nextLine();

        System.out.println(dealership.getVehiclesByPrice(min, max));


    }

    public void processGetByMakeModelRequest() {

        System.out.print("Make: ");
        String make = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();


        System.out.println(dealership.getVehiclesByMakeModel(make, model));

    }

    public void processGetByYearRequest() {

        System.out.print("Min: ");
        int min = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Max: ");
        int max = scanner.nextInt();
        scanner.nextLine();

        System.out.println(dealership.getVehiclesByYear(min, max));

    }

    public void processGetByColorRequest() {
        System.out.print("Color: ");
        String color = scanner.nextLine();


        System.out.println(dealership.getVehiclesByColor(color));
    }

    public void processGetByMileageRequest() {

        System.out.print("Min: ");
        int min = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Max: ");
        int max = scanner.nextInt();
        scanner.nextLine();


        System.out.println(dealership.getVehiclesByMileage(min, max));

    }

    public void processGetByVehicleTypeRequest() {

        System.out.print("Vehicle Type: ");
        String type = scanner.nextLine();


        System.out.println(dealership.getVehiclesByType(type));

    }

    public void processGetAllVehiclesRequest() {

        ArrayList<Vehicle> vehicleList = dealership.getAllVehicle();


        displayVehicles(vehicleList);

    }

    public void processAddVehicleRequest() {

        System.out.println("Enter Vehicle Details");

        System.out.print("Vin: ");
        int vin = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Make: ");
        String make = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Vehicle Type: ");
        String vehicleType = scanner.nextLine();
        System.out.print("Color: ");
        String color = scanner.nextLine();
        System.out.print("Odometer: ");
        int odometer = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        dealership.addVehicle(vin, year, make, model, vehicleType, color, odometer, price);

    }

    public void processRemoveVehicleRequest() {

        System.out.println("Enter Vehicle Details to Remove (Press enter to leave Blank)");

        System.out.print("Vin: ");
        String vin = scanner.nextLine().trim().replaceAll("\\s", "");

        System.out.print("Year: ");
        String year = scanner.nextLine().trim().replaceAll("\\s", "");

        System.out.print("Make: ");
        String make = scanner.nextLine().trim().replaceAll("\\s", "");

        System.out.print("Model: ");
        String model = scanner.nextLine().trim().replaceAll("\\s", "");

        System.out.print("Vehicle Type: ");
        String vehicleType = scanner.nextLine().trim().replaceAll("\\s", "");

        System.out.print("Color: ");
        String color = scanner.nextLine().trim().replaceAll("\\s", "");

        System.out.print("Odometer: ");
        String odometer = scanner.nextLine().trim().replaceAll("\\s", "");


        System.out.print("Price: ");
        String price = scanner.nextLine().trim().replaceAll("\\s", "");


        for (Vehicle car : dealership.getAllVehicle()) {


            boolean matches = true;

                try{
                    if (!vin.isBlank() && car.getVin() == Integer.parseInt(vin)) {
                        matches = false;
                    }
                    if (!year.isBlank() && car.getYear() == Integer.parseInt(year)) {
                        matches = false;
                    }
                    if (!make.isBlank() && !car.getMake().equalsIgnoreCase(make)) {
                        matches = false;
                    }
                    if (!model.isBlank() && !car.getModel().equalsIgnoreCase(model)) {
                        matches = false;
                    }
                    if (!vehicleType.isBlank() && !car.getVehicleType().equalsIgnoreCase(vehicleType)) {
                        matches = false;
                    }
                    if (!color.isBlank() && !car.getColor().equalsIgnoreCase(color)) {
                        matches = false;
                    }
                    if (!odometer.isBlank() && car.getOdometer() != Integer.parseInt(odometer)) {
                        matches = false;
                    }
                    if (!price.isBlank() && car.getPrice() != Double.parseDouble(price)) {
                        matches = false;
                    }


                }
                catch (Exception e){

                        e.printStackTrace();
                }


                if (matches) {
                    dealership.removeVehicle(car);
                    System.out.println("Vehicle removed.");
                }


        }

    }

}


