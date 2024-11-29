package com.co.accenture.franquicias.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que representa la respuesta de la actualización del stock de un producto
 * 
 * @version 1.0
 * @autor Daniel Garcia
 * @since 2024/11/28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActualizarStockResponse {
    private String mensaje;
}
