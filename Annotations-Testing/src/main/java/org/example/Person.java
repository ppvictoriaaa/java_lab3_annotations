package org.example;



/**
 * Represents a person with a name, job, and age.
 *
 * This class demonstrates the use of validation annotations to ensure that the fields meet
 * certain constraints:
 * - {@link NotNull}: Ensures that the name is not null.
 * - {@link StringLength}: Ensures that the job string length is between 3 and 20 characters.
 * - {@link MaxValue} and {@link MinValue}: Ensures that the age is between 18 and 100.
 *
 * @see NotNull
 * @see StringLength
 * @see MaxValue
 * @see MinValue
 */
public class Person {

    @NotNull
    private String name;

    @StringLength(min = 3, max = 20)
    private String job;

    @MaxValue(100)
    @MinValue(18)
    private Integer age;

    /**
     * Constructs a new Person with the specified name, job, and age.
     *
     * @param name The name of the person. Cannot be null.
     * @param job The job of the person. Must be between 3 and 20 characters long.
     * @param age The age of the person. Must be between 18 and 100.
     */
    public Person(String name, String job, Integer age) {
        this.name = name;
        this.job = job;
        this.age = age;
    }

    /**
     * Gets the name of the person.
     *
     * @return The name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the age of the person.
     *
     * @return The age of the person.
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Gets the job of the person.
     *
     * @return The job of the person.
     */
    public String getJob() {
        return job;
    }
}

