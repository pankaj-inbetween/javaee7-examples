package org.shekhar.javaee7_examples.bean_validation;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by shekhargulati on 02/04/14.
 */
public class UniqueUrlConstraintValidator implements ConstraintValidator<UniqueUrl, String> {

    @Inject
    private UrlService urlService;

    @Override
    public void initialize(UniqueUrl uniqueUrl) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.length() == 0) {
            return true;
        }
        return urlService.exists(value) ? false : true;
    }
}
