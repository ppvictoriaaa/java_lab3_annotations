package org.example;

/**
 * This class provides methods for generating SQL queries related to cars.
 */
public class CarSQLGenerator {

    /**
     * Generates an SQL INSERT query for adding a car to the database.
     *
     * @param car the Car object containing the details to insert.
     * @return a formatted SQL INSERT query string.
     */
    public String generateInsertQuery(Car car) {
        return String.format("INSERT INTO cars (brand, modal, year) VALUES ('%s', '%s', %d);",
                car.getBrand(), car.getModal(), car.getYear());
    }

    /**
     * Generates an SQL DELETE query for removing a car from the database by its ID.
     *
     * @param id the ID of the car to delete.
     * @return a formatted SQL DELETE query string.
     */
    public static String generateDeleteQuery(int id) {
        return String.format("DELETE FROM cars WHERE id = %d;", id);
    }
}


