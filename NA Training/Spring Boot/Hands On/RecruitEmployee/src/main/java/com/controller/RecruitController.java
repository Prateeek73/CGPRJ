package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.model.Candidate;
import com.service.RecruitService;
import com.validate.CustomValidator;

import jakarta.validation.Valid;

@Controller
public class RecruitController {

	@Autowired
	private CustomValidator custValidator;

	@Autowired
	private RecruitService service;

	
	@GetMapping("/home")
	public String showIndexPage() {
		// fill code
		return "index";
	}

	@GetMapping("/showCandidatePage")
	public String showPage(@ModelAttribute("candidate") Candidate candidate) {
		// fill code
		return "showPage";
	}

	@PostMapping("/register")
	public String registerCandidate(@ModelAttribute("candidate") Candidate candidate, BindingResult result, ModelMap model) {
		// fill code
		custValidator.validate(candidate, result);
		if (result.hasErrors()) {
			return "showPage";
		}
		
		service.insertCandidate(candidate);
		model.addAttribute("candidateName", candidate.getCandidateName());
		return "success";
	}

	@GetMapping("/viewAllCandidateList")
	public String viewAllCandidates(ModelMap model) {
		// fill code
		List<Candidate> candidateList = service.viewAllCandidates();
	
		model.addAttribute("candidateList", candidateList);
		return "viewList";
	}
	
	@ModelAttribute("positionDtls")
	public ArrayList<String> populatePositionDtls() {
		// fill code
		ArrayList<String> positionDtls = new ArrayList<>();
		positionDtls.add("TL");
		positionDtls.add("PL");
		positionDtls.add("Developer");
		positionDtls.add("Tester");
		positionDtls.add("Admin");
		return positionDtls;
	}
}
