package org.example;

import java.lang.annotation.*;

/**
 * Specifies the minimum and maximum length constraints for a string field.
 *
 * This annotation can be used for validating the length of a string field. The `min` and `max`
 * values define the allowed range for the string length. The annotation is retained at runtime
 * for reflection-based validation.
 *
 * @see java.lang.annotation.Retention
 * @see java.lang.annotation.RetentionPolicy
 * @see java.lang.annotation.ElementType
 * @see java.lang.annotation.Target
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.FIELD)
public @interface StringLength {
    int min() default 0;
    int max() default Integer.MAX_VALUE;
}