package com.choco.chocoapi.controller;

import com.choco.chocoapi.model.Producto;
import com.choco.chocoapi.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    //inicializacion de productoServicio
    final ProductoService productoService;

    //Inyeccion de productoServicio
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }
    //LISTAR PRODUCTOS//
    @GetMapping
    public ResponseEntity<List<Producto>> listarProductos() {
        try {
            List<Producto> listProducto = productoService.ObtenerProductos();
            //Respuesta Http 200 si todo esta bien
            return new ResponseEntity<>(listProducto, HttpStatus.OK);
        } catch (Exception e) {
            //Respuesta Http 400 si ocurre algun error
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    //OBTENER PRODUCTO//
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Producto>> obtenerProductoPorId(@PathVariable("id") Long id) {
        try {
            Optional<Producto> producto = productoService.ObtenerProducto(id);
            //Respuesta Http 200 si se obtuvo un producto
            return new ResponseEntity<>(producto, HttpStatus.OK);
        } catch (Exception e) {
            //Respuesta Http 400 si ocurre algun error
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    //OBTENER PRODUCTO POR CATEGORIA//
    @GetMapping("/categoria")
    public ResponseEntity<List<Producto>> optenerProductoPorCategoria(@RequestParam("categoria") String categoria) {
    try {
        List<Producto> listProductoPorCategoria = productoService.ObtenerProductosPorCategoria(categoria);
        //Respuesta Http 200 si se obtuvo los productos por categoria
        return ResponseEntity.ok(listProductoPorCategoria);
    }catch (Exception e) {
        //Respuesta Http 400 si ocurre algun error
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    //CREAR PRODUCTO//
    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        try {
            //Respuesta Http 201 si se creo el producto
            Producto newProducto = productoService.GuardarProducto(producto);
            return new ResponseEntity<>(newProducto,HttpStatus.OK);
        } catch (Exception e) {
            //Respuesta Http 400 si ocurre algun error
            System.out.println("Error al guardar producto");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }
    //ACTUALIZAR PRODUCTO//
    @PutMapping("/{id}")
    public ResponseEntity<Producto> editarProducto(@PathVariable("id") Long id, @RequestBody Producto producto) {
        try {
            //Respuesta Http 200 si se creo el producto
            producto.setIdProducto(id);
            Producto productoActualizado = productoService.ActualizarProducto(producto);
            return ResponseEntity.ok(productoActualizado);
        } catch (Exception e) {
            //Respuesta Http 400 si ocurre algun error
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    //ELIMINAR PRODUCTO//
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductoPorId(@PathVariable("id") Long id) {
        try {
            //Respuesta Http 204 si elimino el producto
            productoService.eliminarProducto(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            //Respuesta Http 400 si ocurre algun error
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


}
