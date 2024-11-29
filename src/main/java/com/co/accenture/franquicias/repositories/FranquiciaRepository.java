package com.co.accenture.franquicias.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.co.accenture.franquicias.entities.Franquicia;

/**
 * Repositorio de la franquicia
 * 
 * @version 1.0
 * @autor Daniel Garcia
 * @since 2024/11/28
 */
@Repository
public interface FranquiciaRepository extends JpaRepository<Franquicia, Integer> {

}
