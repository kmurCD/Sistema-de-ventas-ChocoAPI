package com.choco.chocoapi.service.impl;


import com.choco.chocoapi.model.Categoria;
import com.choco.chocoapi.model.Producto;
import com.choco.chocoapi.repository.CategoriaRepository;
import com.choco.chocoapi.repository.ProductoRepository;
import com.choco.chocoapi.service.ProductoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {
    // Inicializacion  del repositorio
    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

    //Inyeccion del repositorio
    public ProductoServiceImpl(ProductoRepository productoRepository, CategoriaRepository categoriaRepository) {
        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
    }
    //metodo para guardar un "Producto"
    @Override
    public Producto GuardarProducto(Producto producto) {

        return productoRepository.save(producto);
    }
    //metodo para actualizar un "Producto"
    @Override
    public Producto ActualizarProducto(Producto producto) {
        if (!productoRepository.existsById(producto.getIdProducto())) {
            throw new IllegalArgumentException("El Producto con el ID especificado no existe.");
        }

        return productoRepository.save(producto);
    }
    //metodo para obtener un "Producto"
    @Override
    public Optional<Producto> ObtenerProducto(Long id) {
        Optional<Producto> producto = productoRepository.findById(id);
        if (producto.isPresent()) {
            return producto;
        } else {
            throw new IllegalArgumentException("No se encontró el producto con ID: " + id);
        }
    }
    //metodo para listar todos los  "Productos"
    @Override
    public List<Producto> ObtenerProductos() {
        return productoRepository.findAll();
    }
    //metodo para obtener varios "Productos" segun la "Categoria"
    @Override
    public List<Producto> ObtenerProductosPorCategoria(String categoria) {
        return productoRepository.findProductosByCategoria_nombreCategoria(categoria);
    }
    @Override
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }


    private void validarProducto(Producto producto) {

        if (producto.getNombre() == null || producto.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede ser vacio.");
        }
        if (producto.getDescripcion() == null || producto.getDescripcion().isEmpty()) {
            throw new IllegalArgumentException("El descripcion del producto no puede ser vacio.");
        }
        if (producto.getCategoria() == null ) {
            throw new IllegalArgumentException("No se puede eliminar el producto.");
        }
        if (producto.getPrecio() <=0) {
            throw new IllegalArgumentException("No se puede eliminar el producto.");
        }
        if (producto.getStock() <=0) {
            throw new IllegalArgumentException("No se puede eliminar el producto.");
        }
    }

}
