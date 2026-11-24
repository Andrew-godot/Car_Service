import tables.Garage;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static void main(String[] args) throws SQLException {

        Scanner input = new Scanner(System.in); // Scanner object

        // Define Variables
        int menu = 0;

        while (menu != 5) {
            System.out.println("1: Garage, 2: Job, 3: Car, 4: Customer, 5: Exit");
            menu = Integer.parseInt(input.nextLine());

            switch (menu) {
                case 1:

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
                                String newData = input.nextLine();

                                garage = new Garage();
                                garage.insertStatement(newData);

                                break;



                            case 3:
                                // UPDATE



                            case 4:
                                // DELETE



                        }

                        break;
                    }

                case 2:
                    menu = 0;

                    while (menu != 5) {
                        System.out.println("1: Select, 2: Insert, 3: Update, 4: Delete, 5: Exit");
                        menu = Integer.parseInt(input.nextLine());
                    }
                case 3:
                    menu = 0;

                    while (menu != 5) {
                        System.out.println("1: Select, 2: Insert, 3: Update, 4: Delete, 5: Exit");
                        menu = Integer.parseInt(input.nextLine());
                    }
                case 4:
                    menu = 0;

                    while (menu != 5) {
                        System.out.println("1: Select, 2: Insert, 3: Update, 4: Delete, 5: Exit");
                        menu = Integer.parseInt(input.nextLine());
                    }

            } break;


        }
    }
}
