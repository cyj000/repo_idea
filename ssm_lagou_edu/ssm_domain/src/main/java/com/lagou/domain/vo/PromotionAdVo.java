package com.lagou.domain.vo;

/**
 * @ClassName: PromotionAdVo
 * @Author: CYJ
 * @Date: 2021-08-09 15:30:22
 * @Description:
 */

public class PromotionAdVo {

    private Integer currentPage = 1;

    private Integer pageSize = 10;


    public Integer getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
    public Integer getPageSize() {
        return pageSize;
    }
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
