package com.gestor.service;

import com.gestor.entity.Equipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gestor.repository.EquipoRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EquipoServiceImp implements EquipoService{
    @Autowired
    private EquipoRepository equipoRepository;

    public EquipoServiceImp(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }


    @Override
    public void agregarEquipo(Equipo equipo) {
        equipoRepository.save(equipo);
    }

    @Override
    public List<Equipo> listarEquipo() {
        List<Equipo> listado = new ArrayList<Equipo>();
        for (Equipo equipo : equipoRepository.findAll()) {
            listado.add(equipo);
        }
        return listado;
    }

    @Override
    public void editarEquipo(Equipo equipo) throws Exception {
        try {
            Equipo equipoBuscado  = this.buscarEquipo(equipo.getId());
            equipoBuscado.setNombre(equipo.getNombre());
            equipoBuscado.setRepresentante(equipo.getRepresentante());
            equipoBuscado.setPuntos(equipo.getPuntos());
            equipoRepository.save(equipoBuscado);
        } catch (Exception e) {
            throw new Exception("El equipo que quiere editar no existe");
        }
    }

    @Override
    public void eliminarEquipo(int id) throws Exception {
        try {
            Equipo equipoBuscado = this.buscarEquipo(id);
            equipoRepository.delete(equipoBuscado);
        }catch (Exception e){
            throw new Exception("La persona no existe");
        }
    }

    @Override
    public Equipo buscarEquipo(int id) throws Exception{
        Optional<Equipo> optEquipo = equipoRepository.findById(id);
        if (optEquipo.isEmpty()){
            throw new Exception("El equipo no existe");
        }
        return optEquipo.get();
    }
}
