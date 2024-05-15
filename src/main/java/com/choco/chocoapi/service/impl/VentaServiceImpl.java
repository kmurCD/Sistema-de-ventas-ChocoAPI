package com.choco.chocoapi.service.impl;

import com.choco.chocoapi.model.Venta;
import com.choco.chocoapi.repository.VentaRepository;
import com.choco.chocoapi.service.VentaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaServiceImpl implements VentaService {
    private final VentaRepository ventaRepository;

    public VentaServiceImpl(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    @Override
    public Venta guardarVenta(Venta ventas) {
        return ventaRepository.save(ventas);
    }


    @Override
    public Venta actualizarVenta(Venta venta) {
        if (!ventaRepository.existsById(venta.getIdVenta())) {
            throw new IllegalArgumentException("La venta con el ID especificado no existe.");
        }
        return ventaRepository.save(venta);
    }

    @Override
    public Optional<Venta> obtenerVenta(Long id) {
        Optional<Venta> venta = ventaRepository.findById(id);
        if (venta.isPresent()) {
            return venta;
        } else {
            throw new IllegalArgumentException("No se encontró la venta con ID: " + id);
        }
    }

    @Override
    public List<Venta> obtenerVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public void eliminarVenta(Long id) {
        ventaRepository.deleteById(id);
    }


}
