package com.co.accenture.franquicias.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.co.accenture.franquicias.exceptions.FranquiciaServiceException;
import com.co.accenture.franquicias.models.request.ActualizarStockRequest;
import com.co.accenture.franquicias.models.request.NuevaFranquiciaRequest;
import com.co.accenture.franquicias.models.request.NuevaSucursalRequest;
import com.co.accenture.franquicias.models.request.NuevoProductoRequest;
import com.co.accenture.franquicias.models.response.ActualizarStockResponse;
import com.co.accenture.franquicias.models.response.BorrarProductoResponse;
import com.co.accenture.franquicias.models.response.NuevaFranquiciaResponse;
import com.co.accenture.franquicias.models.response.NuevaSucursalResponse;
import com.co.accenture.franquicias.models.response.NuevoProductoResponse;
import com.co.accenture.franquicias.models.response.ProductoMayorStockResponse;

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

    ResponseEntity<ActualizarStockResponse> actualizarStock(String idProducto, ActualizarStockRequest body)
            throws FranquiciaServiceException;

    ResponseEntity<List<ProductoMayorStockResponse>> obtenerProductoMayorStockPorSucursal(int idFranquicia) throws FranquiciaServiceException;

}
