package com.validate;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.model.RegistrationBean;

@Component
public class CustomValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return RegistrationBean.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        RegistrationBean registration = (RegistrationBean) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "field.required", "user Name cannot be blank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactNumber", "field.required", "Contact Number should be of 10 digits/Contact Number should not be blank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId", "field.required", "Email ID cannot be blank Should be a proper email ID format");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmEmailId", "field.required", "Confirm Email ID cannot be blank Should be a proper email ID format");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "status", "field.required", "Please agree to the terms and conditions");
        
        if (registration.getContactNumber() != 0 && String.valueOf(registration.getContactNumber()).length() != 10) {
            errors.rejectValue("contactNumber", "field.invalid", "Contact Number should be of 10 digits/Contact Number should not be blank");
        }
        if (!registration.getEmailId().matches(".*@.*.com")) {
            errors.rejectValue("confirmEmailId", "field.invalid", "Email and Confirm Email should be same");
        }
        if (!registration.getEmailId().equals(registration.getConfirmEmailId())) {
            errors.rejectValue("confirmEmailId", "field.invalid", "Email and Confirm Email should be same");
        }
        if (!registration.isStatus()) {
            errors.rejectValue("status", "field.invalid", "please agree to the terms and conditions");
        }
    }
}