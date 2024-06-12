package com.recruitment.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Candidate {
	
	@NotNull(message = "Provide value for candidate Id")
	private String candidateId	;
	private String candidateName;	
	@NotNull(message = "Provide value for mobile number")
	private String mobileNumber	;
	@NotEmpty(message = "Provide value for email Id")
	private String emailId	;
	private String positionAppliedFor	;
	private Integer yearsOfExperience	;
	@Min(value = 0, message = "Provide value greater than or equal to zero")
	private double expectedSalary	;
	
	private String Status	;


	





	public Candidate() {
		
	}

	public Candidate(String candidateId, String candidateName, String mobileNumber, String emailId,
			String positionAppliedFor, Integer yearsOfExperience, double expectedSalary, String status) {
		super();
		this.candidateId = candidateId;
		this.candidateName = candidateName;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.positionAppliedFor = positionAppliedFor;
		this.yearsOfExperience = yearsOfExperience;
		this.expectedSalary = expectedSalary;
		Status = status;
	}

}
