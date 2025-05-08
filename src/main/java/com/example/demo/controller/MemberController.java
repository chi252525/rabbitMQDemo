package com.example.demo.controller;

import com.example.demo.domain.dto.Member;
import com.example.demo.domain.request.ReqMemberList;
import com.example.demo.domain.response.MemberListRsp;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody Member member) {
        memberService.save(member);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update/{memberId}")
    public ResponseEntity<Object> update(@RequestBody Member member) {
        memberService.save(member);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/{memberId}")
    public ResponseEntity<Object> delete(@PathVariable Long memberId) {
        memberService.delete(memberId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/get/{memberId}")
    public ResponseEntity<Object> get(@PathVariable Long memberId) {
        Optional<Member> memberOption = memberService.findById(memberId);
        if (memberOption.isPresent()) {
            return new ResponseEntity<>(memberOption.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/list")
    public ResponseEntity<Object> list(@RequestBody ReqMemberList req) {
        Page<Member> list = memberService.list(req);
        MemberListRsp response = new MemberListRsp();
        response.setMembers(list.getContent());
        response.setPagerOffset(list.getPageable().getOffset());
        response.setTotalCount(list.getTotalElements());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
