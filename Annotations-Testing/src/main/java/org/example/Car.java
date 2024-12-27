package org.example;


/**
 * Represents a car with a brand, model, and manufacturing year.
 *
 * This class demonstrates the use of validation annotations to ensure that the fields meet
 * specific constraints:
 * - {@link NotNull}: Ensures that the brand is not null.
 * - {@link StringLength}: Ensures that the model name is between 2 and 20 characters.
 * - {@link MaxValue} and {@link MinValue}: Ensures that the manufacturing year is between 1990 and 2024.
 *
 * @see NotNull
 * @see StringLength
 * @see MaxValue
 * @see MinValue
 */
public class Car {

    @NotNull
    private String brand;

    @StringLength(min = 2, max = 10)
    private String modal;

    @MaxValue(2024)
    @MinValue(1990)
    private Integer year;

    /**
     * Constructs a new Car with the specified brand, model, and year.
     *
     * @param brand The brand of the car. Cannot be null.
     * @param modal The model of the car. Must be between 2 and 20 characters long.
     * @param year The manufacturing year of the car. Must be between 1990 and 2024.
     */
    public Car(String brand, String modal, Integer year) {
        this.brand = brand;
        this.modal = modal;
        this.year = year;
    }

    /**
     * Gets the brand of the car.
     *
     * @return The brand of the car.
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Gets the model of the car.
     *
     * @return The model of the car.
     */
    public String getModal() {
        return modal;
    }

    /**
     * Gets the manufacturing year of the car.
     *
     * @return The manufacturing year of the car.
     */
    public Integer getYear() {
        return year;
    }
}
