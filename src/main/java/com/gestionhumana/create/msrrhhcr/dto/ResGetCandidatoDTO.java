package com.gestionhumana.create.msrrhhcr.dto;

import com.gestionhumana.create.msrrhhcr.entities.Candidatos;
import lombok.Data;

import java.util.ArrayList;

@Data
public class ResGetCandidatoDTO {
    private Integer statusCode;
    private String message;
    private Candidatos data;

    public ResGetCandidatoDTO() {}

    public ResGetCandidatoDTO(Integer statusCode, String message, Candidatos data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }
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

    public Candidatos getData() {
        return data;
    }

    public void setData(Candidatos data) {
        this.data = data;
    }
}
