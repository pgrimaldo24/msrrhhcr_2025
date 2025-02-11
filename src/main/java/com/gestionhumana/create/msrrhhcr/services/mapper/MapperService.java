package com.gestionhumana.create.msrrhhcr.services.mapper;

import com.gestionhumana.create.msrrhhcr.dto.ProductoDTO;
import com.gestionhumana.create.msrrhhcr.entities.Productos;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MapperService {

    @Autowired
    private ModelMapper modelMapper;

    public <D, E> D map(E entity, Class<D> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    public <D, E> List<D> mapList(List<E> entityList, Class<D> dtoClass) {
        return entityList.stream()
                .map(entity -> map(entity, dtoClass))
                .collect(Collectors.toList());
    }

    public void ProductosMapping() {
        modelMapper.typeMap(Productos.class, ProductoDTO.class)
                .addMappings(mapper -> {
                    mapper.map(Productos::getNombreProducto, ProductoDTO::setNombreProducto);
                    mapper.map(Productos::getStock, ProductoDTO::setStock);
                    mapper.map(Productos::getPrecio, ProductoDTO::setPrecio);
                    mapper.map(Productos::getDescripcionProducto, ProductoDTO::setDescripcionProducto);
                    mapper.map(Productos::getDescuentoProducto, ProductoDTO::setDescuentoProducto);
                    mapper.map(Productos::getUrlimg, ProductoDTO::setUrlimg);
                });
    }
}
