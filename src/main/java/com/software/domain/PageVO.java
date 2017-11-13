package com.software.domain;

/**
 * Created by hasee on 2017/11/12.
 */
public class PageVO {
    private int rows;
    private int page;

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "PageVO{" +
                "rows=" + rows +
                ", page=" + page +
                '}';
    }
}
