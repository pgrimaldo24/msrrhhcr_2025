package com.gestionhumana.create.msrrhhcr.services.implementations;

import com.gestionhumana.create.msrrhhcr.dto.ResponseDTO;
import com.gestionhumana.create.msrrhhcr.dto.UsuarioDTO;
import com.gestionhumana.create.msrrhhcr.entities.Usuario;
import com.gestionhumana.create.msrrhhcr.repositories.UsuarioRepository;
import com.gestionhumana.create.msrrhhcr.services.interfaces.IUsuarioServices;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Transactional
@Slf4j
public class UsuarioServices implements IUsuarioServices {

    private final UsuarioRepository usuarioRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public UsuarioServices(UsuarioRepository  usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public ResponseDTO CrearUsuario(UsuarioDTO usuario) {
        if(Objects.isNull(usuario)){
            return new ResponseDTO(404, "No se puede crear el usuario´, inténtalo de nuevo.");
        }
        Usuario user = new Usuario();
        user.setUsuario(usuario.getUsuario());
        user.setPassword(usuario.getPassword());
        user.setNombres(usuario.getNombre());
        user.setApellido_paterno(usuario.getApellido_paterno());
        user.setApellido_materno(usuario.getApellido_materno());
        user.setCorreo(usuario.getCorreo());
        user.setDireccion(usuario.getDireccion());
        user.setCelular(usuario.getCelular());
        user.setActivo(true);
        this.usuarioRepository.save(user);
        return new ResponseDTO(201,"El usuario se registró correctamente.");
    }
}
