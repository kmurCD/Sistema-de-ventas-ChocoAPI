package com.choco.chocoapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;
    @Column(columnDefinition = "CHAR(8)")
    private String codCategoria;
    @Column(columnDefinition = "VARCHAR(100)")
    private String nombreCategoria;
    @Column(columnDefinition = "VARCHAR(100)")
    private String catDescripcion;

    @JsonIgnore
    @JsonManagedReference
    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;



}
