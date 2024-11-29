package com.co.accenture.franquicias.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.co.accenture.franquicias.exceptions.FranquiciaDuplicadaException;
import com.co.accenture.franquicias.exceptions.FranquiciaServiceException;
import com.co.accenture.franquicias.models.response.ErrorResponse;

/**
 * Controlador de excepciones
 * 
 * @version 1.0
 * @autor Daniel Garcia
 * @since 2024/11/28
 */
@RestControllerAdvice
public class HandlerExceptionController {

    private Logger log = LogManager.getLogger(this.getClass());

    @ExceptionHandler(FranquiciaServiceException.class)
    public ResponseEntity<ErrorResponse> transactionServiceException(FranquiciaServiceException ex) {
        log.info("====================================================================");
        log.info("EXCEPTION");
        log.info("STATUS: " + "ERROR");
        log.error("El servicio fallo por: {}", ex.getMessage(), ex);
        log.info("====================================================================");
        return ResponseEntity.status(500).body(new ErrorResponse("Error en el servicio", ex.getMessage2()));
    }

    @ExceptionHandler(FranquiciaDuplicadaException.class)
    public ResponseEntity<ErrorResponse> transactionServiceException(FranquiciaDuplicadaException ex) {
        log.info("====================================================================");
        log.info("EXCEPTION");
        log.info("STATUS: " + "ERROR");
        log.error("La franquicia ya existe: {}", ex.getMessage(), ex);
        log.info("====================================================================");
        return ResponseEntity.status(400).body(new ErrorResponse("Error en el servicio", ex.getMessage2()));
    }
}
