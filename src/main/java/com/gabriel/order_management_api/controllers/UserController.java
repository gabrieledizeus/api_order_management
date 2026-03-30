package com.gabriel.order_management_api.controllers;

import com.gabriel.order_management_api.dto.UserDTO;
import com.gabriel.order_management_api.entity.User;
import com.gabriel.order_management_api.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController (UserService service) {
        this.service = service;
    }

    @PostMapping
    public UserDTO create(@RequestBody User user) {
        return service.create(user);
    }

    @GetMapping
    public List<UserDTO> list() {
        return service.findAll();
    }
}
