package com.app.fx.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = LengthValidator.class)
@Documented
public @interface ValidLength {

    String message() default "Invalid length. Should be equal to 3";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
