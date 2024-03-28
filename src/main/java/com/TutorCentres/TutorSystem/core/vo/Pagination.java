package com.TutorCentres.TutorSystem.core.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class Pagination extends Page {
    private long pageSize = 10;
    private String sort = "desc";
    private String sidx = "";
    private long currentPage = 1;

    @JsonIgnore
    private long total;
    @JsonIgnore
    private long records;

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(long currentPage) {
        this.currentPage = currentPage;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getRecords() {
        return records;
    }

    public void setRecords(long records) {
        this.records = records;
    }

    public <T> List<T> setData(List<T> data, long records) {
        this.total = records;
        return data;
    }
}
