package com.recruitment.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.recruitment.exception.CandidateAlreadyExistsException;
import com.recruitment.model.Candidate;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RecruitmentServiceImpl implements IRecruitmentService {

	private static List<Candidate> candidateList = new ArrayList<Candidate>();

	/*
	 * This method should add the candidate object to the candidateList, before
	 * adding it shoulkd check whether the email id of the candidate is already
	 * available, if available throw an exception else add the candidate object into
	 * the list
	 */
	public Candidate registerCandidate(Candidate candidate) throws CandidateAlreadyExistsException {
		// TODO Auto-generated method stub
		String email = candidate.getEmailId();
		Optional<Candidate> fetchedCandidate = candidateList.stream().filter(candi -> candi.getEmailId().equals(email))
				.findAny();
		if(fetchedCandidate.isPresent()) {
			log.error("Candidate already exists with us");
			throw new CandidateAlreadyExistsException("Candidate already exists with us");
		} else {
			candidateList.add(candidate);
			log.info("Candidate with id " + candidate.getCandidateId() + "registered successfully");
		}
		return candidate;
	}

	/*
	 * This method should return the Map as position applied for as a key and list
	 * of candidates who applied for that position as value.
	 */
	public Map<String, List<Candidate>> viewCandidateBasedonPosition() {
		// TODO Auto-generated method stub
		Map<String, List<Candidate>> map = new HashMap<>();
		
		for(Candidate candidate : candidateList) {
			String key = candidate.getPositionAppliedFor();
			List<Candidate> value = map.getOrDefault(key, new ArrayList<>());
			value.add(candidate);
			
			map.put(key, value);
		}
		log.info("View candidate based on position is successful");
		return map;
	}

	/*
	 * This method should accept the years of experience as input and it should
	 * iterate the candidateList and return the list of candidates who have that
	 * experience.
	 */
	public List<Candidate> filterCandidate(int yearsOfExperience) {
		// TODO Auto-generated method stub
		List<Candidate> filteredCandidates = candidateList.stream()
				.filter(candidate -> candidate.getYearsOfExperience()==yearsOfExperience)
				.collect(Collectors.toUnmodifiableList());
		log.info("View candidate based on the experience is successfully done");
		return filteredCandidates;
	}

	/*
	 * This method should remove the candidate based on the status. If the status is
	 * recruited then remove all those candidates. This method should return the
	 * number of candidates removed.
	 */
	public int removeCandidate() {
		// TODO Auto-generated method stub
		long count = candidateList.stream().filter(candidate -> candidate.getStatus().equals("recruited")).count();
		candidateList.removeIf(candidate -> candidate.getStatus().equals("recruited"));
//		List<Candidate> candidates = candidateList;
//		for(Candidate candidate  : candidates) {
//			if(candidate.getStatus().equals("recruited")) {
//				candidateList.remove(candidate);
//				count++;
//			}
//		}
		log.info(count + " candidate recruited via Employ Me");
		return (int) count;
	}

	public static List<Candidate> getCandidateList() {
		return candidateList;
	}

	public static void setCandidateList(List<Candidate> candidateList) {
		RecruitmentServiceImpl.candidateList = candidateList;
	}

}
