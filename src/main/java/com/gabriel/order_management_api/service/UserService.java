package com.gabriel.order_management_api.service;

import com.gabriel.order_management_api.dto.UserDTO;
import com.gabriel.order_management_api.entity.User;
import com.gabriel.order_management_api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public UserDTO toDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail() );
    }


    public UserDTO create(User user) {
        User saved = repository.save(user);
        return toDTO(saved);
    }

    public List<UserDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }
}
