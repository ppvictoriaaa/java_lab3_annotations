package org.example;

import java.lang.annotation.*;

/**
 * Indicates that a field must not be null.
 *
 * This annotation can be used for validation purposes to ensure that the annotated field is not null.
 * It is retained at runtime and can be accessed via reflection.
 *
 * @see java.lang.annotation.Retention
 * @see java.lang.annotation.RetentionPolicy
 * @see java.lang.annotation.ElementType
 * @see java.lang.annotation.Target
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.FIELD)
public @interface NotNull {}