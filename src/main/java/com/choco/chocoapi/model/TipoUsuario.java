package com.choco.chocoapi.model;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TipoUsuario {
    @Id
    private Long idTipoUsuario;
    private String tipo;
    private String descripcion;
}
