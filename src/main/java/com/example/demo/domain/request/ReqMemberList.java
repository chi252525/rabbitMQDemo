package com.example.demo.domain.request;

import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Data
public class ReqMemberList {
    private Long shopId;
    public int pageIndex = 0;
    public int pageSize = 20;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize > 0) {
            this.pageSize = pageSize;
        }
    }

    public Pageable getPageable() {
        return PageRequest.of(this.pageIndex, this.pageSize);
    }
}
