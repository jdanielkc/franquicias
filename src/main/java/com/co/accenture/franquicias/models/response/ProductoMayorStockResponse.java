package com.co.accenture.franquicias.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que representa la respuesta de un producto con mayor stock
 * 
 * @version 1.0
 * @autor Daniel Garcia
 * @since 2024/11/28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoMayorStockResponse {
    private int idProducto;
    private String nombreProducto;
    private int stock;
    private int idSucursal;
    private String nombreSucursal;
}
