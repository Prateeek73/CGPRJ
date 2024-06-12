package com.validate;

import com.model.Candidate;

import org.springframework.validation.Validator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Component
public class CustomValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Candidate.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// fill code to do validation for candidate name and contact number
		Candidate candidate = (Candidate) target;

		if (candidate.getCandidateName().isEmpty()) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "candidateName", "field.required",
					"Name cannot be blank");
		} else if (!candidate.getCandidateName().matches("^[a-zA-Z\\s]{3,10}$")) {
			errors.rejectValue("candidateName", "field.invalid",
					"Name should contain only alphabets and space min 3 chars and max 10 chars");
		}

		if (candidate.getContactNumber().isEmpty()) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactNumber", "field.required",
					"Contact number should not be blank");
		} else if (!candidate.getContactNumber().matches("^[6-9]\\d{9}$")) {
			errors.rejectValue("contactNumber", "field.invalid",
					"Contact Number should be of 10 digits/Contact Number should start with range 6 to 9");
		}

		if (candidate.getExpectedSalary() < 10000) {
			errors.rejectValue("expectedSalary", "field.invalid", "must be greater than or equal to 200000");
		} else if (candidate.getExpectedSalary() > 200000) {
			errors.rejectValue("expectedSalary", "field.invalid", "must be less than or equal to 200000");
		}

		if (candidate.getYearsOfExperience() < 0) {
			errors.rejectValue("yearsOfExperience", "field.invalid", "must be greater than or equal to 0");
		}
	}
}
