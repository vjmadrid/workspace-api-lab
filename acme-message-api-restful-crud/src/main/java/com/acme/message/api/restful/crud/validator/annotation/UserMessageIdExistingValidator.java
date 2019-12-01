package com.acme.message.api.restful.crud.validator.annotation;

import java.util.Objects;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.acme.message.api.restful.crud.service.UserMessageService;

public class UserMessageIdExistingValidator implements ConstraintValidator<UserMessageIdExisting, Long> {

	@Autowired
    private UserMessageService userMessageService;

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        return Objects.isNull(id) || userMessageService.findByPK(id).isPresent();
    }
	
}
