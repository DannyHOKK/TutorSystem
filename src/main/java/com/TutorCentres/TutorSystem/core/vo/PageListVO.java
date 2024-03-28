package com.TutorCentres.TutorSystem.core.vo;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.Map;

public class PageListVO<T> {
    PaginationVO pagination;
    Map<String, Object> extData;
    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public PaginationVO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationVO pagination) {
        this.pagination = pagination;
    }

    public Map<String, Object> getExtData() {
        return extData;
    }

    public void setExtData(Map<String, Object> extData) {
        this.extData = extData;
    }
}
