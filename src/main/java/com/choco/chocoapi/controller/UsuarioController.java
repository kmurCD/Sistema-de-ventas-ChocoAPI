package com.choco.chocoapi.controller;

import com.choco.chocoapi.model.Usuario;
import com.choco.chocoapi.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/usuario")
public class UsuarioController {

    final  UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Usuario>> ObtenerUsuarioPorId(@PathVariable ("id") Long id) {
        try {
           Optional<Usuario> usuario = usuarioService.buscarUsuarioPorID(id);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping
    public ResponseEntity<List<Usuario>> ObtenerTodosLosUsuarios() {
        try {
            List<Usuario> usuarios = usuarioService.buscarTodosUsuarios();
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping
    public ResponseEntity<Usuario> CrearUsuario(@RequestBody Usuario usuario) {
        try {
            Usuario usuarioAgregado = usuarioService.crearUsuario(usuario);
            return new ResponseEntity<>(usuarioAgregado, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> ActualizarUsuario(@PathVariable ("id") Long id, @RequestBody Usuario usuario) {
        try {
            usuario.setIdUsuario(id);
           Usuario usuarioActualizado = usuarioService.actualizarUsuario(usuario);
            return new ResponseEntity<>(usuarioActualizado, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> EliminarUsuarioPorId( @PathVariable Long id) {
        try {
            usuarioService.eliminarUsuario(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
