package com.gabriel.order_management_api.dto;

import com.gabriel.order_management_api.entity.Order;
import com.gabriel.order_management_api.entity.OrderStatus;
import com.gabriel.order_management_api.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String status;
    private Long userId;

    public OrderDTO(Long id, String description, String status, Long userId) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public Long getUserId() {
        return userId;
    }
}
