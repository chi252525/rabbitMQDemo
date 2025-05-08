package com.example.demo.domain.response;

import com.example.demo.domain.dto.Member;
import lombok.Data;

import java.util.List;

@Data
public class MemberListRsp {
    private List<String> message;
    private long pagerOffset;
    private long totalCount;
    private List<Member> members;
}
