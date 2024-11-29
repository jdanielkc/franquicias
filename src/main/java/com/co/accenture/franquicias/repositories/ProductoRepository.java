package com.co.accenture.franquicias.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.co.accenture.franquicias.entities.Producto;
import com.co.accenture.franquicias.entities.Sucursal;

/**
 * Repositorio del producto
 * 
 * @version 1.0
 * @autor Daniel 
 * @since 2024/11/28
 */
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    Optional<Producto> findTopBySucursalOrderByStockDesc(Sucursal sucursal);
}
