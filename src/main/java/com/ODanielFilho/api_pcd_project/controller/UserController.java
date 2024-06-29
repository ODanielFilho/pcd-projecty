package com.ODanielFilho.api_pcd_project.controller;

import com.ODanielFilho.api_pcd_project.dto.LoginDTO;
import com.ODanielFilho.api_pcd_project.dto.RegisterRequestDTO;
import com.ODanielFilho.api_pcd_project.dto.UpdateRequestDTO;
import com.ODanielFilho.api_pcd_project.entity.UserEntity;
import com.ODanielFilho.api_pcd_project.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<UserEntity> create(@RequestBody RegisterRequestDTO request) {
        var user = service.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
    @GetMapping
    public ResponseEntity<Page<LoginDTO>> listAll(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                                  @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        var body = service.listAll(page, pageSize);
        return ResponseEntity.ok(body);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoginDTO> findById(@PathVariable(value = "id") Long id) {
        var body = service.findById(id);
        return ResponseEntity.ok(body);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> update(@PathVariable(value = "id") Long id,
                                       @RequestBody UpdateRequestDTO request) {
        UserEntity updatedUser = service.update(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(value = "id") Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

