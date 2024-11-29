package com.co.accenture.franquicias.services;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.co.accenture.franquicias.entities.Franquicia;
import com.co.accenture.franquicias.entities.Producto;
import com.co.accenture.franquicias.entities.Sucursal;
import com.co.accenture.franquicias.exceptions.FranquiciaServiceException;
import com.co.accenture.franquicias.exceptions.NombreDuplicadoException;
import com.co.accenture.franquicias.models.request.NuevaFranquiciaRequest;
import com.co.accenture.franquicias.models.request.NuevaSucursalRequest;
import com.co.accenture.franquicias.models.request.NuevoProductoRequest;
import com.co.accenture.franquicias.models.response.NuevaFranquiciaResponse;
import com.co.accenture.franquicias.models.response.NuevaSucursalResponse;
import com.co.accenture.franquicias.models.response.NuevoProductoResponse;
import com.co.accenture.franquicias.repositories.FranquiciaRepository;
import com.co.accenture.franquicias.repositories.ProductoRepository;
import com.co.accenture.franquicias.repositories.SucursalRepository;

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
    private final SucursalRepository sucursalRepository;
    private final ProductoRepository productoRepository;

    /**
     * Método que permite agregar una nueva franquicia
     * 
     * @param request
     * @return ResponseEntity<NuevaFranquiciaResponse>
     * @throws NombreDuplicadoException
     */
    @Override
    @Transactional
    public ResponseEntity<NuevaFranquiciaResponse> addFranquicia(NuevaFranquiciaRequest request) {

        try {
            Franquicia franquicia = new Franquicia();
            franquicia.setNombre(request.getNombre());
            franquiciaRepository.save(franquicia);

            StringBuilder mensaje = new StringBuilder();
            mensaje.append("La franquicia ");
            mensaje.append(franquicia.getNombre());
            mensaje.append(" ha sido creada exitosamente");
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new NuevaFranquiciaResponse(mensaje.toString(), franquicia.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new NombreDuplicadoException(e.getMessage(), "La franquicia ya existe");
        }
    }

    /**
     * Método que permite agregar una nueva sucursal
     * 
     * @param request
     * @return ResponseEntity<NuevaSucursalResponse>
     * @throws FranquiciaServiceException
     * @throws NombreDuplicadoException
     */
    @Override
    @Transactional
    public ResponseEntity<NuevaSucursalResponse> addSucursal(NuevaSucursalRequest request)
            throws FranquiciaServiceException {
        try {
            // Obtener franquicia por id
            Franquicia franquicia = franquiciaRepository.findById(request.getIdFranquicia())
                    .orElseThrow(
                            () -> new FranquiciaServiceException("La franquicia no existe", "La franquicia no existe"));

            // Crear sucursal
            Sucursal sucursal = new Sucursal();
            sucursal.setNombre(request.getNombre());
            sucursal.setFranquicia(franquicia);
            sucursalRepository.save(sucursal);

            StringBuilder mensaje = new StringBuilder();
            mensaje.append("La sucursal ");
            mensaje.append(sucursal.getNombre());
            mensaje.append(" ha sido creada exitosamente");
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new NuevaSucursalResponse(mensaje.toString(), sucursal.getId()));

        } catch (DataIntegrityViolationException e) {
            throw new NombreDuplicadoException(e.getMessage(), "La sucursal ya existe");
        }
    }

    /**
     * Método que permite agregar un nuevo producto
     * 
     * @param request
     * @return ResponseEntity<NuevoProductoResponse>
     * @throws FranquiciaServiceException
     * @throws NombreDuplicadoException
     */
    @Override
    @Transactional
    public ResponseEntity<NuevoProductoResponse> addProducto(NuevoProductoRequest request)
            throws FranquiciaServiceException {
        // Obtener sucursal por id
        try {
            Sucursal sucursal = sucursalRepository.findById(request.getIdSucursal())
                    .orElseThrow(
                            () -> new FranquiciaServiceException("La sucursal no existe", "La sucursal no existe"));

            // Crear producto
            Producto producto = new Producto();
            producto.setNombre(request.getNombre());
            producto.setStock(request.getStock());
            producto.setSucursal(sucursal);
            productoRepository.save(producto);

            StringBuilder mensaje = new StringBuilder();
            mensaje.append("El producto ");
            mensaje.append(producto.getNombre());
            mensaje.append(" ha sido creado exitosamente  en la sucursal ");
            mensaje.append(sucursal.getNombre());
            mensaje.append(" con stock de ");
            mensaje.append(producto.getStock());
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new NuevoProductoResponse(mensaje.toString(), producto.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new NombreDuplicadoException(e.getMessage(), "El producto ya existe");
        }
    }
}
