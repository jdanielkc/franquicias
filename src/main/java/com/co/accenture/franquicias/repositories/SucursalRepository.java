package com.co.accenture.franquicias.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.co.accenture.franquicias.entities.Franquicia;
import com.co.accenture.franquicias.entities.Sucursal;

/**
 * Repositorio de la sucursal
 * 
 * @version 1.0
 * @autor Daniel Garcia
 * @since 2024/11/28
 */
@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {
    List<Sucursal> findByFranquicia(Franquicia franquicia);
}
