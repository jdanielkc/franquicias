package com.co.accenture.franquicias.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.accenture.franquicias.exceptions.FranquiciaServiceException;
import com.co.accenture.franquicias.models.request.NuevaFranquiciaRequest;
import com.co.accenture.franquicias.models.request.NuevaSucursalRequest;
import com.co.accenture.franquicias.models.request.NuevoProductoRequest;
import com.co.accenture.franquicias.models.response.NuevaFranquiciaResponse;
import com.co.accenture.franquicias.models.response.NuevaSucursalResponse;
import com.co.accenture.franquicias.models.response.NuevoProductoResponse;
import com.co.accenture.franquicias.services.IFranquiciaService;

import lombok.AllArgsConstructor;

/**
 * Controlador de la API
 * 
 * @version 1.0
 * @autor Daniel Garcia
 * @since 2024/11/28
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
     * @param request
     * @return ResponseEntity<NuevaFranquiciaResponse>
     * @throws FranquiciaServiceException
     */
    @PostMapping("/nueva-franquicia")
    public ResponseEntity<NuevaFranquiciaResponse> addFranquicia(@RequestBody NuevaFranquiciaRequest request) {
        return franquiciaService.addFranquicia(request);
    }

    /**
     * Método que permite agregar una nueva sucursal
     * 
     * @param request
     * @return ResponseEntity<NuevaSucursalResponse>
     * @throws FranquiciaServiceException
     */
    @PostMapping("/nueva-sucursal")
    public ResponseEntity<NuevaSucursalResponse> addSucursal(@RequestBody NuevaSucursalRequest request) throws FranquiciaServiceException {
        return franquiciaService.addSucursal(request);
    }

    /**
     * Método que permite agregar un nuevo producto
     * 
     * @param request
     * @return ResponseEntity<NuevoProductoResponse>
     * @throws FranquiciaServiceException
     */
    @PostMapping("/nuevo-producto")
    public ResponseEntity<NuevoProductoResponse> addProducto(@RequestBody NuevoProductoRequest request) throws FranquiciaServiceException {
        return franquiciaService.addProducto(request);
    }
    
}
