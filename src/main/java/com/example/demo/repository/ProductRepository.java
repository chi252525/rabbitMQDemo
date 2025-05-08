package com.example.demo.repository;

import com.example.demo.domain.dto.EOrder;
import com.example.demo.domain.dto.Product;
import com.example.demo.domain.response.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
