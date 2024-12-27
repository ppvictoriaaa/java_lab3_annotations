package org.example;

/**
 * This class provides methods for generating SQL queries related to medicines.
 */
public class MedicineSQLGenerator {

    /**
     * Generates an SQL INSERT query for adding a medicine to the database.
     *
     * @param medicine the Medicine object containing the details to insert.
     * @return a formatted SQL INSERT query string.
     */
    public String generateInsertQuery(Medicine medicine) {
        return String.format("INSERT INTO medicines (name, assignment, minAge, maxAge) VALUES ('%s', '%s', %d, %d);",
                medicine.getName(), medicine.getAssignment(), medicine.getMinAge(), medicine.getMaxAge());
    }

    /**
     * Generates an SQL DELETE query for removing a medicine from the database by its ID.
     *
     * @param id the ID of the medicine to delete.
     * @return a formatted SQL DELETE query string.
     */
    public static String generateDeleteQuery(int id) {
        return String.format("DELETE FROM medicines WHERE id = %d;", id);
    }
}


