package com.co.accenture.franquicias.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.co.accenture.franquicias.entities.Franquicia;
import com.co.accenture.franquicias.models.request.NuevaFranquiciaRequest;
import com.co.accenture.franquicias.models.response.NuevaFranquiciaResponse;
import com.co.accenture.franquicias.repository.FranquiciaRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

/**
 * Servicio de la franquicia
 * 
 * @version 1.0 - 2024/11/28
 * @autor Daniel Garcia
 */
@Service
@AllArgsConstructor
public class FranquiciaService implements IFranquiciaService {

    // Inyección por constructor
    private final FranquiciaRepository franquiciaRepository;

    @Override
    @Transactional
    public ResponseEntity<NuevaFranquiciaResponse> addFranquicia(NuevaFranquiciaRequest request) {
        Franquicia franquicia = new Franquicia();
        franquicia.setNombre(request.getNombre());
        franquiciaRepository.save(franquicia);

        StringBuilder mensaje = new StringBuilder();
        mensaje.append("La franquicia ");
        mensaje.append(franquicia.getNombre());
        mensaje.append(" ha sido creada exitosamente");
        return ResponseEntity.status(HttpStatus.CREATED).body(new NuevaFranquiciaResponse(mensaje.toString()));
    }
}
