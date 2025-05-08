package com.example.demo.repository;

import com.example.demo.domain.dto.EOrder;
import com.example.demo.domain.dto.Member;
import com.example.demo.domain.response.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<EOrder, Integer> {

    @Query("SELECT new com.example.demo.domain.response.Statistics(o.member,count(o)) FROM EOrder o GROUP BY o.member.id ")
    List<Statistics> getCount(long count);
}
