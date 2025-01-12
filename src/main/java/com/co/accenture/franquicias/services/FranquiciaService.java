package com.co.accenture.franquicias.services;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.co.accenture.franquicias.entities.Franquicia;
import com.co.accenture.franquicias.entities.Producto;
import com.co.accenture.franquicias.entities.Sucursal;
import com.co.accenture.franquicias.exceptions.FranquiciaServiceException;
import com.co.accenture.franquicias.exceptions.NombreDuplicadoException;
import com.co.accenture.franquicias.models.request.ActualizarFranqRequest;
import com.co.accenture.franquicias.models.request.ActualizarProdRequest;
import com.co.accenture.franquicias.models.request.ActualizarStockRequest;
import com.co.accenture.franquicias.models.request.ActualizarSucuResquest;
import com.co.accenture.franquicias.models.request.NuevaFranquiciaRequest;
import com.co.accenture.franquicias.models.request.NuevaSucursalRequest;
import com.co.accenture.franquicias.models.request.NuevoProductoRequest;
import com.co.accenture.franquicias.models.response.ActualizarFranqResponse;
import com.co.accenture.franquicias.models.response.ActualizarProdResponse;
import com.co.accenture.franquicias.models.response.ActualizarStockResponse;
import com.co.accenture.franquicias.models.response.ActualizarSucuResponse;
import com.co.accenture.franquicias.models.response.BorrarProductoResponse;
import com.co.accenture.franquicias.models.response.NuevaFranquiciaResponse;
import com.co.accenture.franquicias.models.response.NuevaSucursalResponse;
import com.co.accenture.franquicias.models.response.NuevoProductoResponse;
import com.co.accenture.franquicias.models.response.ProductoMayorStockResponse;
import com.co.accenture.franquicias.repositories.FranquiciaRepository;
import com.co.accenture.franquicias.repositories.ProductoRepository;
import com.co.accenture.franquicias.repositories.SucursalRepository;

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

    /**
     * Método que permite eliminar un producto
     * 
     * @param idProducto
     * @return ResponseEntity<BorrarProductoResponse>
     * @throws FranquiciaServiceException
     */
    @Override
    @Transactional
    public ResponseEntity<BorrarProductoResponse> deleteProducto(int idProducto)
            throws FranquiciaServiceException {
        // Obtener producto por id
        Producto producto = productoRepository.findById(idProducto)
                .orElseThrow(() -> new FranquiciaServiceException("El producto a eliminar no existe", "El producto a eliminar no existe"));

        // Eliminar producto
        productoRepository.delete(producto);
        StringBuilder mensaje = new StringBuilder();
        mensaje.append("El producto ");
        mensaje.append(producto.getNombre());
        mensaje.append(" ha sido eliminado exitosamente");
        return ResponseEntity.status(HttpStatus.OK).body(new BorrarProductoResponse(mensaje.toString()));
    }

    /**
     * Método que permite actualizar el stock de un producto
     * 
     * @param idProducto
     * @param body
     * @return ResponseEntity<ActualizarStockResponse>
     * @throws FranquiciaServiceException
     * @throws NumberFormatException
     */
    @Override
    @Transactional
    public ResponseEntity<ActualizarStockResponse> actualizarStock(String idProducto, ActualizarStockRequest body) throws FranquiciaServiceException {
        // obtener producto por id
        Producto producto = productoRepository.findById(Integer.parseInt(idProducto))
                .orElseThrow(() -> new FranquiciaServiceException("El producto no existe", "El producto no existe"));

        // Actualizar stock
        producto.setStock(body.getNuevoStock());
        productoRepository.save(producto);

        StringBuilder mensaje = new StringBuilder();
        mensaje.append("El stock del producto ");
        mensaje.append(producto.getNombre());
        mensaje.append(" fue sido actualizado a ");
        mensaje.append(producto.getStock());
        return ResponseEntity.status(HttpStatus.OK).body(new ActualizarStockResponse(mensaje.toString()));
    }

    /**
     * Método que permite obtener el producto con mayor stock por sucursal
     * 
     * @param idFranquicia
     * @return ResponseEntity<List<ProductoMayorStockResponse>>
     * @throws FranquiciaServiceException
     */
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<List<ProductoMayorStockResponse>> obtenerProductoMayorStockPorSucursal(int idFranquicia) throws FranquiciaServiceException {
        // Verificar que la franquicia existe
        if (!franquiciaRepository.existsById(idFranquicia)) {
            throw new FranquiciaServiceException("La franquicia especificada no existe", "La franquicia especificada no existe");
        }
        // Obtener los productos con mayor stock por sucursal
        List<ProductoMayorStockResponse> resultado = productoRepository.findProductosMayorStockPorFranquicia(idFranquicia);
        return ResponseEntity.status(HttpStatus.OK).body(resultado);
    }

    /**
     * Método que permite actualizar el nombre de una franquicia
     * 
     * @param idFranquicia
     * @param body
     * @return ResponseEntity<ActualizarFranqResponse>
     * @throws FranquiciaServiceException
     */
    @Override
    @Transactional
    public ResponseEntity<ActualizarFranqResponse> actualizarNombreFranq(String idFranquicia,
            ActualizarFranqRequest body) throws FranquiciaServiceException {
        // Obtener franquicia por id
        Franquicia franquicia = franquiciaRepository.findById(Integer.parseInt(idFranquicia))
                .orElseThrow(() -> new FranquiciaServiceException("La franquicia a actualizar no existe", "La franquicia a actualizar no existe"));
        String nombreAnterior = franquicia.getNombre();
        // Actualizar nombre
        
        franquicia.setNombre(body.getNuevoNombre());
        franquiciaRepository.save(franquicia);

        StringBuilder mensaje = new StringBuilder();
        mensaje.append("El nombre de la franquicia ");
        mensaje.append(nombreAnterior);
        mensaje.append(" fue sido actualizado a ");
        mensaje.append(franquicia.getNombre());
        return ResponseEntity.status(HttpStatus.OK).body(new ActualizarFranqResponse(mensaje.toString()));
    }

    /**
     * Método que permite actualizar el nombre de una sucursal
     * 
     * @param idSucursal
     * @param body
     * @return ResponseEntity<ActualizarSucuResponse>
     * @throws FranquiciaServiceException
     */
    @Override
    @Transactional
    public ResponseEntity<ActualizarSucuResponse> actualizarNombreSucu(String idSucursal, ActualizarSucuResquest body)
            throws FranquiciaServiceException {
        // Obtener sucursal por id
        Sucursal sucursal = sucursalRepository.findById(Integer.parseInt(idSucursal))
                .orElseThrow(() -> new FranquiciaServiceException("La sucursal a actualizar no existe", "La sucursal a actualizar no existe"));
        
        String nombreAnterior = sucursal.getNombre();
        // Actualizar nombre
        sucursal.setNombre(body.getNuevoNombre());
        sucursalRepository.save(sucursal);

        StringBuilder mensaje = new StringBuilder();
        mensaje.append("El nombre de la sucursal ");
        mensaje.append(nombreAnterior);
        mensaje.append(" ha sido actualizado a ");
        mensaje.append(sucursal.getNombre());
        return ResponseEntity.status(HttpStatus.OK).body(new ActualizarSucuResponse(mensaje.toString()));
    }

    /**
     * Método que permite actualizar el nombre de un producto
     * 
     * @param id
     * @param body
     * @return ResponseEntity<ActualizarProdResponse>
     * @throws FranquiciaServiceException
     */
    @Override
    @Transactional
    public ResponseEntity<ActualizarProdResponse> actualizarNombreProd(String id, ActualizarProdRequest body) throws FranquiciaServiceException {
        
        // Obtener producto por id
        Producto producto = productoRepository.findById(Integer.parseInt(id))
                .orElseThrow(() -> new FranquiciaServiceException("El producto a actualizar no existe", "El producto a actualizar no existe"));
        String nombreAnterior = producto.getNombre();

        // Actualizar nombre
        producto.setNombre(body.getNuevoNombre());
        productoRepository.save(producto);

        StringBuilder mensaje = new StringBuilder();
        mensaje.append("El nombre del producto ");
        mensaje.append(nombreAnterior);
        mensaje.append(" ha sido actualizado a ");
        mensaje.append(producto.getNombre());
        return ResponseEntity.status(HttpStatus.OK).body(new ActualizarProdResponse(mensaje.toString()));
    }
}
