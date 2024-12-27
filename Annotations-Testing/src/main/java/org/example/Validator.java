package org.example;

import java.lang.reflect.Field;

/**
 * Utility class to validate fields of an object based on annotations.
 *
 * This class provides a static method `validate` that checks the fields of the provided object for specific
 * annotations. It throws an `IllegalArgumentException` if any validation rules specified by the annotations
 * are violated.
 *
 * The following annotations are supported:
 * - {@link NotNull}: Ensures that the field is not null.
 * - {@link StringLength}: Ensures that the string field length is within the specified range.
 * - {@link MaxValue}: Ensures that the integer field is not greater than the specified maximum value.
 * - {@link MinValue}: Ensures that the integer field is not less than the specified minimum value.
 *
 * @see NotNull
 * @see StringLength
 * @see MaxValue
 * @see MinValue
 */
public class Validator {
    /**
     * Validates the fields of the given object based on the annotations present.
     *
     * This method checks each field of the provided object for the following annotations:
     * - {@link NotNull}: Throws an exception if the field is null.
     * - {@link StringLength}: Throws an exception if the string's length is outside the specified bounds.
     * - {@link MaxValue}: Throws an exception if the integer value exceeds the maximum allowed value.
     * - {@link MinValue}: Throws an exception if the integer value is below the minimum allowed value.
     *
     * @param object The object whose fields are to be validated.
     * @throws Exception If any validation fails, an {@link IllegalArgumentException} is thrown.
     */
    public static void validate(Object object) throws Exception {
        Class<?> clazz = object.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(object);

            // Check for @NotNull annotation
            if (field.isAnnotationPresent(NotNull.class)) {
                if (value == null) {
                    throw new IllegalArgumentException("Field '" + field.getName() + "' must not be null.");
                }
            }

            // Check for @StringLength annotation
            if (field.isAnnotationPresent(StringLength.class)) {
                if (value != null && !(value instanceof String)) {
                    throw new IllegalArgumentException("Field '" + field.getName() + "' must be of type String for @StringLength.");
                }
                StringLength stringLength = field.getAnnotation(StringLength.class);
                if (value != null) {
                    String strValue = (String) value;
                    if (strValue.length() < stringLength.min() || strValue.length() > stringLength.max()) {
                        throw new IllegalArgumentException("Field '" + field.getName() + "' length must be between " +
                                stringLength.min() + " and " + stringLength.max() + ".");
                    }
                }
            }

            // Check for @MaxValue annotation
            if (field.isAnnotationPresent(MaxValue.class)) {
                if (value != null && !(value instanceof Integer)) {
                    throw new IllegalArgumentException("Field '" + field.getName() + "' must be of type Integer for @MaxValue.");
                }
                MaxValue maxValue = field.getAnnotation(MaxValue.class);
                if (value != null) {
                    int intValue = (Integer) value;
                    if (intValue > maxValue.value()) {
                        throw new IllegalArgumentException("Field '" + field.getName() + "' must not be greater than " + maxValue.value() + ".");
                    }
                }
            }

            // Check for @MinValue annotation
            if (field.isAnnotationPresent(MinValue.class)) {
                if (value != null && !(value instanceof Integer)) {
                    throw new IllegalArgumentException("Field '" + field.getName() + "' must be of type Integer for @MinValue.");
                }
                MinValue minValue = field.getAnnotation(MinValue.class);
                if (value != null) {
                    int intValue = (Integer) value;
                    if (intValue < minValue.value()) {
                        throw new IllegalArgumentException("Field '" + field.getName() + "' must not be less than " + minValue.value() + ".");
                    }
                }
            }
        }
    }
}
