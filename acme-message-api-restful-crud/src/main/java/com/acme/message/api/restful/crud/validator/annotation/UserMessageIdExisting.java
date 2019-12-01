package com.acme.message.api.restful.crud.validator.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = UserMessageIdExistingValidator.class)
public @interface UserMessageIdExisting {

	String message() default "{UserMessageIdExisting}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
	
}
