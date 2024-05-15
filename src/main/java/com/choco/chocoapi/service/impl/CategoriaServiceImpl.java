package com.choco.chocoapi.service.impl;

import com.choco.chocoapi.model.Categoria;
import com.choco.chocoapi.repository.CategoriaRepository;
import com.choco.chocoapi.service.CategoriaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;
    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }
    //OBTENER "CATEGORIA"//
    @Override
    public List<Categoria> optenerCategorias() {
        return categoriaRepository.findAll();
    }
    //OBTENER "CATEGORIAS"//
    @Override
    public Optional<Categoria> optenerCategoria(Long id) {
        return categoriaRepository.findById(id);
    }
    //GUARDAR "CATEGORIA"//
    @Override
    public Categoria guardarCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }
    //ACTUALIZAR "CATEGORIA"//
    @Override
    public Categoria actualizarCategoria(Categoria categoria){
        if (!categoriaRepository.existsById((long) categoria.getIdCategoria())) {
            throw new IllegalArgumentException("La categoria con el ID especificado no existe.");
        }
        return categoriaRepository.save(categoria);
    }
    //ELIMINAR "CATEGORIA"//
    @Override
    public void eliminarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}
