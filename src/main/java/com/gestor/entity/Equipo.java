package com.gestor.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "equipo")
public class Equipo {
    @Id
    private int id;

    private String nombre;

    private String representante;

    private int puntos;
}
