package com.app.fx.validator;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;
import java.util.List;

public class LengthValidator implements ConstraintValidator<ValidLength, String > {

    @Override
    public boolean isValid(String currency, ConstraintValidatorContext context) {

          if(currency.length()!=3){ return false;}

        return  true;

    }
}