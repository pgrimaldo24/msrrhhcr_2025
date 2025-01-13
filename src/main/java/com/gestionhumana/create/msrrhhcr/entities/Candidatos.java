package com.gestionhumana.create.msrrhhcr.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class Candidatos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name = "ape_paterno", nullable = false)
    private String ApePaterno;

    @Column(name = "ape_materno", nullable = false)
    private String ApeMaterno;

    @Column(name = "nombres", nullable = false)
    private String Nombres;

    @Column(name = "email", nullable = false)
    private String Email;

    @Column(name = "numCel", nullable = false)
    private String NumCel;

    @Column(name = "direccion", nullable = false)
    private String Direccion;

    @Column(name = "puesto_solicitante", nullable = false)
    private String PuestoSolicitante;

    @Column(name = "activo", nullable = false)
    private Boolean Activo;

    @Column(name = "usuario_id", nullable = false)
    private Integer UsuarioId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "fecha_creacion", nullable = false)
    @JsonProperty("fechaCreacion")
    private LocalDateTime FechaCreacion;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "fecha_actualizacion")
    @JsonProperty("fechaActualizacion")
    private LocalDateTime FechaActualizacion;

    public Candidatos(String apeMaterno,
                      String apePaterno,
                      String nombres,
                      String email,
                      String numCel,
                      String direccion,
                      String puestoSolicitante,
                      Boolean activo,
                      Integer usuarioId,
                      LocalDateTime fechaCreacion,
                      LocalDateTime fechaActualizacion) {
        this.ApeMaterno = apeMaterno;
        this.ApePaterno = apePaterno;
        this.Nombres = nombres;
        this.Email = email;
        this.NumCel = numCel;
        this.Direccion = direccion;
        this.PuestoSolicitante = puestoSolicitante;
        this.Activo = activo;
        this.UsuarioId = usuarioId;
        this.FechaCreacion = fechaCreacion;
        this.FechaActualizacion = fechaActualizacion;
    }

    public Candidatos() {}

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getApeMaterno() {
        return ApeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        ApeMaterno = apeMaterno;
    }

    public String getApePaterno() {
        return ApePaterno;
    }

    public void setApePaterno(String apePaterno) {
        ApePaterno = apePaterno;
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

    public Integer getUsuarioId() {
        return this.UsuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.UsuarioId = usuarioId;
    }


    public LocalDateTime getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        FechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return FechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        FechaActualizacion = fechaActualizacion;
    }
}
