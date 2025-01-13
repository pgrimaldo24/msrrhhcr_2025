package com.gestionhumana.create.msrrhhcr.services.implementations;

import com.gestionhumana.create.msrrhhcr.dto.*;
import com.gestionhumana.create.msrrhhcr.entities.Candidatos;
import com.gestionhumana.create.msrrhhcr.repositories.CandidatoRepository;
import com.gestionhumana.create.msrrhhcr.services.interfaces.IRequerimientoPersonalServices;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@Transactional
@Slf4j
public class RequerimientoPersonalServices implements IRequerimientoPersonalServices {

    private final CandidatoRepository candidatoRepository;

    @PersistenceContext
    private EntityManager entityManager;


    @Autowired
    public RequerimientoPersonalServices(CandidatoRepository  candidatoRepository) {
        this.candidatoRepository = candidatoRepository;
    }

    @Override
    public ResponseDTO CrearNuevoRequerimiento(SolicitudCandidatoDTO request) {
        if(Objects.isNull(request)){
            return new ResponseDTO(404, "La solicitud del candidato no puede ser nulo");
        }
        Candidatos options = new Candidatos();
        options.setApePaterno(request.getApePaterno());
        options.setApeMaterno(request.getApeMaterno());
        options.setNombres(request.getNombres());
        options.setEmail(request.getEmail());
        options.setNumCel(request.getNumCel());
        options.setDireccion(request.getDireccion());
        options.setPuestoSolicitante(request.getPuestoSolicitante());
        options.setActivo(request.getActivo());
        options.setUsuarioId(72192027);
        options.setFechaCreacion(request.getFechaCreacion());
        this.candidatoRepository.save(options);
        return new ResponseDTO(200,"La solicitud del candidato se registró correctamente");
    }

    @Override
    public ResGetCandidatoDTO ConsultarInfoCandidatoById(long id) {
        ResGetCandidatoDTO response = new ResGetCandidatoDTO();
        Candidatos candidatosEntity = this.candidatoRepository.findById(id).orElseThrow(() -> new NoSuchElementException("El candidato no existe"));;

        if(candidatosEntity == null){
            response.setStatusCode(404);
            response.setMessage("El candidato no existe");
            return response;
        }
        response.setStatusCode(200);
        response.setMessage("Se procesó correctamente");
        response.setData(candidatosEntity);
        return response;
    }

    @Override
    public ResponseDTO ActualizaInforCandidato(ActualizaSolicitudRequestDTO request) {
        ResponseDTO response = new ResponseDTO();
        var candidatosEntity = this.candidatoRepository.findById(request.getId()).orElseThrow(() -> new NoSuchElementException("El candidato no existe"));;

        if(candidatosEntity == null){
            response.setStatusCode(404);
            response.setMessage("El candidato no existe");
            return response;
        }

        if (!Objects.equals(candidatosEntity.getApeMaterno(), request.getApeMaterno())) {
            candidatosEntity.setApeMaterno(request.getApeMaterno());
        }

        if (!Objects.equals(candidatosEntity.getApePaterno(), request.getApePaterno())) {
            candidatosEntity.setApePaterno(request.getApePaterno());
        }

        if (!Objects.equals(candidatosEntity.getNombres(), request.getNombres())) {
            candidatosEntity.setNombres(request.getNombres());
        }

        if (!Objects.equals(candidatosEntity.getEmail(), request.getEmail())) {
            candidatosEntity.setEmail(request.getEmail());
        }

        if (!Objects.equals(candidatosEntity.getNumCel(), request.getNumCel())) {
            candidatosEntity.setNumCel(request.getNumCel());
        }

        if (!Objects.equals(candidatosEntity.getDireccion(), request.getDireccion())) {
            candidatosEntity.setDireccion(request.getDireccion());
        }

        if (!Objects.equals(candidatosEntity.getPuestoSolicitante(), request.getPuestoSolicitante())) {
            candidatosEntity.setPuestoSolicitante(request.getPuestoSolicitante());
        }
        candidatosEntity.setFechaActualizacion(request.getFechaActualizacion());
        this.candidatoRepository.save(candidatosEntity);
        response.setStatusCode(200);
        response.setMessage("Los datos del candidato se actualizo correctamente");
        return response;
    }

    @Override
    public ResponseDTO EliminarSolicitud(long id) {
        ResponseDTO response = new ResponseDTO();

        var candidatoEntity = this.candidatoRepository.findById(id).orElseThrow(() -> new NoSuchElementException("El candidato no existe"));

        if(candidatoEntity == null){
            response.setStatusCode(404);
            response.setMessage("El candidato no existe");
            return response;
        }
        this.candidatoRepository.delete(candidatoEntity);
        response.setStatusCode(200);
        response.setMessage("Solicitud del candidato eliminado correctamente");
        return response;
    }

    @Override
    public BandejaResponseDTO ConsultaBandeja() {
        List<Candidatos> candidatosList = this.candidatoRepository.findAll();

        // Configuración de la respuesta
        BandejaResponseDTO responseDTO = new BandejaResponseDTO();
        responseDTO.setStatusCode(200);
        responseDTO.setMessage("El listado de bandeja se procesó correctamente");
        responseDTO.setResults(candidatosList);

        return responseDTO;
    }



}
