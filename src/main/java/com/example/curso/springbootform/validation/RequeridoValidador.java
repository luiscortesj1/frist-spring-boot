package com.example.curso.springbootform.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.thymeleaf.util.StringUtils;

public class RequeridoValidador implements ConstraintValidator<Requerido,String> {
    @Override
    public boolean isValid(String t, ConstraintValidatorContext constraintValidatorContext) {
        if(t == null || t.isEmpty() || t.isBlank()){
            return false;
        }
        return true;
    }
}
