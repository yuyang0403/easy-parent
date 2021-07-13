package com.yuyang.easy.common.entity.common;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author yuyang
 * @date 2020/11/20 19:19
 * @Description 分页通用返回数据
 */

public class PagedVO<T> {

    @ApiModelProperty("页数")
    private long pageNo = 1;

    @ApiModelProperty("每页条数")
    private long pageSize = 20;

    @ApiModelProperty("结果行数")
    private long totalRows = 0;

    @ApiModelProperty("结果数据")
    private List<T> data;


    @ApiModelProperty("结果页数")
    public long getTotalPages() {
        if (pageSize == 0) {
            return 0;
        }
        return (long) Math.ceil(totalRows * 1.0D / pageSize);
    }

    public long getPageNo() {
        return pageNo;
    }

    public void setPageNo(long pageNo) {
        this.pageNo = pageNo;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(long totalRows) {
        this.totalRows = totalRows;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
