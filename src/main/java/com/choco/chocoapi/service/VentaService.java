package com.choco.chocoapi.service;
import com.choco.chocoapi.model.Venta;
import java.util.List;
import java.util.Optional;


public interface VentaService {

    Venta guardarVenta(Venta ventas);

    Venta actualizarVenta(Venta venta);

    Optional<Venta> obtenerVenta(Long id);

    List<Venta> obtenerVentas();

    void eliminarVenta(Long id);
}
