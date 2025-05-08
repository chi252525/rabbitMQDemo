package com.example.demo.domain.response;

import com.example.demo.domain.dto.Member;
import lombok.Data;

@Data
public class Statistics {
    private Member member;
    private long orderCount;

    public Statistics(Member member, long orderCount) {
        this.member = member;
        this.orderCount = orderCount;
    }
}
