package com.ODanielFilho.api_pcd_project.repository;

import com.ODanielFilho.api_pcd_project.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
