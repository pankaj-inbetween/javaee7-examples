package org.shekhar.javaee7_examples.bean_validation;

import org.hibernate.validator.constraints.URL;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by shekhargulati on 02/04/14.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@URL
@Constraint(validatedBy = {UniqueUrlConstraintValidator.class})
public @interface UniqueUrl {

    String message() default "Url should be unique";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
