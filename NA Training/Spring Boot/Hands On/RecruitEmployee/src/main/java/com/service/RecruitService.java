package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.model.Candidate;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RecruitService {

	List<Candidate> candidateList = new ArrayList<>();
	
	public void setCandidateist(List<Candidate> candidateList) {
		this.candidateList=candidateList;
	}

	public List<Candidate> getCandidateList() {
		return candidateList;
	}

	public void insertCandidate(Candidate candidate) {
		//fill code to add the candidate object to candidateList
		candidateList.add(candidate);
        log.info("Candidate details added successfully: {}", candidate.getCandidateName());
	}
	
	public List<Candidate> viewAllCandidates(){
		//return list of candidates
		if (candidateList.isEmpty()) {
            log.error("Candidate List is empty");
        } else {
            log.info("Candidate details are Listed");
        }
        return candidateList;		
	}
}
