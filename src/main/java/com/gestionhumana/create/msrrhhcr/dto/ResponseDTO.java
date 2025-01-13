package com.gestionhumana.create.msrrhhcr.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ResponseDTO {
    private Integer statusCode;
    private String message;

    public ResponseDTO() {}

    public ResponseDTO(Integer statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
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
}
