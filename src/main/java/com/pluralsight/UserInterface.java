package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

import static com.pluralsight.Program.scanner;
import static com.pluralsight.Utility.ifNumber;

public class UserInterface {
    private Dealership dealership;
    private boolean running = true;



    public UserInterface() {

    }

    public void display(){
        init();


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

    private void init(){
        dealership = DealershipFileManager.getDealership();
    }

    private void displayVehicles(ArrayList<Vehicle> vehicles) {
           for(Vehicle car : vehicles){

               System.out.println(car);

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
