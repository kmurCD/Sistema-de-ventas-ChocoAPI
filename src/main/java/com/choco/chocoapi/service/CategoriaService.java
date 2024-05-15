package com.choco.chocoapi.service;


import com.choco.chocoapi.model.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService  {
    List<Categoria> optenerCategorias();

    Optional<Categoria> optenerCategoria(Long id);

    Categoria guardarCategoria(Categoria categoria);

    Categoria actualizarCategoria(Categoria categoria);

    void eliminarCategoria(Long id);
}
