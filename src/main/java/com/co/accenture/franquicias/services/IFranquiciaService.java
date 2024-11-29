package com.co.accenture.franquicias.services;

import org.springframework.http.ResponseEntity;

import com.co.accenture.franquicias.exceptions.FranquiciaServiceException;
import com.co.accenture.franquicias.models.request.NuevaFranquiciaRequest;
import com.co.accenture.franquicias.models.request.NuevaSucursalRequest;
import com.co.accenture.franquicias.models.request.NuevoProductoRequest;
import com.co.accenture.franquicias.models.response.BorrarProductoResponse;
import com.co.accenture.franquicias.models.response.NuevaFranquiciaResponse;
import com.co.accenture.franquicias.models.response.NuevaSucursalResponse;
import com.co.accenture.franquicias.models.response.NuevoProductoResponse;

/**
 * Interfaz servicio de la franquicia
 * 
 * @version 1.0 - 2024/11/28
 * @autor Daniel Garcia
 */
public interface IFranquiciaService {
    ResponseEntity<NuevaFranquiciaResponse> addFranquicia(NuevaFranquiciaRequest body);

    ResponseEntity<NuevaSucursalResponse> addSucursal(NuevaSucursalRequest request) throws FranquiciaServiceException;

    ResponseEntity<NuevoProductoResponse> addProducto(NuevoProductoRequest request) throws FranquiciaServiceException;

    ResponseEntity<BorrarProductoResponse> deleteProducto(int idProducto) throws FranquiciaServiceException;

}
