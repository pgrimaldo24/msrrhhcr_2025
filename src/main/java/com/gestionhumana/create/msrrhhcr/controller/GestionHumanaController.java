package com.gestionhumana.create.msrrhhcr.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gestionhumana.create.msrrhhcr.dto.*;
import com.gestionhumana.create.msrrhhcr.services.interfaces.IRequerimientoPersonalServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "/api/v1/requerimiento")
@Slf4j
@Tag(name = "Requerimiento")
public class GestionHumanaController {

    private final ObjectMapper objectMapper;
    private final IRequerimientoPersonalServices  requerimientoService;

    @Autowired
    public GestionHumanaController(ObjectMapper objectMapper, IRequerimientoPersonalServices  requerimientoService) {
        this.objectMapper = objectMapper;
        this.requerimientoService = requerimientoService;
    }

    @Operation(summary = "Creacion de nuevo candidato para el proceso de selección")
    @PostMapping
    public ResponseEntity<ResponseDTO> createRequerimientoPersonal(@RequestBody SolicitudCandidatoDTO request) {
        try {
            String requestToJson = objectMapper.writeValueAsString(request);
            System.out.println("Nuevo candidato recibido: {}" + requestToJson);

            ResponseDTO response = this.requerimientoService.CrearNuevoRequerimiento(request);
            System.out.println("Requerimiento creado exitosamente: " + response);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println("Error al crear el requerimiento personal: " + ex.getMessage() + "\nMessage_Exception: " + ex);
            ResponseDTO response = new ResponseDTO();
            response.setStatusCode(500);
            response.setMessage("Error al crear el requerimiento personal: " + ex.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Consulta los datos del candidato por el id")
    @GetMapping(path = "/{id}")
    public ResponseEntity<ResGetCandidatoDTO> consultarInfoCandidato(long id) {
        try {
            System.out.println("IdCandidato: " + id);
            ResGetCandidatoDTO response = this.requerimientoService.ConsultarInfoCandidatoById(id);
            System.out.println("Info: " + response.getData());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage() + "\nMessage_Exception: " + ex);
            ResGetCandidatoDTO response = new ResGetCandidatoDTO();
            response.setStatusCode(500);
            response.setMessage("ERROR: " + ex.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Actualiza los datos del candidato registrado")
    @PutMapping
    public ResponseEntity<ResponseDTO> actualizarInfoCandidato(@RequestParam("id") long id,
                                                               @RequestParam("apePaterno") String apePaterno,
                                                               @RequestParam("apeMaterno") String apeMaterno,
                                                               @RequestParam("nombres") String nombres,
                                                               @RequestParam("email") String email,
                                                               @RequestParam("numCel") String numCel,
                                                               @RequestParam("direccion") String direccion,
                                                               @RequestParam("puestoSolicitante") String puestoSolicitante,
                                                               @RequestParam("activo") Boolean activo,
                                                               @RequestParam("fechaActualizacion") LocalDateTime fechaActualizacion) {
        try {
            ActualizaSolicitudRequestDTO request = new ActualizaSolicitudRequestDTO();
            request.setId(id);
            request.setApePaterno(apePaterno);
            request.setApeMaterno(apeMaterno);
            request.setNombres(nombres);
            request.setEmail(email);
            request.setNumCel(numCel);
            request.setDireccion(direccion);
            request.setPuestoSolicitante(puestoSolicitante);
            request.setActivo(activo);
            request.setFechaActualizacion(fechaActualizacion);

            String requestToJson = objectMapper.writeValueAsString(request);
            System.out.println("Nuevo candidato recibido: {}" + requestToJson);

            ResponseDTO response = this.requerimientoService.ActualizaInforCandidato(request);
            System.out.println("Requerimiento creado exitosamente: " + response);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage() + "\nMessage_Exception: " + ex);
            ResponseDTO response = new ResponseDTO();
            response.setStatusCode(500);
            response.setMessage("ERROR: " + ex.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Elimina la solicitud del candidato")
    @DeleteMapping(path = "{id}")
    public ResponseEntity<ResponseDTO> eliminarSolicitudCandidato(long id) {
        try {
            ResponseDTO response = this.requerimientoService.EliminarSolicitud(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage() + "\nMessage_Exception: " + ex);
            ResponseDTO response = new ResponseDTO();
            response.setStatusCode(500);
            response.setMessage("ERROR: " + ex.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Obtiene registros para el listado de la bandeja de requerimientos")
    @GetMapping(path="/bandeja")
    public ResponseEntity<BandejaResponseDTO> consultaBandeja() {
        try {
            BandejaResponseDTO response = this.requerimientoService.ConsultaBandeja();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage() + "\nMessage_Exception: " + ex);
            BandejaResponseDTO response = new BandejaResponseDTO();
            response.setStatusCode(500);
            response.setMessage("ERROR: " + ex.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}