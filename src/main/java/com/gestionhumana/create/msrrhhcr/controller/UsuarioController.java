package com.gestionhumana.create.msrrhhcr.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gestionhumana.create.msrrhhcr.dto.ResponseDTO;
import com.gestionhumana.create.msrrhhcr.dto.UsuarioDTO;
import com.gestionhumana.create.msrrhhcr.services.interfaces.IUsuarioServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/mantenimiento")
@Slf4j
@Tag(name = "Mantenimiento")
public class UsuarioController {

    private final ObjectMapper objectMapper;
    private final IUsuarioServices usuarioService;

    @Autowired
    public UsuarioController(ObjectMapper objectMapper, IUsuarioServices usuarioService) {
        this.objectMapper = objectMapper;
        this.usuarioService = usuarioService;
    }

    @Operation(summary = "Creacion de nuevo usuario")
    @PostMapping
    public ResponseEntity<ResponseDTO> crearUsuario(@RequestBody UsuarioDTO request) {
        try {
            String requestToJson = objectMapper.writeValueAsString(request);
            System.out.println("Nuevo candidato recibido: {}" + requestToJson);

            ResponseDTO response = this.usuarioService.CrearUsuario(request);
            System.out.println("Usuario registrado exitosamente: " + response);

            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception ex) {
            System.out.println("Error al crear el usuario: " + ex.getMessage() + "\nMessage_Exception: " + ex);
            ResponseDTO response = new ResponseDTO();
            response.setStatusCode(500);
            response.setMessage("Error al crear el usuario: " + ex.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
