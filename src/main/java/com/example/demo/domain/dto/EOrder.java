package com.example.demo.domain.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Table(name = "order_tbl")
@Entity
@Data
public class EOrder {

    @Id
    private Integer orderId;
    private Date orderDate = new Date();
    private String shopId;
    @ManyToOne
    @JoinColumn(name = "id")
    private Member member;

    @OneToMany(mappedBy = "eOrder", cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private Set<Product> product;
    private String status;
    private String shippingMethod;
    private String paymentMethod;

}
