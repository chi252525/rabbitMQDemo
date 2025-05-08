package com.example.demo.domain.dto;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private String category;
    @ManyToOne
    @JoinColumn(name = "orderId")
    private EOrder eOrder;
}
