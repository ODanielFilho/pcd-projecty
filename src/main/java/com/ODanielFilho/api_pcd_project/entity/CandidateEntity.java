package com.ODanielFilho.api_pcd_project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_candidates")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CandidateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long candidateId;
    private String name;
    private String document;
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity userId;


}
