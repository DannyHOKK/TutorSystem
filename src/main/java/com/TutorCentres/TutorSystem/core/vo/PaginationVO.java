package com.TutorCentres.TutorSystem.core.vo;

import io.swagger.annotations.ApiModelProperty;

public class PaginationVO {
    private Long currentPage;

    private Long pageSize;

    private Integer total;

    public Long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Long currentPage) {
        this.currentPage = currentPage;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
