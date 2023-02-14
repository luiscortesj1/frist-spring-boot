package com.example.curso.springbootform.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = RequeridoValidador.class)
@Retention(RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface Requerido {
    String message() default "El campo es requerido, por Anotación ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
