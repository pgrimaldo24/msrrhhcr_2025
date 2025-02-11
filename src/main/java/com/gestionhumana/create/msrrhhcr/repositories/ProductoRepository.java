package com.gestionhumana.create.msrrhhcr.repositories;

import com.gestionhumana.create.msrrhhcr.entities.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Productos, Long> {
}
