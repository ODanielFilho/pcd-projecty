package com.ODanielFilho.api_pcd_project.service;

import com.ODanielFilho.api_pcd_project.dto.CandidateDTO;
import com.ODanielFilho.api_pcd_project.entity.CandidateEntity;
import com.ODanielFilho.api_pcd_project.entity.UserEntity;
import com.ODanielFilho.api_pcd_project.repository.CandidateRepository;
import com.ODanielFilho.api_pcd_project.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {
    private  final CandidateRepository repository;
    private final UserRepository userRepository;

    public CandidateService(CandidateRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    public CandidateEntity createCandidate(Long id, CandidateDTO dto) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        var candidate = new CandidateEntity();
        candidate.setName(dto.name());
        candidate.setDocument(dto.document());
        candidate.setUserId(user);
        return repository.save(candidate);
    }
}
