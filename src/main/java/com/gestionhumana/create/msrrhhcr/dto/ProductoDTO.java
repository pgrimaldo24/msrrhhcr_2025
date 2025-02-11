package com.gestionhumana.create.msrrhhcr.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ProductoDTO {
    private String nombreProducto;
    private Integer stock;
    private Double precio;
    private String descripcionProducto;
    private Double descuentoProducto;
    private String urlimg;

    public ProductoDTO(){}

    public ProductoDTO(String nombreProducto, Integer stock, Double precio, String descripcionProducto, Double descuentoProducto, String urlimg) {
        this.nombreProducto = nombreProducto;
        this.stock = stock;
        this.precio = precio;
        this.descripcionProducto = descripcionProducto;
        this.descuentoProducto = descuentoProducto;
        this.urlimg = urlimg;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public String getUrlimg() {
        return urlimg;
    }

    public void setUrlimg(String urlimg) {
        this.urlimg = urlimg;
    }

    public Double getDescuentoProducto() {
        return descuentoProducto;
    }

    public void setDescuentoProducto(Double descuentoProducto) {
        this.descuentoProducto = descuentoProducto;
    }

}
