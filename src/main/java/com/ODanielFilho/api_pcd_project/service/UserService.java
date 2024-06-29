package com.ODanielFilho.api_pcd_project.service;

import com.ODanielFilho.api_pcd_project.dto.LoginDTO;
import com.ODanielFilho.api_pcd_project.dto.RegisterRequestDTO;
import com.ODanielFilho.api_pcd_project.dto.UpdateRequestDTO;
import com.ODanielFilho.api_pcd_project.entity.UserEntity;
import com.ODanielFilho.api_pcd_project.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public UserEntity createUser(RegisterRequestDTO dto) {
        var user = new UserEntity();
        user.setUsername(dto.username());
        user.setEmail(dto.email());
        user.setPassword(dto.password());
        repository.save(user);
        return user;
    }

    public LoginDTO findById(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return LoginDTO.fromEntity(entity);
    }

    public Page<LoginDTO> listAll(int page, int pageSize) {
        var content = repository.findAll(PageRequest.of(page, pageSize));
        return content.map(LoginDTO::fromEntity);
    }

    public UserEntity update(Long id, UpdateRequestDTO request) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        entity.setPassword(request.password());
        entity.setEmail(request.email());
        entity.setUsername(request.username());
        repository.save(entity);
        return entity;
    }

    public void deleteById(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        repository.deleteById(entity.getId());
    }
}
