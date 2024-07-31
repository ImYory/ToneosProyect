package com.gestor.controller;

import com.gestor.entity.Equipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.gestor.service.EquipoServiceImp;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/equipo")
@CrossOrigin(origins="http://localhost:4200")
public class EquipoResource {
    @Autowired
    private EquipoServiceImp equipoServiceImp;

    public EquipoResource(EquipoServiceImp equipoServiceImp) {
        this.equipoServiceImp = equipoServiceImp;
    }

    @PostMapping( value = "/registro", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE } )
    public ResponseEntity<Void> registrarEquipo(@Valid @RequestBody Equipo equipo){
        this.equipoServiceImp.agregarEquipo(equipo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping( value = "/editar", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE } )
    public ResponseEntity<Equipo> editarEquipo(@RequestBody Equipo equipo) throws Exception {
        this.equipoServiceImp.editarEquipo(equipo);
        return new ResponseEntity<Equipo>(equipo, HttpStatus.OK);
    }

    @PostMapping( value = "/eliminar", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE } )
    public ResponseEntity<Void> eliminarEquipo(@RequestBody Integer id) throws Exception{
        this.equipoServiceImp.eliminarEquipo(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
    @GetMapping( value = "/buscarEquipo/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE } )
    public ResponseEntity<Equipo> buscarEquipo(@RequestBody Integer id) throws Exception{
        Equipo e = this.equipoServiceImp.buscarEquipo(id);
        return new ResponseEntity<Equipo>(e, HttpStatus.OK);
    }

    @GetMapping( value = "/listadoEquipo", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE } )
    public ResponseEntity<List<Equipo>> listarEquipo() throws Exception{
        List<Equipo> equipos = new ArrayList<>();
        equipoServiceImp.listarEquipo().forEach(x->{
            equipos.add(x);
        });
        return new ResponseEntity<>(equipos, HttpStatus.OK);
    }

}
