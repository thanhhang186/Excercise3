package com.khtn.hang.homeworkweek3;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by nhyml on 3/17/2018.
 */

public class Movies {
    @SerializedName("results")
    @Expose
    private List<Result> result;

    @SerializedName("page")
    @Expose
    private int page;

    @SerializedName("total_results")
    @Expose
    private long totalResults;

    @SerializedName("dates")
    @Expose
    private Date date;

    @SerializedName("total_pages")
    @Expose
    private int totalPages;

    public Movies() {
    }

    public Movies(List<Result> result, int page, long totalResults, Date date, int totalPages) {
        this.result = result;
        this.page = page;
        this.totalResults = totalResults;
        this.date = date;
        this.totalPages = totalPages;
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public long getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(long totalResults) {
        this.totalResults = totalResults;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "result=" + result +
                ", page=" + page +
                ", totalResults=" + totalResults +
                ", date=" + date +
                ", totalPages=" + totalPages +
                '}';
    }
}
