package com.gestionhumana.create.msrrhhcr.services.interfaces;

import com.gestionhumana.create.msrrhhcr.dto.ProductoDTO;
import com.gestionhumana.create.msrrhhcr.dto.ResponseDTO;
import com.gestionhumana.create.msrrhhcr.entities.Productos;

import java.util.List;

public interface IProductoServices {
    ResponseDTO CrearProducto(ProductoDTO producto);
    List<Productos> listarProductos();
}
