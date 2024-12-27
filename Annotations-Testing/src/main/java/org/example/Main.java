package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * The main class for managing database operations based on user input.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        // Prompt the user to enter a command (INSERT or DELETE)
        System.out.print("Enter DELETE or INSERT: ");
        String command = scan.nextLine();

        Test test = new Test("vasya", 55);

        // Create a list of sample objects to work with
        List<Object> objects = new ArrayList<>();
        objects.add(new Car("Fiat", "Doblo", 2013));
        objects.add(new Person("Phillip Morris", "Doctor", 45));
        objects.add(new Medicine("Triaxone", "Antibiotic", 21, 50));
        objects.add(new Car("Volvo", "XC90", 2023));
        objects.add(new Person("Lui Jonn", "Mathematic", 38));
        objects.add(new Medicine("Nimesil", "Painkiller", 16, 85));

        // Handle the "INSERT" command
        if (Objects.equals(command, "INSERT")) {
            try {
                for (Object obj : objects) {
                    // Validate the object before generating and executing the query
                    Validator.validate(obj);

                    // Generate the appropriate SQL INSERT query
                    String insertQuery = generateInsertQuery(obj);
                    if (insertQuery != null) {
                        System.out.println("Generated query: " + insertQuery);

                        // Execute the SQL query
                        DataBaseConnection.executeQuery(insertQuery);
                    } else {
                        System.err.println("No SQL generator found for class: " + obj.getClass().getSimpleName());
                    }
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        // Handle the "DELETE" command
        else if (Objects.equals(command, "DELETE")) {
            // Prompt the user for IDs to delete from the database
            System.out.print("Enter carIdToDelete: ");
            int carIdToDelete = scan.nextInt();
            System.out.print("Enter personIdToDelete: ");
            int personIdToDelete = scan.nextInt();
            System.out.print("Enter medicineIdToDelete: ");
            int medicineIdToDelete = scan.nextInt();

            // Generate DELETE queries for each ID
            String carDeleteQuery = CarSQLGenerator.generateDeleteQuery(carIdToDelete);
            String personDeleteQuery = PersonSQLGenerator.generateDeleteQuery(personIdToDelete);
            String medicineDeleteQuery = MedicineSQLGenerator.generateDeleteQuery(medicineIdToDelete);

            System.out.println("Deleting data...");

            // Execute the DELETE queries
            DataBaseConnection.executeQuery(carDeleteQuery);
            DataBaseConnection.executeQuery(personDeleteQuery);
            DataBaseConnection.executeQuery(medicineDeleteQuery);
        }
        // Handle invalid commands
        else {
            System.out.println("You entered wrong command");
        }
    }

    /**
     * Generates an SQL INSERT query for the given object based on its type.
     *
     * @param obj the object for which the SQL INSERT query is generated.
     * @return a formatted SQL INSERT query string or null if the type is unsupported.
     */
    private static String generateInsertQuery(Object obj) {
        // Check if the object is a Car
        if (obj instanceof Car) {
            CarSQLGenerator generator = new CarSQLGenerator();
            return generator.generateInsertQuery((Car) obj);
        }
        // Check if the object is a Person
        else if (obj instanceof Person) {
            PersonSQLGenerator generator = new PersonSQLGenerator();
            return generator.generateInsertQuery((Person) obj);
        }
        // Check if the object is a Medicine
        else if (obj instanceof Medicine) {
            MedicineSQLGenerator generator = new MedicineSQLGenerator();
            return generator.generateInsertQuery((Medicine) obj);
        }
        // Return null if no matching generator is found
        return null;
    }
}






