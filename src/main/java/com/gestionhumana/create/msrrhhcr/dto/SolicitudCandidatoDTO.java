package com.gestionhumana.create.msrrhhcr.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class SolicitudCandidatoDTO {
    @JsonProperty("apePaterno")
    private String ApePaterno;

    @JsonProperty("apeMaterno")
    private String ApeMaterno;

    @JsonProperty("nombres")
    private String Nombres;

    @JsonProperty("email")
    private String Email;

    @JsonProperty("numCel")
    private String NumCel;

    @JsonProperty("direccion")
    private String Direccion;

    @JsonProperty("puestoSolicitante")
    private String PuestoSolicitante;

    @JsonProperty("activo")
    private Boolean Activo;

    @JsonProperty("fechaCreacion")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime FechaCreacion;

    public SolicitudCandidatoDTO() {}

    @JsonCreator
    public SolicitudCandidatoDTO(
            @JsonProperty("apePaterno") String apePaterno,
            @JsonProperty("apeMaterno") String apeMaterno,
            @JsonProperty("nombres") String nombres,
            @JsonProperty("email") String email,
            @JsonProperty("numCel") String numCel,
            @JsonProperty("direccion") String direccion,
            @JsonProperty("puestoSolicitante") String puestoSolicitante,
            @JsonProperty("activo") Boolean activo,
            @JsonProperty("fechaCreacion") LocalDateTime fechaCreacion) {
        this.ApePaterno = apePaterno;
        this.ApeMaterno = apeMaterno;
        this.Nombres = nombres;
        this.Email = email;
        this.NumCel = numCel;
        this.Direccion = direccion;
        this.PuestoSolicitante = puestoSolicitante;
        this.Activo = activo;
        this.FechaCreacion = fechaCreacion;
    }




    public String getApePaterno() {
        return ApePaterno;
    }

    public void setApePaterno(String apePaterno) {
        ApePaterno = apePaterno;
    }

    public String getApeMaterno() {
        return ApeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        ApeMaterno = apeMaterno;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getNumCel() {
        return NumCel;
    }

    public void setNumCel(String numCel) {
        NumCel = numCel;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getPuestoSolicitante() {
        return PuestoSolicitante;
    }

    public void setPuestoSolicitante(String puestoSolicitante) {
        PuestoSolicitante = puestoSolicitante;
    }

    public Boolean getActivo() {
        return Activo;
    }

    public void setActivo(Boolean activo) {
        Activo = activo;
    }

    public LocalDateTime getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        FechaCreacion = fechaCreacion;
    }
}
