package com.choco.chocoapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(columnDefinition = "VARCHAR(50)")
    private String nombre;

    @Column(columnDefinition = "VARCHAR(50)")
    private String apellidos;

    @Column(columnDefinition = "VARCHAR(50)",unique = true)
    private String correo;

    @Column(columnDefinition = "VARCHAR(50)")
    private String contrasenia;

    @Column(columnDefinition = "CHAR(9)", unique = true)
    private String dni;

    @Column(columnDefinition = "CHAR(9)")
    private String telefono;

    @Column(columnDefinition = "VARCHAR(100)")
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "tipousuario_id")
    private TipoUsuario tipousuario;

}


