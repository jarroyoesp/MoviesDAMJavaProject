package com.svalero.splashscreen_26_oct_o.beans;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoviesAPIResult {
    private Integer page;
    private List<Movie> results;
    private Integer total_pages;
    private Integer total_results;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }

    public Integer getTotal_results() {
        return total_results;
    }

    public void setTotal_results(Integer total_results) {
        this.total_results = total_results;
    }
}
