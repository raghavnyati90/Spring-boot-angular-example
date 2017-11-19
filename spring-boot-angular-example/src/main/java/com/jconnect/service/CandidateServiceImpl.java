package com.jconnect.service;

import com.jconnect.domain.Candidate;
import com.jconnect.repo.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public Candidate getCandidateById(Long id){
        return candidateRepository.findOne(id);
    }

    public Candidate createCandidate(Candidate candidate){
        return candidateRepository.save(candidate);
    }

    public Candidate updateCandidate(Candidate candidate){
        return candidateRepository.save(candidate);
    }

    public void deleteCandidate(Long id){
        Candidate user = getCandidateById(id);
        if (user != null) {
            candidateRepository.delete(id);
        }
    }
}
