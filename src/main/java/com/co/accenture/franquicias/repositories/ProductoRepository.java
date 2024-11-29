package com.co.accenture.franquicias.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.co.accenture.franquicias.entities.Producto;
import com.co.accenture.franquicias.entities.Sucursal;
import com.co.accenture.franquicias.models.response.ProductoMayorStockResponse;

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

    @Query("SELECT new com.co.accenture.franquicias.models.response.ProductoMayorStockResponse(p.id, p.nombre, p.stock, s.id, s.nombre) " +
            "FROM Producto p JOIN p.sucursal s JOIN s.franquicia f " +
            "WHERE f.id = :idFranquicia AND p.id IN (" +
            "    SELECT p2.id FROM Producto p2 " +
            "    WHERE p2.sucursal.id = s.id AND p2.stock = (" +
            "        SELECT MAX(p3.stock) FROM Producto p3 WHERE p3.sucursal.id = s.id" +
            "    )" +
            ")")
    List<ProductoMayorStockResponse> findProductosMayorStockPorFranquicia(@Param("idFranquicia") int idFranquicia);
}
