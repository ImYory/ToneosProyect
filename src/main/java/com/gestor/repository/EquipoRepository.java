package com.gestor.repository;

import com.gestor.entity.Equipo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoRepository extends CrudRepository<Equipo, Integer>{
}
