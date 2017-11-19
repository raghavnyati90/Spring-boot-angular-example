package com.jconnect.service;

import com.jconnect.domain.Candidate;

public interface CandidateService {

    Candidate getCandidateById(Long id);

    Candidate createCandidate(Candidate candidate);

    Candidate updateCandidate(Candidate candidate);

    void deleteCandidate(Long id);

}
