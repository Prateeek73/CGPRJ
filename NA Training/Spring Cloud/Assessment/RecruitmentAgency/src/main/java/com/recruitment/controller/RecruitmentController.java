package com.recruitment.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recruitment.exception.CandidateAlreadyExistsException;
import com.recruitment.model.Candidate;
import com.recruitment.service.IRecruitmentService;

import jakarta.validation.Valid;

@RestController
public class RecruitmentController {
	
	@Autowired
	private IRecruitmentService recruitmentService;
	
	@PostMapping(value = "/register")
	public Candidate registerCandidate(@Valid @RequestBody Candidate candidate) throws CandidateAlreadyExistsException {
		return recruitmentService.registerCandidate(candidate);
	}
	
	@GetMapping(value = "/view")
	public Map<String,List<Candidate>> viewCandidateBasedonPosition(){
		return recruitmentService.viewCandidateBasedonPosition();
	}
	
	@GetMapping(value = "/filter/{yearsOfExperience}")
	public List<Candidate> filterCandidate(@PathVariable int yearsOfExperience){
		return recruitmentService.filterCandidate(yearsOfExperience);
	}
	
	@DeleteMapping(value = "/remove")
	public int removeCandidate() {
		return recruitmentService.removeCandidate();
	}
}