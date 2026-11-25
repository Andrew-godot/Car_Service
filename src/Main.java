import tables.*;

import java.sql.*;
import java.util.Scanner;

public class Main {

    static void main(String[] args) throws SQLException {

        Scanner input = new Scanner(System.in); // Scanner object

        // Define integer variable menu
        int menu = 0;

        while (menu != 5) {
            System.out.println("1: Garage, 2: Job, 3: Car, 4: Customer, 5: Exit");
            menu = Integer.parseInt(input.nextLine());

            switch (menu) {
                case 1:

                    // GARAGE
                    Garage garage;
                    menu = 0;

                    while (menu != 5) {
                        System.out.println("1: Select, 2: Insert, 3: Update, 4: Delete, 5: Exit");
                        menu = Integer.parseInt(input.nextLine());

                        switch (menu) {
                            case 1:
                                // SELECT

                                garage = new Garage();
                                garage.selectStatement();

                                break;

                            case 2:
                                // INSERT

                                System.out.println("Enter the data in the following format: garageID,garageName,address,town,postcode,contactNo");
                                String insertData = input.nextLine();

                                garage = new Garage();
                                garage.insertStatement(insertData);

                                break;

                            case 3:
                                // UPDATE

                                System.out.println("Enter the Garage ID you want to update:");
                                String garageID = input.nextLine();

                                System.out.println("Which column would you like to update?\n1: garageName\n2: address\n3: town\n4: postcode\n5: contactNo");
                                int choice = Integer.parseInt(input.nextLine());

                                String column = "";

                                switch (choice) {
                                    case 1:
                                        column = "garageName";
                                        break;

                                    case 2:
                                        column = "address";
                                        break;

                                    case 3:
                                        column = "town";
                                        break;

                                    case 4:
                                        column = "postcode";
                                        break;

                                    case 5:
                                        column = "contactNo";
                                        break;

                                    default:
                                        System.out.println("Invalid choice!");
                                        return;
                                }

                                System.out.println("Enter the new value:");
                                String newValue = input.nextLine();

                                garage = new Garage();
                                garage.updateStatement(garageID, column, newValue);

                                break;

                            case 4:
                                // DELETE

                                System.out.println("Enter the garage ID");
                                String deleteData = input.nextLine();

                                garage = new Garage();
                                garage.deleteStatement(deleteData);

                                break;
                        }
                    }

                    // Exits system
                    System.out.println("Exiting System...");
                    System.exit(0);

                case 2:

                    // JOB
                    Job job;
                    menu = 0;

                    while (menu != 5) {
                        System.out.println("1: Select, 2: Insert, 3: Update, 4: Delete, 5: Exit");
                        menu = Integer.parseInt(input.nextLine());

                        switch (menu) {
                            case 1:
                                // SELECT

                                job = new Job();
                                job.selectStatement();

                                break;

                            case 2:
                                // INSERT

                                System.out.println("Enter the data in the following format: jobID,garageID,dateIn,dateOut,regNo,cost");
                                String insertData = input.nextLine();

                                job = new Job();
                                job.insertStatement(insertData);

                                break;

                            case 3:
                                // UPDATE

                                System.out.println("Enter the Job ID you want to update:");
                                String jobID = input.nextLine();

                                System.out.println("Which column would you like to update?\n1: garageID\n2: dateIn\n3: dateOut\n4: regNo\n5: cost");
                                int choice = Integer.parseInt(input.nextLine());

                                String column = "";

                                switch (choice) {
                                    case 1:
                                        column = "garageID";
                                        break;

                                    case 2:
                                        column = "dateIn";
                                        break;

                                    case 3:
                                        column = "dateOut";
                                        break;

                                    case 4:
                                        column = "regNo";
                                        break;

                                    case 5:
                                        column = "cost";
                                        break;

                                    default:
                                        System.out.println("Invalid choice!");
                                        return;
                                }

                                System.out.println("Enter the new value:");
                                String newValue = input.nextLine();

                                job = new Job();
                                job.updateStatement(jobID, column, newValue);

                                break;

                            case 4:
                                // DELETE

                                System.out.println("Enter the job ID");
                                String deleteData = input.nextLine();

                                job = new Job();
                                job.deleteStatement(deleteData);

                                break;

                        }
                    }

                    // Exits system
                    System.out.println("Exiting System...");
                    System.exit(0);

                case 3:

                    // CAR
                    Car car = new Car();
                    menu = 0;

                    while (menu != 5) {
                        System.out.println("1: Select, 2: Insert, 3: Update, 4: Delete, 5: Exit");
                        menu = Integer.parseInt(input.nextLine());

                        switch (menu) {
                            case 1:
                                // SELECT

                                car = new Car();
                                car.selectStatement();

                                break;

                            case 2:
                                // INSERT

                                System.out.println("Enter the data in the following format: regNo,make,model,year,customerID");
                                String insertData = input.nextLine();

                                car = new Car();
                                car.insertStatement(insertData);

                                break;

                            case 3:
                                // UPDATE

                                System.out.println("Enter the reg number you want to update:");
                                String regNo = input.nextLine();

                                System.out.println("Which column would you like to update?\n1: make\n2: model\n3: year\n4: customerID");
                                int choice = Integer.parseInt(input.nextLine());

                                String column = "";

                                switch (choice) {
                                    case 1:
                                        column = "make";
                                        break;

                                    case 2:
                                        column = "model";
                                        break;

                                    case 3:
                                        column = "year";
                                        break;

                                    case 4:
                                        column = "customerID";
                                        break;

                                    default:
                                        System.out.println("Invalid choice!");
                                        return;
                                }

                                System.out.println("Enter the new value:");
                                String newValue = input.nextLine();

                                car = new Car();
                                car.updateStatement(regNo, column, newValue);

                                break;

                            case 4:
                                // DELETE

                                System.out.println("Enter the  reg number");
                                String deleteData = input.nextLine();

                                car = new Car();
                                car.deleteStatement(deleteData);

                                break;

                        }
                    }

                    // Exits system
                    System.out.println("Exiting System...");
                    System.exit(0);

                case 4:

                    // CUSTOMER
                    Customer customer = new Customer();
                    menu = 0;

                    while (menu != 5) {
                        System.out.println("1: Select, 2: Insert, 3: Update, 4: Delete, 5: Exit");
                        menu = Integer.parseInt(input.nextLine());

                        switch (menu) {
                            case 1:
                                // SELECT

                                customer = new Customer();
                                customer.selectStatement();

                                break;

                            case 2:
                                // INSERT

                                System.out.println("Enter the data in the following format: customerID,forename,surname,address,postcode,phoneNo");
                                String insertData = input.nextLine();

                                customer = new Customer();
                                customer.insertStatement(insertData);

                                break;

                            case 3:
                                // UPDATE

                                System.out.println("Enter the reg number you want to update:");
                                String customerID = input.nextLine();

                                System.out.println("Which column would you like to update?\n1: forename\n2: surname\n3: address\n4: postcode\n5: phoneNo");
                                int choice = Integer.parseInt(input.nextLine());

                                String column = "";

                                switch (choice) {
                                    case 1:
                                        column = "forename";
                                        break;

                                    case 2:
                                        column = "surname";
                                        break;

                                    case 3:
                                        column = "address";
                                        break;

                                    case 4:
                                        column = "postcode";
                                        break;

                                    case 5:
                                        column = "phoneNo";
                                        break;

                                    default:
                                        System.out.println("Invalid choice!");
                                        return;
                                }

                                System.out.println("Enter the new value:");
                                String newValue = input.nextLine();

                                customer = new Customer();
                                customer.updateStatement(customerID, column, newValue);

                                break;
                            case 4:
                                // DELETE

                                System.out.println("Enter the customer ID");
                                String deleteData = input.nextLine();

                                customer = new Customer();
                                customer.deleteStatement(deleteData);

                                break;
                        }
                    }

                    // Exits system
                    System.out.println("Exiting System...");
                    System.exit(0);
            }

            // Exits system
            System.out.println("Exiting System...");
            System.exit(0);
        }
    }
}
