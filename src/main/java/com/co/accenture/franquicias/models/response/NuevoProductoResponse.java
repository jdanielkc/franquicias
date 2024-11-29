package com.co.accenture.franquicias.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que representa la respuesta de un nuevo producto
 * 
 * @version 1.0
 * @autor Daniel Garcia
 * @since 2024/11/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NuevoProductoResponse {
    private String mensaje;
    private int idProducto;
    
}
