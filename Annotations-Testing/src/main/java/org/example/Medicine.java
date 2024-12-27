package org.example;



/**
 * Represents a medicine with a name, assignment, and age restrictions.
 *
 * This class demonstrates the use of validation annotations to ensure that the fields meet
 * specific constraints:
 * - {@link NotNull}: Ensures that the name is not null.
 * - {@link StringLength}: Ensures that the assignment (purpose) string length is between 3 and 20 characters.
 * - {@link MinValue}: Ensures that the minimum age is at least 12.
 * - {@link MaxValue}: Ensures that the maximum age is no more than 80.
 *
 * @see NotNull
 * @see StringLength
 * @see MinValue
 * @see MaxValue
 */
public class Medicine {

    @NotNull
    private String name;

    @StringLength(min = 3, max = 20)
    private String assignment;

    @MinValue(12)
    private Integer minAge;

    @MaxValue(80)
    private Integer maxAge;

    /**
     * Constructs a new Medicine with the specified name, assignment, and age restrictions.
     *
     * @param name The name of the medicine. Cannot be null.
     * @param assignment The assignment (purpose) of the medicine. Must be between 3 and 20 characters long.
     * @param minAge The minimum age required for using the medicine. Must be at least 12.
     * @param maxAge The maximum age allowed for using the medicine. Must be no more than 80.
     */
    public Medicine(String name, String assignment, Integer minAge, Integer maxAge) {
        this.name = name;
        this.assignment = assignment;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    /**
     * Gets the name of the medicine.
     *
     * @return The name of the medicine.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the assignment (purpose) of the medicine.
     *
     * @return The assignment of the medicine.
     */
    public String getAssignment() {
        return assignment;
    }

    /**
     * Gets the minimum age required for using the medicine.
     *
     * @return The minimum age for the medicine.
     */
    public Integer getMinAge() {
        return minAge;
    }

    /**
     * Gets the maximum age allowed for using the medicine.
     *
     * @return The maximum age for the medicine.
     */
    public Integer getMaxAge() {
        return maxAge;
    }
}
