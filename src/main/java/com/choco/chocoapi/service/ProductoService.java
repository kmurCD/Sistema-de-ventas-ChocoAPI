package com.choco.chocoapi.service;


import com.choco.chocoapi.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    Producto GuardarProducto(Producto producto);

    Producto ActualizarProducto(Producto producto);

    Optional<Producto> ObtenerProducto(Long id);

    List<Producto> ObtenerProductos();

    //metodo para obtener varios "Productos" segun la "Categoria"
    List<Producto> ObtenerProductosPorCategoria(String categoria);

    void eliminarProducto(Long id);
}
