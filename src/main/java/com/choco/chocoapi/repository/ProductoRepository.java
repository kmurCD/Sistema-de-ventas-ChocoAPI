package com.choco.chocoapi.repository;


import com.choco.chocoapi.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

     List<Producto> findProductosByCategoria_nombreCategoria(String nombreCategoria);

}
