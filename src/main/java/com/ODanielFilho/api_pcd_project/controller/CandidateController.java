package com.ODanielFilho.api_pcd_project.controller;

import com.ODanielFilho.api_pcd_project.dto.CandidateDTO;
import com.ODanielFilho.api_pcd_project.entity.CandidateEntity;
import com.ODanielFilho.api_pcd_project.service.CandidateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/candidates")
public class CandidateController {
    private final CandidateService service;

    public CandidateController(CandidateService service) {
        this.service = service;
    }

    @PostMapping("/users/{userId}")
    public ResponseEntity<CandidateEntity> createCandidate(@PathVariable Long userId, @RequestBody CandidateDTO dto){
        CandidateEntity candidate =  service.createCandidate(userId, dto);
        return ResponseEntity.ok(candidate);
    }
}
