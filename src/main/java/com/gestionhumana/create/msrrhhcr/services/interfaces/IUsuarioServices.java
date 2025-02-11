package com.gestionhumana.create.msrrhhcr.services.interfaces;

import com.gestionhumana.create.msrrhhcr.dto.ResponseDTO;
import com.gestionhumana.create.msrrhhcr.dto.UsuarioDTO;

public interface IUsuarioServices {
    ResponseDTO CrearUsuario(UsuarioDTO  usuario);
}
