package com.gestionhumana.create.msrrhhcr.dto;

import lombok.Data;

@Data
public class UsuarioDTO {
    private String usuario;
    private String password;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String celular;
    private String correo;
    private String direccion;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String usuario, String password, String nombre, String apellido_paterno,
                      String apellido_materno, String celular, String correo, String direccion) {
        this.usuario = usuario;
        this.password = password;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.celular = celular;
        this.correo = correo;
        this.direccion = direccion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
