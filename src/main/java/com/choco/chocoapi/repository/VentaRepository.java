package com.choco.chocoapi.repository;

import com.choco.chocoapi.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long>  {
    public Venta save(Venta venta);


}
