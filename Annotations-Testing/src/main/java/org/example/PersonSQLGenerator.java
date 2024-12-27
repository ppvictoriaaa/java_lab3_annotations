package org.example;

/**
 * This class provides methods for generating SQL queries related to persons.
 */
public class PersonSQLGenerator {

    /**
     * Generates an SQL INSERT query for adding a person to the database.
     *
     * @param person the Person object containing the details to insert.
     * @return a formatted SQL INSERT query string.
     */
    public String generateInsertQuery(Person person) {
        return String.format("INSERT INTO persons (name, job, age) VALUES ('%s', '%s', %d);",
                person.getName(), person.getJob(), person.getAge());
    }

    /**
     * Generates an SQL DELETE query for removing a person from the database by their ID.
     *
     * @param id the ID of the person to delete.
     * @return a formatted SQL DELETE query string.
     */
    public static String generateDeleteQuery(int id) {
        return String.format("DELETE FROM persons WHERE id = %d;", id);
    }
}


