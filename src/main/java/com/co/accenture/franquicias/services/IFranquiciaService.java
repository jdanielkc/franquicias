package com.co.accenture.franquicias.services;

import org.springframework.http.ResponseEntity;

import com.co.accenture.franquicias.exceptions.FranquiciaServiceException;
import com.co.accenture.franquicias.models.request.NuevaFranquiciaRequest;
import com.co.accenture.franquicias.models.response.NuevaFranquiciaResponse;

/**
 * Interfaz servicio de la franquicia
 * 
 * @version 1.0 - 2024/11/28
 * @autor Daniel Garcia
 */
public interface IFranquiciaService {
    ResponseEntity<NuevaFranquiciaResponse> addFranquicia(NuevaFranquiciaRequest body) throws FranquiciaServiceException;

}
