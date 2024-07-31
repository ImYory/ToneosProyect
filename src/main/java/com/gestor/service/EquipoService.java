package com.gestor.service;

import com.gestor.entity.Equipo;

import java.util.List;

public interface EquipoService {
    public void agregarEquipo(Equipo equipo);
    public List<Equipo> listarEquipo();
    public void editarEquipo(Equipo equipo) throws Exception;
    public void eliminarEquipo(int id) throws Exception;

    public Equipo buscarEquipo(int id) throws Exception;
}
