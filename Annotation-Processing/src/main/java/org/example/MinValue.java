package org.example;

import java.lang.annotation.*;

/**
 * Specifies the minimum allowed value for a field.
 *
 * This annotation can be used to enforce that the annotated field's value is greater than or equal
 * to the specified minimum value. The annotation is retained at runtime for reflection-based validation.
 *
 * @see java.lang.annotation.Retention
 * @see java.lang.annotation.RetentionPolicy
 * @see java.lang.annotation.ElementType
 * @see java.lang.annotation.Target
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.FIELD)
public @interface MinValue {
    int value();
}
