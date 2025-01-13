package com.gestionhumana.create.msrrhhcr.dto;

import com.gestionhumana.create.msrrhhcr.entities.Candidatos;
import lombok.Data;

import java.util.List;

@Data
public class BandejaResponseDTO {
    private Integer statusCode;
    private String message;
    private long totalElements;
    private int totalPages;
    private int currentPage;
    private List<Candidatos> results;

    public BandejaResponseDTO(Integer statusCode, String message, long totalElements, int totalPages, int currentPage, List<Candidatos> results) {
        this.statusCode = statusCode;
        this.message = message;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.currentPage = currentPage;
        this.results = results;
    }

    public BandejaResponseDTO() {}

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<Candidatos> getResults() {
        return results;
    }

    public void setResults(List<Candidatos> results) {
        this.results = results;
    }

}
