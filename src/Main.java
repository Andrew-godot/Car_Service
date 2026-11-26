// IMPORTS
import tables.*;
import java.sql.*;
import java.util.Scanner;

public class Main {

    static void main(String[] args) throws SQLException {

        Scanner input = new Scanner(System.in); // Scanner object

        int menu = 0; // Define integer variable menu

        // While loop that will run only if menu is not equal to 5
        while (menu != 5) {
            System.out.println("1: Garage, 2: Job, 3: Car, 4: Customer, 5: Exit");
            menu = Integer.parseInt(input.nextLine()); // Gets user input

            // switch : case statements (Tables)
            switch (menu) {
                case 1:

                    // GARAGE
                    Garage garage; // Declares variable called garage that holds a reference to Garage object
                    menu = 0; // Set menu variable to 0 for submenu selection

                    // While loop that will run only if menu is not equal to 5
                    while (menu != 5) {
                        System.out.println("1: Select, 2: Insert, 3: Update, 4: Delete, 5: Exit");
                        menu = Integer.parseInt(input.nextLine()); // Gets user input

                        // switch : case statements (Garage)
                        switch (menu) {
                            case 1:
                                // SELECT

                                garage = new Garage(); // Creates new Garage object
                                garage.selectStatement(); // Calls method selectStatement from Garage.java

                                break; // Exits switch block

                            case 2:
                                // INSERT

                                System.out.println("Enter the data in the following format: garageID,garageName,address,town,postcode,contactNo");
                                String insertData = input.nextLine(); // Gets user input

                                garage = new Garage(); // Creates new Garage object
                                garage.insertStatement(insertData); // Calls method insertStatement from Garage.java with parameter insertData

                                break; // Exits switch block

                            case 3:
                                // UPDATE

                                System.out.println("Enter the Garage ID you want to update:");
                                String garageID = input.nextLine(); // Gets user input

                                System.out.println("Which column would you like to update?\n1: garageName\n2: address\n3: town\n4: postcode\n5: contactNo");
                                int choice = Integer.parseInt(input.nextLine()); // Gets user input

                                String column = "";

                                switch (choice) {
                                    case 1:
                                        column = "garageName";
                                        break; // Exits switch block

                                    case 2:
                                        column = "address";
                                        break; // Exits switch block

                                    case 3:
                                        column = "town";
                                        break; // Exits switch block

                                    case 4:
                                        column = "postcode";
                                        break; // Exits switch block

                                    case 5:
                                        column = "contactNo";
                                        break; // Exits switch block

                                    default:
                                        System.out.println("Invalid choice!");
                                        return;
                                }

                                System.out.println("Enter the new value:");
                                String newValue = input.nextLine(); // Gets user input

                                garage = new Garage(); // Creates new Garage object
                                garage.updateStatement(garageID, column, newValue); // Calls method updateStatement from Garage.java with parameters garageID, column, newValue

                                break; // Exits switch block

                            case 4:
                                // DELETE

                                System.out.println("Enter the garage ID");
                                String deleteData = input.nextLine(); // Gets user input

                                garage = new Garage(); // Creates new Garage object
                                garage.deleteStatement(deleteData); // Calls method deleteStatement from Garage.java with parameter deleteData

                                break; // Exits switch block
                        }
                    }

                    // Exits system
                    System.out.println("Exiting System...");
                    System.exit(0);

                case 2:

                    // JOB
                    Job job; // Declares variable called job that holds a reference to Job object
                    menu = 0;  // Sets menu to 0 for submenu selection

                    // While loop that will run only if menu is not equal to 5
                    while (menu != 5) {
                        System.out.println("1: Select, 2: Insert, 3: Update, 4: Delete, 5: Exit");
                        menu = Integer.parseInt(input.nextLine()); // Gets user input

                        // switch : case statements (Job)
                        switch (menu) {
                            case 1:
                                // SELECT

                                job = new Job(); // Creates new Job object
                                job.selectStatement(); // Calls method selectStatement from Job.java

                                break; // Exits switch block

                            case 2:
                                // INSERT

                                System.out.println("Enter the data in the following format: jobID,garageID,dateIn,dateOut,regNo,cost");
                                String insertData = input.nextLine(); // Gets user input

                                job = new Job(); // Creates new Job object
                                job.insertStatement(insertData); // Calls method insertStatement from Job.java with parameter insertData

                                break; // Exits switch block

                            case 3:
                                // UPDATE

                                System.out.println("Enter the Job ID you want to update:");
                                String jobID = input.nextLine(); // Gets user input

                                System.out.println("Which column would you like to update?\n1: garageID\n2: dateIn\n3: dateOut\n4: regNo\n5: cost");
                                int choice = Integer.parseInt(input.nextLine()); // Gets user input

                                String column = "";

                                // switch : case statements
                                switch (choice) {
                                    case 1:
                                        column = "garageID";
                                        break; // Exits switch block

                                    case 2:
                                        column = "dateIn";
                                        break; // Exits switch block

                                    case 3:
                                        column = "dateOut";
                                        break; // Exits switch block

                                    case 4:
                                        column = "regNo";
                                        break; // Exits switch block

                                    case 5:
                                        column = "cost";
                                        break; // Exits switch block

                                    default:
                                        System.out.println("Invalid choice!");
                                        return;
                                }

                                System.out.println("Enter the new value:");
                                String newValue = input.nextLine(); // Gets user input

                                job = new Job(); // Creates new job object
                                job.updateStatement(jobID, column, newValue); // Calls method updateStatement from Job.java with parameters jobID, column, newValue

                                break; // Exits switch block

                            case 4:
                                // DELETE

                                System.out.println("Enter the job ID");
                                String deleteData = input.nextLine(); // Gets user input

                                job = new Job(); // Creates new job object
                                job.deleteStatement(deleteData); // Calls method deleteStatement from Garage.java with parameter deleteData

                                break; // Exits switch block

                        }
                    }

                    // Exits system
                    System.out.println("Exiting System...");
                    System.exit(0);

                case 3:

                    // CAR
                    Car car; // Declares variable called car that holds a reference to Car object
                    menu = 0; // Sets menu to 0 for submenu selection

                    // While loop that will run only if menu is not equal to 5
                    while (menu != 5) {
                        System.out.println("1: Select, 2: Insert, 3: Update, 4: Delete, 5: Exit");
                        menu = Integer.parseInt(input.nextLine()); // Gets user input

                        // switch : case statements (Car)
                        switch (menu) {
                            case 1:
                                // SELECT

                                car = new Car(); // Creates new Car object
                                car.selectStatement(); // Calls method selectStatement from Car.java

                                break; // Exits switch block

                            case 2:
                                // INSERT

                                System.out.println("Enter the data in the following format: regNo,make,model,year,customerID");
                                String insertData = input.nextLine(); // Gets user input

                                car = new Car(); // Creates new Car object
                                car.insertStatement(insertData); // Calls method insertStatement from Car.java with parameter insertData

                                break; // Exits switch block

                            case 3:
                                // UPDATE

                                System.out.println("Enter the Reg Number you want to update:");
                                String regNo = input.nextLine(); // Gets user input

                                System.out.println("Which column would you like to update?\n1: make\n2: model\n3: year\n4: customerID");
                                int choice = Integer.parseInt(input.nextLine()); // Gets user input

                                String column = "";

                                switch (choice) {
                                    case 1:
                                        column = "make";
                                        break; // Exits switch block

                                    case 2:
                                        column = "model";
                                        break; // Exits switch block

                                    case 3:
                                        column = "year";
                                        break; // Exits switch block

                                    case 4:
                                        column = "customerID";
                                        break; // Exits switch block

                                    default:
                                        System.out.println("Invalid choice!");
                                        return;
                                }

                                System.out.println("Enter the new value:");
                                String newValue = input.nextLine(); // Gets user input

                                car = new Car(); // Creates new Car object
                                car.updateStatement(regNo, column, newValue); // Calls method updateStatement from Car.java with parameters regNo, column, newValue

                                break; // Exits switch block

                            case 4:
                                // DELETE

                                System.out.println("Enter the Reg Number");
                                String deleteData = input.nextLine(); // Gets user input

                                car = new Car(); // Creates new Car object
                                car.deleteStatement(deleteData); // Calls method deleteStatement from Car.java with parameter deleteData

                                break; // Exits switch block

                        }
                    }

                    // Exits system
                    System.out.println("Exiting System...");
                    System.exit(0);

                case 4:

                    // CUSTOMER
                    Customer customer;
                    menu = 0; // Sets menu to 0 for submenu selection

                    // While loop that will run only if menu is not equal to 5
                    while (menu != 5) {
                        System.out.println("1: Select, 2: Insert, 3: Update, 4: Delete, 5: Exit");
                        menu = Integer.parseInt(input.nextLine()); // Gets user input

                        // switch : case statements (Customer)
                        switch (menu) {
                            case 1:
                                // SELECT

                                customer = new Customer(); // Creates new Customer object
                                customer.selectStatement(); // Calls method selectStatement from Customer.java

                                break; // Exits switch block

                            case 2:
                                // INSERT

                                System.out.println("Enter the data in the following format: customerID,forename,surname,address,postcode,phoneNo");
                                String insertData = input.nextLine(); // Gets user input

                                customer = new Customer(); // Creates new Customer object
                                customer.insertStatement(insertData); // Calls method deleteStatement from Customer.java with parameter insertData

                                break; // Exits switch block

                            case 3:
                                // UPDATE

                                System.out.println("Enter the reg number you want to update:");
                                String customerID = input.nextLine(); // Gets user input

                                System.out.println("Which column would you like to update?\n1: forename\n2: surname\n3: address\n4: postcode\n5: phoneNo");
                                int choice = Integer.parseInt(input.nextLine()); // Gets user input

                                String column = "";

                                switch (choice) {
                                    case 1:
                                        column = "forename";
                                        break; // Exits switch block

                                    case 2:
                                        column = "surname";
                                        break; // Exits switch block

                                    case 3:
                                        column = "address";
                                        break; // Exits switch block

                                    case 4:
                                        column = "postcode";
                                        break; // Exits switch block

                                    case 5:
                                        column = "phoneNo";
                                        break; // Exits switch block

                                    default:
                                        System.out.println("Invalid choice!");
                                        return;
                                }

                                System.out.println("Enter the new value:");
                                String newValue = input.nextLine(); // Gets user input

                                customer = new Customer(); // Creates new Customer object
                                customer.updateStatement(customerID, column, newValue); // Calls method updateStatement from Customer.java with parameters customerID, column, newValue

                                break; // Exits switch block
                            case 4:
                                // DELETE

                                System.out.println("Enter the customer ID");
                                String deleteData = input.nextLine(); // Gets user input

                                customer = new Customer(); // Creates new Customer object
                                customer.deleteStatement(deleteData); // Calls method deleteStatement from Customer.java with parameter deleteData

                                break; // Exits switch block
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
