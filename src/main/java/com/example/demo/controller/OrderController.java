package com.example.demo.controller;

import com.example.demo.domain.dto.EOrder;
import com.example.demo.domain.request.ReqOrderList;
import com.example.demo.domain.response.OrderListRsp;
import com.example.demo.domain.response.Statistics;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    public ResponseEntity<Object> add(@RequestBody EOrder order) {
        orderService.save(order);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<Object> list(@RequestBody ReqOrderList req) {
        Page<EOrder> list = orderService.list(req);
        OrderListRsp response = new OrderListRsp();
        response.setOrders(list.getContent());
        response.setPagerOffset(list.getPageable().getOffset());
        response.setTotalCount(list.getTotalElements());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/orderCount/{count}")
    public ResponseEntity<Object> get(@PathVariable Long count) {
        List<Statistics> memberByOrderCount = orderService.findByCount(count);
        List<Statistics> statistics = memberByOrderCount.stream().filter(e -> e.getOrderCount() >= count).collect(Collectors.toList());
        return new ResponseEntity<>(statistics, HttpStatus.OK);
    }
}
