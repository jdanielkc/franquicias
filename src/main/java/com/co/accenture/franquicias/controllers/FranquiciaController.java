package com.co.accenture.franquicias.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.accenture.franquicias.models.request.NuevaFranquiciaRequest;
import com.co.accenture.franquicias.models.response.NuevaFranquiciaResponse;
import com.co.accenture.franquicias.services.IFranquiciaService;

import lombok.AllArgsConstructor;

/**
 * Controlador de la franquicia
 * 
 * @version 1.0 - 2024/11/28
 * @autor Daniel Garcia
 */

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class FranquiciaController {

    // Inyección por constructor
    private final IFranquiciaService franquiciaService;

    /**
     * Método que permite agregar una nueva franquicia
     * 
     * @param body
     * @return ResponseEntity<NuevaFranquiciaResponse>
     */
    @PostMapping("/nueva-franquicia")
    public ResponseEntity<NuevaFranquiciaResponse> addFranquicia(@RequestBody NuevaFranquiciaRequest request) {
        return franquiciaService.addFranquicia(request);
    }

}
