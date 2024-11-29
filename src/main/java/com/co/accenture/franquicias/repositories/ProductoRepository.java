package com.co.accenture.franquicias.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.co.accenture.franquicias.entities.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
