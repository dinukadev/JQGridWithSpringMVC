package com.example.jqgrid.dto;

import java.io.Serializable;
import java.util.List;

/**
 * This class acts as common template for all pages that use the JQGrid.
 * 
 * @author Dinuka Arseculeratne
 * 
 * @param <T>
 */
public class JQGridDTO < T extends Serializable > {

    private int page;

    private String total;

    private String records;

    private List<T> rows;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getRecords() {
        return records;
    }

    public void setRecords(String records) {
        this.records = records;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

}
