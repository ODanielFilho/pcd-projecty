package com.ODanielFilho.api_pcd_project.dto;

import com.ODanielFilho.api_pcd_project.entity.UserEntity;

public record LoginDTO(Long id,
                       String username,
                       String email,
                       String password) {
    public static LoginDTO fromEntity(UserEntity user) {
        return new LoginDTO(user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword());
    }
}
