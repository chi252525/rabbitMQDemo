package com.example.demo.service;

import com.example.demo.domain.dto.EOrder;
import com.example.demo.domain.dto.Member;
import com.example.demo.domain.request.ReqOrderList;
import com.example.demo.domain.response.Statistics;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public EOrder save(EOrder order) {
        return orderRepository.save(order);
    }

    public Page<EOrder> list(ReqOrderList req) {
        return orderRepository.findAll(PageRequest.of(req.getPageIndex(),
                req.getPageSize()
        ));
    }

    public List<Statistics> findByCount(long count) {
        return orderRepository.getCount(count);
    }

}
