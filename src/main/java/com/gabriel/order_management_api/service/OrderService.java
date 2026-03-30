package com.gabriel.order_management_api.service;

import com.gabriel.order_management_api.dto.OrderDTO;
import com.gabriel.order_management_api.entity.Order;
import com.gabriel.order_management_api.entity.OrderStatus;
import com.gabriel.order_management_api.entity.User;
import com.gabriel.order_management_api.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderService {
    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public OrderDTO toDTO(Order order) {
        return new OrderDTO(
                order.getId(),
                order.getDescription(),
                order.getStatus().name(),
                order.getUser().getId()
        );
    }

    public OrderDTO create(Order order) {
        Order saved = repository.save(order);
        return toDTO(saved);
    }

    public List<OrderDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public Order toEntity(OrderDTO dto) {
        Order order = new Order();
        order.setDescription(dto.getDescription());
        order.setStatus(OrderStatus.valueOf(dto.getStatus()));

        User user = new User();
        user.setId(dto.getUserId());

        order.setUser(user);

        return order;
    }
}

