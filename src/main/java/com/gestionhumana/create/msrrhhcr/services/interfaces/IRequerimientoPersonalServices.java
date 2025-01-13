package com.gestionhumana.create.msrrhhcr.services.interfaces;

import com.gestionhumana.create.msrrhhcr.dto.*;

import java.time.LocalDate;

public interface IRequerimientoPersonalServices {
    ResponseDTO CrearNuevoRequerimiento(SolicitudCandidatoDTO request);
    ResGetCandidatoDTO ConsultarInfoCandidatoById(long id);
    ResponseDTO ActualizaInforCandidato(ActualizaSolicitudRequestDTO request);
    ResponseDTO EliminarSolicitud(long id);
    BandejaResponseDTO ConsultaBandeja();
}
