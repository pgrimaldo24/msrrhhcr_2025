package com.gestionhumana.create.msrrhhcr.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre_producto", nullable = false)
    private String nombreProducto;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Column(name = "precio", nullable = false)
    private Double precio;

    @Column(name = "descripcion_producto", nullable = false)
    private String descripcionProducto;

    @Column(name = "descuento", nullable = false)
    private Double descuentoProducto;

    @Column(name = "urlimg", nullable = false)
    private String urlimg;

    public Productos() {
    }

    public Productos(String nombreProducto, Integer stock, Double precio, String descripcionProducto, Double descuento, String urlimg) {
        this.nombreProducto = nombreProducto;
        this.stock = stock;
        this.precio = precio;
        this.descripcionProducto = descripcionProducto;
        this.descuentoProducto = descuento;
        this.urlimg = urlimg;
    }

    public long getId() {
        return id;
    }

    public String getUrlimg() {
        return urlimg;
    }

    public void setUrlimg(String urlimg) {
        this.urlimg = urlimg;
    }

    public void setId(long id) {
        this.id = id;
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

    public Double getDescuentoProducto() {
        return descuentoProducto;
    }

    public void setDescuentoProducto(Double descuentoProducto) {
        this.descuentoProducto = descuentoProducto;
    }
}
