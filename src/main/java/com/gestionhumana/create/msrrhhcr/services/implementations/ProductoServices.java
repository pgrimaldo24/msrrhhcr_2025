package com.gestionhumana.create.msrrhhcr.services.implementations;

import com.gestionhumana.create.msrrhhcr.dto.ProductoDTO;
import com.gestionhumana.create.msrrhhcr.dto.ResponseDTO;
import com.gestionhumana.create.msrrhhcr.entities.Productos;
import com.gestionhumana.create.msrrhhcr.entities.Usuario;
import com.gestionhumana.create.msrrhhcr.repositories.ProductoRepository;
import com.gestionhumana.create.msrrhhcr.repositories.UsuarioRepository;
import com.gestionhumana.create.msrrhhcr.services.interfaces.IProductoServices;
import com.gestionhumana.create.msrrhhcr.services.mapper.MapperService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Transactional
@Slf4j
public class ProductoServices implements IProductoServices {

    private MapperService mapperService;
    private final ProductoRepository productoRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public ProductoServices(ProductoRepository  productoRepository, MapperService mapperService) {
        this.productoRepository = productoRepository;
        this.mapperService = mapperService;
    }

    @Override
    public ResponseDTO CrearProducto(ProductoDTO producto) {
        if(Objects.isNull(producto)){
            return new ResponseDTO(404, "No se puede crear el producto´, inténtalo de nuevo.");
        }
        Optional<Productos> productOptional = Optional.ofNullable(
                mapperService.map(producto, Productos.class)
        );

        if (productOptional.isEmpty()) {
            return new ResponseDTO(500, "Error al mapear el producto.");
        }

        Productos product = productOptional.get();
        this.productoRepository.save(product);
        return new ResponseDTO(201,"El producto" + producto.getNombreProducto() +" se registró correctamente.");
    }

    @Override
    public List<Productos> listarProductos() {
        List<Productos> productos = this.productoRepository.findAll();
        if (productos.isEmpty()) {
            throw new NoSuchElementException("No hay productos disponibles");
        }
        return productos;
    }
}
