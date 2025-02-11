package com.gestionhumana.create.msrrhhcr.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gestionhumana.create.msrrhhcr.dto.ProductoDTO;
import com.gestionhumana.create.msrrhhcr.dto.ResponseDTO;
import com.gestionhumana.create.msrrhhcr.dto.UsuarioDTO;
import com.gestionhumana.create.msrrhhcr.entities.Productos;
import com.gestionhumana.create.msrrhhcr.services.interfaces.IProductoServices;
import com.gestionhumana.create.msrrhhcr.services.interfaces.IUsuarioServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/producto")
@Slf4j
@Tag(name = "Productos")
public class ProductoController {
    private final ObjectMapper objectMapper;
    private final IProductoServices productoServices;

    @Autowired
    public ProductoController(ObjectMapper objectMapper, IProductoServices productoServices) {
        this.objectMapper = objectMapper;
        this.productoServices = productoServices;
    }

    @Operation(summary = "Creación de nuevo producto")
    @PostMapping
    public ResponseEntity<ResponseDTO> crearProducto(@RequestBody ProductoDTO request) {
        try {
            String requestToJson = objectMapper.writeValueAsString(request);
            System.out.println("Nuevo producto recibido: {}" + requestToJson);

            ResponseDTO response = this.productoServices.CrearProducto(request);
            System.out.println("Producto registrado exitosamente: " + response);

            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception ex) {
            ResponseDTO response = new ResponseDTO();
            response.setStatusCode(500);
            response.setMessage("Error al crear el producto: " + ex.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Listado de productos")
    @GetMapping
    public ResponseEntity<List<Productos>> listaProductos() {
        try {
            List<Productos> response = this.productoServices.listarProductos();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage() + "\nMessage_Exception: " + ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
