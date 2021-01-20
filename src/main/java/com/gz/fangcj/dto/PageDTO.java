package com.gz.fangcj.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.NoArgsConstructor;

import java.util.List;

@ApiModel(value = "分页对象")
@NoArgsConstructor
public class PageDTO<T> {

    @ApiModelProperty(value = "数据列表")
    private List<T> list;

    @ApiModelProperty(value = "总页数")
    private Integer totalPage;

    @ApiModelProperty(value = "当前数")
    private Integer currentPage;

    @ApiModelProperty(value = "每页显示行数")
    private Integer pageSize;

    @ApiModelProperty(value = "是否第一页")
    private Boolean isFirstPage;

    @ApiModelProperty(value = "是否最后一页")
    private Boolean isLastPage;

    @ApiModelProperty(value = "数据总量")
    private Long totalQty;


    public PageDTO(Integer page, Long totalQty, Integer pageSize, List<T> list) {
        this.currentPage = countCurrentPage(page);
        if (null == pageSize) {
            this.totalPage = 1;
        } else {
            this.totalPage = countTotalPage(pageSize, totalQty.intValue());
        }
        this.list = list;
        this.isFirstPage = isFirstPage();
        this.isLastPage = isLastPage();
        this.totalQty = totalQty;
        this.pageSize = pageSize;
    }

    public Long getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(Long totalQty) {
        this.totalQty = totalQty;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Boolean isFirstPage() {
        return currentPage == 1;
    }

    public Boolean isLastPage() {
        return currentPage.equals(totalPage);
    }

    public static Integer countTotalPage(Integer pageSize, Integer allRow) {
        Integer totalPage = allRow % pageSize == 0 ? allRow / pageSize : allRow
                / pageSize + 1;
        return totalPage;
    }

    public static Integer countBegin(Integer pageSize, Integer currentPage) {
        final Integer begin = pageSize * (currentPage - 1);
        return begin;
    }

    public static Integer countCurrentPage(Integer page) {
        final Integer curPage = ((null == page || page == 0) ? 1 : page);
        return curPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Boolean getIsFirstPage() {
        return isFirstPage;
    }

    public Boolean getIsLastPage() {
        return isLastPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
