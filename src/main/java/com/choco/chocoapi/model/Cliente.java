package com.choco.chocoapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cliente {
    @Id
    private Long idCLiente;
    private String nombre;
    private String apellidos;
    private String dni;
    private String direccion;
}
