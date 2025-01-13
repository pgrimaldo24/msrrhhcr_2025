package com.gestionhumana.create.msrrhhcr.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ActualizaSolicitudRequestDTO {
    @JsonProperty("id")
    private long Id;

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

    @JsonProperty("fechaActualizacion")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime FechaActualizacion;

    public ActualizaSolicitudRequestDTO() {}

    @JsonCreator
    public ActualizaSolicitudRequestDTO(@JsonProperty("id") long id,
                                        @JsonProperty("apeMaterno") String apeMaterno,
                                        @JsonProperty("apePaterno") String apePaterno,
                                        @JsonProperty("nombres") String nombres,
                                        @JsonProperty("email") String email,
                                        @JsonProperty("numCel") String numCel,
                                        @JsonProperty("direccion") String direccion,
                                        @JsonProperty("puestoSolicitante") String puestoSolicitante,
                                        @JsonProperty("activo") Boolean activo,
                                        @JsonProperty("fechaActualizacion") LocalDateTime fechaActualizacion) {
        this.Id = id;
        this.ApeMaterno = apeMaterno;
        this.ApePaterno = apePaterno;
        this.Nombres = nombres;
        this.Email = email;
        this.NumCel = numCel;
        this.Direccion = direccion;
        this.PuestoSolicitante = puestoSolicitante;
        this.Activo = activo;
        this.FechaActualizacion = fechaActualizacion;
    }



    public long getId() {
        return this.Id;
    }

    public void setId(long id) {
        this.Id = id;
    }

    public String getApePaterno() {
        return this.ApePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.ApePaterno = apePaterno;
    }

    public String getApeMaterno() {
        return this.ApeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.ApeMaterno = apeMaterno;
    }

    public String getNombres() {
        return this.Nombres;
    }

    public void setNombres(String nombres) {
        this.Nombres = nombres;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getNumCel() {
        return this.NumCel;
    }

    public void setNumCel(String numCel) {
        this.NumCel = numCel;
    }

    public String getDireccion() {
        return this.Direccion;
    }

    public void setDireccion(String direccion) {
        this.Direccion = direccion;
    }

    public String getPuestoSolicitante() {
        return this.PuestoSolicitante;
    }

    public void setPuestoSolicitante(String puestoSolicitante) {
        this.PuestoSolicitante = puestoSolicitante;
    }

    public Boolean getActivo() {
        return this.Activo;
    }

    public void setActivo(Boolean activo) {
        this.Activo = activo;
    }

    public LocalDateTime getFechaActualizacion() {
        return this.FechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.FechaActualizacion = fechaActualizacion;
    }

}
