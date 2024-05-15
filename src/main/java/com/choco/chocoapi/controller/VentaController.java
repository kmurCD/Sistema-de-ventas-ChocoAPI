package com.choco.chocoapi.controller;
import com.choco.chocoapi.model.Venta;
import com.choco.chocoapi.service.VentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ventas")
public class VentaController {
    private final VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @GetMapping
    public ResponseEntity<List<Venta>> listarVentas() {
        try {
            List<Venta> listVenta = ventaService.obtenerVentas();
            return new ResponseEntity<>(listVenta, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Venta>> obtenerVentaPorId(@PathVariable("id") Long id) {
        try {
            Optional<Venta> venta = ventaService.obtenerVenta(id);
            return new ResponseEntity<>(venta, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping
    public ResponseEntity<Venta> crearVenta(@RequestBody Venta venta) {
        try {
            Venta newVenta = ventaService.guardarVenta(venta);
            return new ResponseEntity<>(newVenta, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println("Error al guardar venta");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venta> editarVenta(@PathVariable("id") Long id, @RequestBody Venta venta) {
        try {
            venta.setIdVenta(id);
            Venta ventaActualizada = ventaService.actualizarVenta(venta);
            return ResponseEntity.ok(ventaActualizada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVentaPorId(@PathVariable("id") Long id) {
        try {
            ventaService.eliminarVenta(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // Método para obtener las ventas por un usuario específico
//    @GetMapping("/usuario/{idUsuario}")
//    public ResponseEntity<List<Venta>> obtenerVentasPorUsuario(@PathVariable("idUsuario") Long idUsuario) {
//        try {
//            List<Venta> ventas = ventaService.obtenerVentasPorUsuario(idUsuario);
//            return new ResponseEntity<>(ventas, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

    // Método para obtener las ventas por un rango de fechas
//    @GetMapping("/rango-fechas/{fechaInicio}/{fechaFin}")
//    public ResponseEntity<List<Venta>> obtenerVentasPorRangoFechas(@PathVariable("fechaInicio") String fechaInicio,
//                                                                   @PathVariable("fechaFin") String fechaFin) {
//        try {
//            List<Venta> ventas = ventaService.obtenerVentasPorRangoFechas(fechaInicio, fechaFin);
//            return new ResponseEntity<>(ventas, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
}
