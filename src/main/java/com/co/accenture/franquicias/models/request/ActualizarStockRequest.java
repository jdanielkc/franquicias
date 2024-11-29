package com.co.accenture.franquicias.models.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que representa la petición para actualizar el stock de un producto
 * 
 * @version 1.0
 * @autor Daniel Garcia
 * @since 2024/11/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActualizarStockRequest {
    private int nuevoStock;
}
