package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

import static com.pluralsight.Program.scanner;
import static com.pluralsight.Utility.ifNumber;

public class UserInterface {
    private Dealership dealership;



    public UserInterface() {

    }

    public void display(){
        init();
        boolean running = true;

        while(running){

            displayMenu();

            userInput();



        }

    }

    public void displayMenu(){
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

    public void userInput(){

        String option = scanner.nextLine().trim();

        if (ifNumber(option)){
            int choice = Integer.parseInt(option);
            switch (choice) {
                case 1:



                    break;

                case 2:



                    break;

                case 3:



                    break;

                case 4:



                    break;

                case 5:

                    break;

                case 6:

                    break;

                case 7:

                    break;

                case 8:

                    break;

                case 9:

                    break;

                case 99:

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

    private void init(){
        dealership = DealershipFileManager.getDealership();
    }

    private void displayVehicles(ArrayList<Vehicle> vehicles) {
            int i = 1;
        while(i < vehicles.size()){
            i++;

            System.out.println(vehicles.get(i));
        }

    }

    public void processGetByPriceRequest(){

    }

    public void processGetByMakeModelRequest(){

    }

    public void processGetByYearRequest(){

    }

    public void processGetByColorRequest(){

    }

    public void processGetByMileageRequest(){

    }

    public void processGetByVehicleTypeRequest(){

    }

    public void processGetAllVehiclesRequest(){

        ArrayList<Vehicle> vehicleList = dealership.getAllVehicle();


        displayVehicles(vehicleList);

    }

    public void processAddVehicleRequest(){

    }

    public void processRemoveVehicleRequest(){

    }

}
