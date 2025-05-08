package com.example.demo.domain.response;

import com.example.demo.domain.dto.EOrder;
import lombok.Data;

import java.util.List;

@Data
public class OrderListRsp {
    private List<String> message;
    private long pagerOffset;
    private long totalCount;
    private List<EOrder> orders;
}
