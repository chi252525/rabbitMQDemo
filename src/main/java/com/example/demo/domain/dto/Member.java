package com.example.demo.domain.dto;

import lombok.Data;

import javax.persistence.*;

@Table(name = "member_tbl")
@Entity
@Data
public class Member {
    @Id
    private Long id;
    private Long shopId;
    private String name;
    private String age;
    private String email;
    private String phone;
}
