package com.gabriel.order_management_api.controllers;

import com.gabriel.order_management_api.dto.OrderDTO;
import com.gabriel.order_management_api.entity.Order;
import com.gabriel.order_management_api.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")

public class OrderController {
    private final OrderService service;

    public OrderController (OrderService service) {
        this.service = service;
    }

    @PostMapping
    public OrderDTO create(@RequestBody OrderDTO dto) {
        Order order = service.toEntity(dto);
        return service.create(order);
    }

    @GetMapping
    public List<OrderDTO> list() {
        return service.findAll();
    }


}
