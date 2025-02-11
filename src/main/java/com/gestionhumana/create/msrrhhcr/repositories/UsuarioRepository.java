package com.gestionhumana.create.msrrhhcr.repositories;

import com.gestionhumana.create.msrrhhcr.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
