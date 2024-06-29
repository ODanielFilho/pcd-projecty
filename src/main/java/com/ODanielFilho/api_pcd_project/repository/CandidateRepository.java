package com.ODanielFilho.api_pcd_project.repository;

import com.ODanielFilho.api_pcd_project.entity.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<CandidateEntity, Long> {
}
